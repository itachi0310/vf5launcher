package com.vf5regenlauncher.util;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.content.Intent;
import android.util.Log;

import java.util.List;

/**
 * AppStateManager
 *
 * Android 10+
 *
 * Dùng để kiểm tra trạng thái của một App:
 *
 * NOT_INSTALLED
 * NOT_STARTED
 * STARTED
 * FOREGROUND
 * BACKGROUND
 * PIP
 *
 * Lưu ý:
 *
 * Process RUNNING không đồng nghĩa với Activity đang chạy.
 *
 * Vì vậy trạng thái STARTED được xác định chủ yếu
 * dựa trên Task / Activity.
 */
public class AppStateManager {

    private static final String TAG = "AppStateManager";


    // ============================================================
    // APP STATE
    // ============================================================

    public enum AppState {

        /**
         * Package chưa được cài.
         */
        NOT_INSTALLED,

        /**
         * Không tìm thấy Task của App.
         */
        NOT_STARTED,

        /**
         * Task của App tồn tại.
         */
        STARTED,

        /**
         * App đang foreground.
         */
        FOREGROUND,

        /**
         * App đang background.
         */
        BACKGROUND,

        /**
         * App đang Picture-in-Picture.
         */
        PIP
    }


    // ============================================================
    // APP INFO
    // ============================================================

    /**
     * Thông tin chi tiết về App.
     *
     * Rất hữu ích để debug launcher.
     */
    public static class AppInfo {

        public String packageName;

        public AppState state;

        public boolean taskFound;

        public int taskId;

        public boolean hasTaskId;

        public ComponentName baseActivity;

        public ComponentName topActivity;

        public boolean processRunning;

        public boolean foreground;

        public boolean pip;


        public AppInfo(
                String packageName,
                AppState state,
                boolean taskFound,
                int taskId,
                boolean hasTaskId,
                ComponentName baseActivity,
                ComponentName topActivity,
                boolean processRunning,
                boolean foreground,
                boolean pip
        ) {

            this.packageName = packageName;
            this.state = state;
            this.taskFound = taskFound;
            this.taskId = taskId;
            this.hasTaskId = hasTaskId;
            this.baseActivity = baseActivity;
            this.topActivity = topActivity;
            this.processRunning = processRunning;
            this.foreground = foreground;
            this.pip = pip;
        }
    }


    // ============================================================
    // GET APP STATE
    // ============================================================

    /**
     * Hàm chính.
     *
     * Ví dụ:
     *
     * AppStateManager.AppState state =
     *     AppStateManager.getAppState(
     *         context,
     *         "com.google.android.apps.maps"
     *     );
     */
    public static AppState getAppState(
            Context context,
            String packageName
    ) {

        return getAppInfo(
                context,
                packageName
        ).state;
    }


    // ============================================================
    // GET APP INFO
    // ============================================================

