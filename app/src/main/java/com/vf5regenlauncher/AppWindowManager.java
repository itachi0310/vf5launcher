package com.vf5regenlauncher;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Window/Task controller for the launcher.
 *
 * Goal:
 *   - No PIP.
 *   - Launch external applications into the upper application region.
 *   - Keep the launcher task available as the lower launcher region when the
 *     device/OEM permits split-screen or hidden ActivityTaskManager control.
 *
 * Android 10 notes:
 *   - Public ActivityOptions#setLaunchBounds is used as the first launch hint.
 *   - Hidden ActivityTaskManager APIs are attempted by reflection.
 *   - These hidden APIs normally require MANAGE_ACTIVITY_STACKS / system-level
 *     privileges. A rooted device alone does not automatically grant those
 *     permissions to a normal APK.
 *   - If the hidden API is rejected, the class falls back to launch bounds and
 *     reports the failure in logcat.
 *
 * This class deliberately contains no PIP property/broadcast handling.
 */
public class AppWindowManager {

    private static final String TAG = "AppWindowManager";

    private static final float APP_HEIGHT_RATIO = 0.70f;
    private static final long APPLY_DELAY_MS = 350L;

    // Android 10 WindowConfiguration values.
    private static final int WINDOWING_MODE_FULLSCREEN = 1;
    private static final int WINDOWING_MODE_PINNED = 2;
    private static final int WINDOWING_MODE_SPLIT_SCREEN_PRIMARY = 3;
    private static final int WINDOWING_MODE_SPLIT_SCREEN_SECONDARY = 4;
    private static final int WINDOWING_MODE_FREEFORM = 5;

    // Android 10 ActivityTaskManager constants.
    private static final int SPLIT_SCREEN_CREATE_MODE_TOP_OR_LEFT = 0;
    private static final int SPLIT_SCREEN_CREATE_MODE_BOTTOM_OR_RIGHT = 1;
    private static final int RESIZE_MODE_PRESERVE_WINDOW = 1;

    private final Activity launcherActivity;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    private String currentPackage;
    private Rect lastAppBounds;
    private boolean applyingLayout;

    public AppWindowManager(Activity activity) {
        this.launcherActivity = activity;
    }

    /**
     * Called from launcher onCreate after the launcher view exists.
     */
    public void init() {
        logDisplayInfo();
        logTaskInfo("init");
    }