    /**
     * Lấy toàn bộ thông tin App.
     */
    public static AppInfo getAppInfo(
            Context context,
            String packageName
    ) {

        Context appContext =
                context.getApplicationContext();


        // --------------------------------------------------------
        // 1. Package có tồn tại không?
        // --------------------------------------------------------

        if (!isPackageInstalled(
                appContext,
                packageName
        )) {

            log(
                    packageName,
                    "NOT_INSTALLED"
            );

            return new AppInfo(
                    packageName,
                    AppState.NOT_INSTALLED,
                    false,
                    -1,
                    false,
                    null,
                    null,
                    false,
                    false,
                    false
            );
        }


        // --------------------------------------------------------
        // 2. Tìm Task
        // --------------------------------------------------------

        ActivityManager.RunningTaskInfo task =
                findAppTask(
                        appContext,
                        packageName
                );


        // --------------------------------------------------------
        // 3. Process
        // --------------------------------------------------------

        boolean processRunning =
                isProcessRunning(
                        appContext,
                        packageName
                );


        // --------------------------------------------------------
        // 4. Không có Task
        // --------------------------------------------------------

        if (task == null) {

            log(
                    packageName,
                    "NOT_STARTED"
                            + " | process="
                            + processRunning
            );

            return new AppInfo(
                    packageName,
                    AppState.NOT_STARTED,
                    false,
                    -1,
                    false,
                    null,
                    null,
                    processRunning,
                    false,
                    false
            );
        }


        // --------------------------------------------------------
        // 5. PIP
        // --------------------------------------------------------

        boolean pip =
                isTaskInPip(task);

        if (pip) {

            log(
                    packageName,
                    "PIP"
                            + " | taskId="
                            + task.id
            );

            return new AppInfo(
                    packageName,
                    AppState.PIP,
                    true,
                    task.id,
                    true,
                    task.baseActivity,
                    task.topActivity,
                    processRunning,
                    false,
                    true
            );
        }


        // --------------------------------------------------------
        // 6. Foreground
        // --------------------------------------------------------

        boolean foreground =
                isTaskForeground(
                        appContext,
                        task
                );

        if (foreground) {

            log(
                    packageName,
                    "FOREGROUND"
                            + " | taskId="
                            + task.id
            );

            return new AppInfo(
                    packageName,
                    AppState.FOREGROUND,
                    true,
                    task.id,
                    true,
                    task.baseActivity,
                    task.topActivity,
                    processRunning,
                    true,
                    false
            );
        }


        // --------------------------------------------------------
        // 7. Background
        // --------------------------------------------------------

        log(
                packageName,
                "BACKGROUND"
                        + " | taskId="
                        + task.id
        );

        return new AppInfo(
                packageName,
                AppState.BACKGROUND,
                true,
                task.id,
                true,
                task.baseActivity,
                task.topActivity,
                processRunning,
                false,
                false
        );
    }


    // ============================================================
    // FIND TASK
    // ============================================================

    /**
     * Tìm Task của package.
     *
     * Ưu tiên topActivity.
     *
     * Nếu không tìm thấy thì kiểm tra baseActivity.
     */
    @SuppressWarnings("deprecation")
    public static ActivityManager.RunningTaskInfo findAppTask(
            Context context,
            String packageName
    ) {

        try {

            ActivityManager activityManager =
                    (ActivityManager)
                            context.getSystemService(
                                    Context.ACTIVITY_SERVICE
                            );

            if (activityManager == null) {
                return null;
            }


            List<ActivityManager.RunningTaskInfo> tasks =
                    activityManager.getRunningTasks(100);


            if (tasks == null || tasks.isEmpty()) {
                return null;
            }


            // ----------------------------------------------------
            // Ưu tiên topActivity
            // ----------------------------------------------------

            for (ActivityManager.RunningTaskInfo task : tasks) {

                ComponentName top =
                        task.topActivity;

                if (top != null
                        && packageName.equals(
                        top.getPackageName()
                )) {

                    return task;
                }
            }


            // ----------------------------------------------------
            // Fallback baseActivity
            // ----------------------------------------------------

            for (ActivityManager.RunningTaskInfo task : tasks) {

                ComponentName base =
                        task.baseActivity;

                if (base != null
                        && packageName.equals(
                        base.getPackageName()
                )) {

                    return task;
                }
            }

        } catch (SecurityException e) {

            Log.e(
                    TAG,
                    "findAppTask SecurityException",
                    e
            );

        } catch (Exception e) {

            Log.e(
                    TAG,
                    "findAppTask error",
                    e
            );
        }

        return null;
    }


    // ============================================================
    // IS APP STARTED
    // ============================================================

    /**
     * Kiểm tra App có Task đang tồn tại hay không.
     *
     * Đây là hàm bạn nên dùng để biết:
     *
     * "Map đã start chưa?"
     */
    public static boolean isAppStarted(
            Context context,
            String packageName
    ) {

        return findAppTask(
                context,
                packageName
        ) != null;
    }


    /**
     * Alias.
     */
    public static boolean hasTask(
            Context context,
            String packageName
    ) {

        return isAppStarted(
                context,
                packageName
        );
    }


    // ============================================================
    // TASK ID
    // ============================================================

    /**
     * Lấy Task ID.
     *
     * Nếu không tồn tại trả về -1.
     */
    public static int getTaskId(
            Context context,
            String packageName
    ) {

        ActivityManager.RunningTaskInfo task =
                findAppTask(
                        context,
                        packageName
                );

        if (task == null) {
            return -1;
        }

        return task.id;
    }


    // ============================================================
    // TOP ACTIVITY
    // ============================================================

    public static ComponentName getTopActivity(
            Context context,
            String packageName
    ) {

        ActivityManager.RunningTaskInfo task =
                findAppTask(
                        context,
                        packageName
                );

        if (task == null) {
            return null;
        }

        return task.topActivity;
    }


    // ============================================================
    // BASE ACTIVITY
    // ============================================================

    public static ComponentName getBaseActivity(
            Context context,
            String packageName
    ) {

        ActivityManager.RunningTaskInfo task =
                findAppTask(
                        context,
                        packageName
                );

        if (task == null) {
            return null;
        }

        return task.baseActivity;
    }


    // ============================================================
    // PROCESS
    // ============================================================

    /**
     * Kiểm tra process.
     *
     * Chỉ dùng để biết process còn tồn tại.
     *
     * Không dùng hàm này để kết luận App đã start.
     */
    @SuppressWarnings("deprecation")
    public static boolean isProcessRunning(
            Context context,
            String packageName
    ) {

        try {

            ActivityManager activityManager =
                    (ActivityManager)
                            context.getSystemService(
                                    Context.ACTIVITY_SERVICE
                            );

            if (activityManager == null) {
                return false;
            }


            List<ActivityManager.RunningAppProcessInfo> processes =
                    activityManager.getRunningAppProcesses();


            if (processes == null) {
                return false;
            }


            for (
                    ActivityManager.RunningAppProcessInfo process
                    : processes
            ) {

                if (packageName.equals(
                        process.processName
                )) {

                    return true;
                }


                if (process.pkgList != null) {

                    for (
                            String pkg
                            : process.pkgList
                    ) {

                        if (packageName.equals(pkg)) {
                            return true;
                        }
                    }
                }
            }

        } catch (Exception e) {

            Log.e(
                    TAG,
                    "isProcessRunning error",
                    e
            );
        }

        return false;
    }


    // ============================================================
    // FOREGROUND
    // ============================================================

    /**
     * Kiểm tra Task có phải Task đầu tiên hay không.
     */
    @SuppressWarnings("deprecation")
    public static boolean isTaskForeground(
            Context context,
            ActivityManager.RunningTaskInfo targetTask
    ) {

        if (targetTask == null) {
            return false;
        }

        try {

            ActivityManager activityManager =
                    (ActivityManager)
                            context.getSystemService(
                                    Context.ACTIVITY_SERVICE
                            );

            if (activityManager == null) {
                return false;
            }


            List<ActivityManager.RunningTaskInfo> tasks =
                    activityManager.getRunningTasks(1);


            if (tasks == null
                    || tasks.isEmpty()) {

                return false;
            }


            return tasks.get(0).id
                    == targetTask.id;

        } catch (Exception e) {

            Log.e(
                    TAG,
                    "isTaskForeground error",
                    e
            );

            return false;
        }
    }


    /**
     * Kiểm tra package đang foreground.
     */
    public static boolean isForeground(
            Context context,
            String packageName
    ) {

        ActivityManager.RunningTaskInfo task =
                findAppTask(
                        context,
                        packageName
                );

        if (task == null) {
            return false;
        }

        return isTaskForeground(
                context,
                task
        );
    }


    // ============================================================
    // PIP
    // ============================================================