    /**
     * Called whenever launcher resumes.
     *
     * We do not hide/show PIP. We only try to restore the task/window layout.
     */
    public void onResume() {
        Log.d(TAG, "onResume - restoring Window/Task layout");

        mainHandler.removeCallbacksAndMessages(null);

        mainHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                restoreLayout();
            }
        }, APPLY_DELAY_MS);
    }

    /**
     * Opens an application and requests the application region.
     */
    public boolean launchApp(String packageName) {
        if (packageName == null || packageName.trim().isEmpty()) {
            Log.e(TAG, "launchApp: empty package name");
            return false;
        }

        currentPackage = packageName.trim();

        Intent intent = launcherActivity.getPackageManager()
                .getLaunchIntentForPackage(currentPackage);

        if (intent == null) {
            Log.e(TAG, "No launch intent for package: " + currentPackage);
            return false;
        }

        Rect appBounds = calculateAppBounds();
        lastAppBounds = new Rect(appBounds);

        /*
         * First layer: public Android launch-bounds API.
         *
         * This is only a hint. Android may ignore it if freeform/multi-window
         * is not enabled for this device.
         */
        ActivityOptions options = ActivityOptions.makeBasic();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            try {
                options.setLaunchBounds(new Rect(appBounds));
                Log.d(TAG, "setLaunchBounds = " + appBounds);
            } catch (Throwable t) {
                Log.w(TAG, "setLaunchBounds failed: " + t);
            }
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try {
            launcherActivity.startActivity(intent, options.toBundle());
            Log.d(TAG, "External app launched: " + currentPackage);

            /*
             * The new Activity needs a little time to become a task before we
             * attempt hidden TaskManager operations.
             */
            mainHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    applyWindowTaskLayout(currentPackage);
                }
            }, APPLY_DELAY_MS);

            return true;

        } catch (Throwable t) {
            Log.e(TAG, "launchApp failed: " + currentPackage, t);
            return false;
        }
    }

    /**
     * Re-apply the current application region.
     */
    public void restoreLayout() {
        if (applyingLayout) {
            Log.d(TAG, "restoreLayout skipped: already applying");
            return;
        }

        Rect bounds = calculateAppBounds();
        lastAppBounds = new Rect(bounds);

        Log.d(TAG, "restoreLayout: appBounds=" + bounds);

        if (currentPackage != null && !currentPackage.isEmpty()) {
            applyWindowTaskLayout(currentPackage);
        } else {
            Log.d(TAG, "restoreLayout: no external app selected");
        }
    }

    /**
     * Returns the upper 70% region.
     */
    public Rect calculateAppBounds() {
        DisplayMetrics dm = launcherActivity.getResources().getDisplayMetrics();

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        int appBottom = Math.round(height * APP_HEIGHT_RATIO);

        Rect bounds = new Rect(0, 0, width, appBottom);

        Log.d(TAG, "calculateAppBounds: display="
                + width + "x" + height
                + ", app=" + bounds
                + ", launcherHeight=" + (height - appBottom));

        return bounds;
    }

    /**
     * Returns the lower 30% launcher region.
     */
    public Rect calculateLauncherBounds() {
        DisplayMetrics dm = launcherActivity.getResources().getDisplayMetrics();

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        int appBottom = Math.round(height * APP_HEIGHT_RATIO);

        return new Rect(0, appBottom, width, height);
    }

    private void applyWindowTaskLayout(String packageName) {
        if (packageName == null || packageName.isEmpty()) {
            return;
        }

        if (applyingLayout) {
            return;
        }

        applyingLayout = true;

        try {
            Rect appBounds = calculateAppBounds();
            int appTaskId = findTaskIdForPackage(packageName);

            Log.d(TAG, "applyWindowTaskLayout: package="
                    + packageName + ", taskId=" + appTaskId);

            if (appTaskId < 0) {
                Log.w(TAG, "Task not found yet; will retry");
                retryApply(packageName);
                return;
            }

            /*
             * Preferred architecture:
             *
             *   APP TASK       -> upper region
             *   LAUNCHER TASK  -> lower region
             *
             * We first try split-screen task APIs. If OEM/framework rejects
             * them, we try direct resizeTask(). Finally we leave the public
             * launch-bounds result in place.
             */
            boolean splitApplied = tryConfigureSplitScreen(
                    appTaskId,
                    launcherActivity.getTaskId(),
                    appBounds
            );

            if (!splitApplied) {
                Log.w(TAG, "Split-screen task configuration was not accepted");

                boolean resized = tryResizeTask(appTaskId, appBounds);

                if (resized) {
                    Log.d(TAG, "resizeTask succeeded");
                } else {
                    Log.w(TAG,
                            "No privileged Window/Task operation succeeded. "
                                    + "The device may require system/priv-app permission.");
                }
            }

            logTaskInfo("after apply");

        } finally {
            applyingLayout = false;
        }
    }

    private void retryApply(final String packageName) {
        mainHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (findTaskIdForPackage(packageName) >= 0) {
                    applyWindowTaskLayout(packageName);
                }
            }
        }, 700L);
    }

    /**
     * Try to create:
     *
     *   external app = SPLIT_SCREEN_PRIMARY
     *   launcher      = SPLIT_SCREEN_SECONDARY
     *
     * Then attempt to size the primary/secondary area.
     *
     * On Android 10 these calls are hidden and normally protected by
     * MANAGE_ACTIVITY_STACKS, so failure is expected for a normal APK.
     */
    private boolean tryConfigureSplitScreen(
            int appTaskId,
            int launcherTaskId,
            Rect appBounds) {

        Object atm = getActivityTaskManagerService();
        if (atm == null) {
            return false;
        }

        boolean appMoved = false;
        boolean launcherMoved = false;

        try {
            Method splitPrimary = findMethod(
                    atm.getClass(),
                    "setTaskWindowingModeSplitScreenPrimary",
                    int.class,
                    int.class,
                    boolean.class,
                    boolean.class,
                    Rect.class,
                    boolean.class
            );

            if (splitPrimary != null) {
                Object result = splitPrimary.invoke(
                        atm,
                        appTaskId,
                        SPLIT_SCREEN_CREATE_MODE_TOP_OR_LEFT,
                        true,
                        false,
                        new Rect(appBounds),
                        false
                );

                appMoved = !(result instanceof Boolean) || (Boolean) result;

                Log.d(TAG, "setTaskWindowingModeSplitScreenPrimary result="
                        + result);
            } else {
                /*
                 * Some framework builds expose only the 3-argument API.
                 */
                Method setMode = findMethod(
                        atm.getClass(),
                        "setTaskWindowingMode",
                        int.class,
                        int.class,
                        boolean.class
                );

                if (setMode == null) {
                    Log.w(TAG, "No setTaskWindowingMode API found");
                    return false;
                }

                Object result = setMode.invoke(
                        atm,
                        appTaskId,
                        WINDOWING_MODE_SPLIT_SCREEN_PRIMARY,
                        true
                );

                appMoved = !(result instanceof Boolean) || (Boolean) result;

                Log.d(TAG, "setTaskWindowingMode(primary) result=" + result);
            }

        } catch (Throwable t) {
            Log.w(TAG,
                    "Cannot move app task into split-screen primary: " + t);
        }

        /*
         * Put the launcher task into the secondary side. This is deliberately
         * separate from the app operation because some OEMs only allow one
         * of these calls.
         */
        if (launcherTaskId >= 0) {
            try {
                Method setMode = findMethod(
                        atm.getClass(),
                        "setTaskWindowingMode",
                        int.class,
                        int.class,
                        boolean.class
                );

                if (setMode != null) {
                    Object result = setMode.invoke(
                            atm,
                            launcherTaskId,
                            WINDOWING_MODE_SPLIT_SCREEN_SECONDARY,
                            false
                    );

                    launcherMoved = !(result instanceof Boolean) || (Boolean) result;

                    Log.d(TAG, "setTaskWindowingMode(secondary) result="
                            + result);
                }
            } catch (Throwable t) {
                Log.w(TAG,
                        "Cannot move launcher task into split-screen secondary: "
                                + t);
            }
        }

        if (!appMoved) {
            return false;
        }

        /*
         * If the OEM accepted both tasks, try to make the launcher task
         * visible again. This is a best-effort operation.
         */
        try {
            if (launcherMoved) {
                moveTaskToFront(launcherTaskId);
                moveTaskToFront(appTaskId);
            }
        } catch (Throwable t) {
            Log.w(TAG, "Could not restore task order: " + t);
        }

        return appMoved && launcherMoved;
    }

    /**
     * Direct hidden resizeTask fallback.
     *
     * Important Android 10 behavior: resizeTask() can move a non-freeform task
     * into FREEFORM. It is therefore a fallback, not the preferred split-screen
     * solution.
     */
    private boolean tryResizeTask(int taskId, Rect bounds) {
        Object atm = getActivityTaskManagerService();
        if (atm == null || taskId < 0) {
            return false;
        }

        try {
            Method resize = findMethod(
                    atm.getClass(),
                    "resizeTask",
                    int.class,
                    Rect.class,
                    int.class
            );

            if (resize == null) {
                Log.w(TAG, "resizeTask API not found");
                return false;
            }

            Object result = resize.invoke(
                    atm,
                    taskId,
                    new Rect(bounds),
                    RESIZE_MODE_PRESERVE_WINDOW
            );

            Log.d(TAG, "resizeTask(" + taskId + ", "
                    + bounds + ") result=" + result);

            if (result instanceof Boolean) {
                return (Boolean) result;
            }

            /*
             * Android 10's hidden interface returns void on some framework
             * builds, so successful invocation itself is useful evidence.
             */
            return true;

        } catch (Throwable t) {
            Log.w(TAG, "resizeTask failed: " + t);
            return false;
        }
    }

    /**
     * Move a task to front using ActivityTaskManager.
     *
     * We use this only after the split-screen operation. The call can be
     * rejected by permission checks on normal applications.
     */
    private boolean moveTaskToFront(int taskId) {
        if (taskId < 0) {
            return false;
        }

        Object atm = getActivityTaskManagerService();
        if (atm == null) {
            return false;
        }

        try {
            /*
             * Android 10 IActivityTaskManager:
             * moveTaskToFront(IApplicationThread, String, int, int, Bundle)
             *
             * Passing null for application thread is normally only useful to
             * privileged callers. We keep this best-effort and do not depend
             * on it for launch.
             */
            Method method = findMethod(
                    atm.getClass(),
                    "moveTaskToFront",
                    Class.forName("android.app.IApplicationThread"),
                    String.class,
                    int.class,
                    int.class,
                    android.os.Bundle.class
            );

            if (method == null) {
                return false;
            }

            Object result = method.invoke(
                    atm,
                    null,
                    launcherActivity.getPackageName(),
                    taskId,
                    0,
                    null
            );

            Log.d(TAG, "moveTaskToFront task=" + taskId
                    + ", result=" + result);

            return true;

        } catch (Throwable t) {
            Log.w(TAG, "moveTaskToFront failed: " + t);
            return false;
        }
    }

    private Object getActivityTaskManagerService() {
        try {
            Class<?> clazz = Class.forName("android.app.ActivityTaskManager");

            Method getService = clazz.getDeclaredMethod("getService");
            getService.setAccessible(true);

            Object service = getService.invoke(null);

            Log.d(TAG, "ActivityTaskManager service="
                    + (service != null ? service.getClass().getName() : "null"));

            return service;

        } catch (Throwable t) {
            Log.w(TAG, "Cannot obtain ActivityTaskManager service: " + t);
            return null;
        }
    }

    private Method findMethod(
            Class<?> clazz,
            String name,
            Class<?>... parameterTypes) {

        try {
            Method method = clazz.getMethod(name, parameterTypes);
            method.setAccessible(true);
            return method;
        } catch (Throwable ignored) {
        }

        try {
            Method method = clazz.getDeclaredMethod(name, parameterTypes);
            method.setAccessible(true);
            return method;
        } catch (Throwable ignored) {
        }

        /*
         * Binder Stub.Proxy implementations can vary between framework
         * revisions. Search by method name and parameter count as a fallback.
         */
        try {
            for (Method method : clazz.getMethods()) {
                if (method.getName().equals(name)
                        && method.getParameterTypes().length == parameterTypes.length) {
                    method.setAccessible(true);
                    return method;
                }
            }
        } catch (Throwable ignored) {
        }

        return null;
    }

    private int findTaskIdForPackage(String packageName) {
        if (packageName == null || packageName.isEmpty()) {
            return -1;
        }

        try {
            ActivityManager am = (ActivityManager)
                    launcherActivity.getSystemService(Context.ACTIVITY_SERVICE);

            List<ActivityManager.RunningTaskInfo> tasks =
                    am.getRunningTasks(30);

            if (tasks == null) {
                Log.w(TAG, "getRunningTasks returned null");
                return -1;
            }

            for (ActivityManager.RunningTaskInfo task : tasks) {
                if (task == null || task.topActivity == null) {
                    continue;
                }

                ComponentName component = task.topActivity;

                if (packageName.equals(component.getPackageName())) {
                    Log.d(TAG, "Found task for " + packageName
                            + ": id=" + task.id
                            + ", top=" + component.flattenToShortString());
                    return task.id;
                }
            }

        } catch (SecurityException se) {
            Log.w(TAG, "getRunningTasks denied: " + se);
        } catch (Throwable t) {
            Log.w(TAG, "findTaskIdForPackage failed: " + t);
        }

        return -1;
    }

    public int getLauncherTaskId() {
        return launcherActivity.getTaskId();
    }

    public Rect getLastAppBounds() {
        return lastAppBounds == null
                ? null
                : new Rect(lastAppBounds);
    }

    public String getCurrentPackage() {
        return currentPackage;
    }

    public void logTaskInfo(String reason) {
        try {
            ActivityManager am = (ActivityManager)
                    launcherActivity.getSystemService(Context.ACTIVITY_SERVICE);

            List<ActivityManager.RunningTaskInfo> tasks =
                    am.getRunningTasks(20);

            Log.d(TAG, "===== TASK INFO: " + reason + " =====");

            if (tasks == null) {
                Log.d(TAG, "No task information available");
                return;
            }

            for (ActivityManager.RunningTaskInfo task : tasks) {
                if (task == null) {
                    continue;
                }

                String top = task.topActivity == null
                        ? "null"
                        : task.topActivity.flattenToShortString();

                Log.d(TAG,
                        "taskId=" + task.id
                                + ", numActivities=" + task.numActivities
                                + ", top=" + top
                );
            }

            Log.d(TAG, "================================");
        } catch (Throwable t) {
            Log.w(TAG, "logTaskInfo failed: " + t);
        }
    }

    private void logDisplayInfo() {
        DisplayMetrics dm =
                launcherActivity.getResources().getDisplayMetrics();

        Log.d(TAG,
                "Display: " + dm.widthPixels
                        + "x" + dm.heightPixels
                        + ", density=" + dm.density
                        + ", densityDpi=" + dm.densityDpi
        );

        Log.d(TAG, "App bounds=" + calculateAppBounds());
        Log.d(TAG, "Launcher bounds=" + calculateLauncherBounds());
    }
}