    /**
     * Kiểm tra Task đang PIP.
     *
     * Một số Android/OEM framework expose
     * pictureInPictureMode khác nhau.
     *
     * Vì vậy dùng reflection.
     */
    public static boolean isTaskInPip(
            ActivityManager.RunningTaskInfo task
    ) {

        if (task == null) {
            return false;
        }

        if (Build.VERSION.SDK_INT
                < Build.VERSION_CODES.O) {

            return false;
        }


        // --------------------------------------------------------
        // Cách 1
        // --------------------------------------------------------

        try {

            java.lang.reflect.Field field =
                    task.getClass()
                            .getDeclaredField(
                                    "pictureInPictureMode"
                            );

            field.setAccessible(true);

            return field.getBoolean(task);

        } catch (Exception ignored) {
        }


        // --------------------------------------------------------
        // Cách 2
        // --------------------------------------------------------

        try {

            java.lang.reflect.Field field =
                    task.getClass()
                            .getField(
                                    "pictureInPictureMode"
                            );

            field.setAccessible(true);

            return field.getBoolean(task);

        } catch (Exception ignored) {
        }


        return false;
    }


    /**
     * Kiểm tra package đang PIP.
     */
    public static boolean isAppInPip(
            Context context,
            String packageName
    ) {

        ActivityManager.RunningTaskInfo task =
                findAppTask(
                        context,
                        packageName
                );

        if (task == null) {
            return false;
        }

        return isTaskInPip(task);
    }


    // ============================================================
    // PACKAGE
    // ============================================================

    public static boolean isPackageInstalled(
            Context context,
            String packageName
    ) {

        try {

            if (Build.VERSION.SDK_INT >= 33) {

                context.getPackageManager()
                        .getPackageInfo(
                                packageName,
                                PackageManager.PackageInfoFlags
                                        .of(0)
                        );

            } else {

                context.getPackageManager()
                        .getPackageInfo(
                                packageName,
                                0
                        );
            }

            return true;

        } catch (
                PackageManager.NameNotFoundException e
        ) {

            return false;

        } catch (Exception e) {

            Log.e(
                    TAG,
                    "isPackageInstalled error",
                    e
            );

            return false;
        }
    }


    // ============================================================
    // USAGE ACCESS
    // ============================================================

    /**
     * Kiểm tra Usage Access.
     */
    public static boolean hasUsageStatsPermission(
            Context context
    ) {

        try {

            AppOpsManager appOps =
                    (AppOpsManager)
                            context.getSystemService(
                                    Context.APP_OPS_SERVICE
                            );

            if (appOps == null) {
                return false;
            }


            int mode;

            if (Build.VERSION.SDK_INT >= 29) {

                mode =
                        appOps.unsafeCheckOpNoThrow(
                                AppOpsManager.OPSTR_GET_USAGE_STATS,
                                Process.myUid(),
                                context.getPackageName()
                        );

            } else {

                mode =
                        appOps.checkOpNoThrow(
                                AppOpsManager.OPSTR_GET_USAGE_STATS,
                                Process.myUid(),
                                context.getPackageName()
                        );
            }


            return mode
                    == AppOpsManager.MODE_ALLOWED;

        } catch (Exception e) {

            Log.e(
                    TAG,
                    "hasUsageStatsPermission error",
                    e
            );

            return false;
        }
    }


    /**
     * Mở Usage Access Settings.
     */
    public static void openUsageAccessSettings(
            Context context
    ) {

        try {

            Intent intent =
                    new Intent(
                            Settings.ACTION_USAGE_ACCESS_SETTINGS
                    );

            intent.addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK
            );

            context.startActivity(intent);

        } catch (Exception e) {

            Log.e(
                    TAG,
                    "openUsageAccessSettings error",
                    e
            );
        }
    }


    // ============================================================
    // DEBUG
    // ============================================================

    /**
     * Dump toàn bộ thông tin App.
     */
    public static AppInfo dump(
            Context context,
            String packageName
    ) {

        AppInfo info =
                getAppInfo(
                        context,
                        packageName
                );


        Log.d(
                TAG,
                "========================================"
        );

        Log.d(
                TAG,
                "APP STATE"
        );

        Log.d(
                TAG,
                "package      = "
                        + info.packageName
        );

        Log.d(
                TAG,
                "state        = "
                        + info.state
        );

        Log.d(
                TAG,
                "taskFound    = "
                        + info.taskFound
        );

        Log.d(
                TAG,
                "taskId       = "
                        + (
                        info.hasTaskId
                                ? info.taskId
                                : "NONE"
                )
        );

        Log.d(
                TAG,
                "baseActivity = "
                        + info.baseActivity
        );

        Log.d(
                TAG,
                "topActivity  = "
                        + info.topActivity
        );

        Log.d(
                TAG,
                "process      = "
                        + info.processRunning
        );

        Log.d(
                TAG,
                "foreground   = "
                        + info.foreground
        );

        Log.d(
                TAG,
                "pip          = "
                        + info.pip
        );

        Log.d(
                TAG,
                "========================================"
        );


        return info;
    }


    // ============================================================
    // LOG
    // ============================================================

    private static void log(
            String packageName,
            String message
    ) {

        Log.d(
                TAG,
                "[" + packageName + "] "
                        + message
        );
    }
}
//```
//
//        ### Cách dùng với Maps
//
//```java
//String MAP_PACKAGE =
//        "com.google.android.apps.maps";
//
//AppStateManager.AppState state =
//        AppStateManager.getAppState(
//                this,
//                MAP_PACKAGE
//        );
//
//if (state ==
//AppStateManager.AppState.NOT_STARTED) {
//
//// Maps chưa có Task
//startMap();
//
//} else {
//
//        // Maps đã có Task
//        Log.d(
//            "MAP",
//                    "Maps state = " + state
//            );
//}
//        ```
//
//Hoặc nếu muốn xem **toàn bộ thông tin**:
//
//        ```java
//AppStateManager.AppInfo info =
//        AppStateManager.dump(
//                this,
//                "com.google.android.apps.maps"
//        );
//```
//
//        ---
//
//        ### Với vấn đề hiện tại của bạn, tôi đặc biệt khuyên dùng `isAppStarted()`
//
//        ```java
//boolean mapStarted =
//        AppStateManager.isAppStarted(
//                this,
//                "com.google.android.apps.maps"
//        );
//```
//
//Nó trả lời câu hỏi:
//
//        > **"Hiện tại ActivityManager còn nhìn thấy Task của Maps không?"**
//
//chứ không trả lời:
//
//        > "Process Maps còn nằm trong RAM không?"
//
//Hai cái này khác nhau.
//
//Ví dụ:
//
//        | Tình huống                       | Process | Task | `isAppStarted()` |
//        | -------------------------------- | ------: | ---: | ---------------: |
//        | Chưa mở Maps                     |       ❌ |    ❌ |          `false` |
//        | Maps vừa start                   |       ✅ |    ✅ |           `true` |
//        | Maps foreground                  |       ✅ |    ✅ |           `true` |
//        | Maps background                  |       ✅ |    ✅ |           `true` |
//        | Maps PIP                         |       ✅ |    ✅ |           `true` |
//        | Process còn nhưng Task không còn |       ✅ |    ❌ |          `false` |
//
//        **Một lưu ý quan trọng:** `getRunningTasks()` là API bị hạn chế đối với app thông thường trên Android hiện đại. Tuy nhiên vì bạn đang làm launcher và thiết bị của bạn là Android 10/OEM tùy biến, nó có thể cung cấp nhiều thông tin hơn app Android thông thường. Nếu trên CarFu/ROM của bạn `getRunningTasks()` trả về không đầy đủ, chúng ta nên chuyển sang cách kiểm tra khác dựa trên `ActivityTaskManager`/framework của chính thiết bị.
