package com.vf5regenlauncher.util;

import static com.vf5regenlauncher.AppEmbedManager.PREFS_RECT;


import android.app.ActivityManager;
import android.app.IActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;
import java.util.List;

import com.vf5regenlauncher.AndrewLauncherActivity;
import com.vf5regenlauncher.util.android.os.SystemProperties;
import com.vf5regenlauncher.util.launcher.LauncherApplication;
import com.vf5regenlauncher.util.thread.ThreadManager;


public class WindowUtil {
    private static final String TAG = "WindowUtil";
    private static Intent intent;
    public static String AppPackageNmae = "com.google.android.maps";
    public static boolean visible = true;
    public static int delayMillis = 0;

    private static Object mActivityManager;

//    public static void setPinnedStackVisibleSafe(boolean visibleState) {
//        try {
//            Class<?> activityManagerNativeClass = Class.forName("android.app.ActivityManagerNative");
//            Method getDefaultMethod = activityManagerNativeClass.getMethod("getDefault");
//            Object am = getDefaultMethod.invoke(null);
//            Method setPinnedStackVisibleMethod = am.getClass().getMethod("setPinnedStackVisible", boolean.class);
//            setPinnedStackVisibleMethod.invoke(am, visibleState);
//            Log.d(TAG, "setPinnedStackVisible via ActivityManagerNative success: " + visibleState);
//        } catch (Throwable e) {
//            try {
//                Class<?> activityManagerClass = Class.forName("android.app.ActivityManager");
//                Method getServiceMethod = activityManagerClass.getMethod("getService");
//                Object am = getServiceMethod.invoke(null);
//                Method setPinnedStackVisibleMethod = am.getClass().getMethod("setPinnedStackVisible", boolean.class);
//                setPinnedStackVisibleMethod.invoke(am, visibleState);
//                Log.d(TAG, "setPinnedStackVisible via ActivityManager success: " + visibleState);
//            } catch (Throwable t) {
//                Log.e(TAG, "setPinnedStackVisible failed", t);
//            }
//        }
//    }

    public static void initDefaultApp() {
        Log.d(TAG, "initDefaultApp");
        intent = new Intent();
        visible = false;
        removePip(null);

        // Ưu tiên 1: Đọc từ cài đặt cấu hình driving_prefs
        SharedPreferences sp = LauncherApplication.sApp.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
        String userSelectedMap = sp.getString("default_map_package", "");
        if (!userSelectedMap.isEmpty() && checkAppInstalled(userSelectedMap)) {
            AppPackageNmae = userSelectedMap;
            Log.d(TAG, "Found user preferred map package: " + AppPackageNmae);
        } else {
            // Ưu tiên 2: Danh sách các key cấu hình navi trên hệ thống ROM
            String[] naviKeys = {
                "persist.launcher.packagename", // Key chuẩn do Launcher lưu
                "persist.syu.navi.packagename",  // Key chuẩn của SYU/FYT
                "persist.sys.fyt.navi_package"   // Key bổ trợ
            };

            AppPackageNmae = "";
            for (String key : naviKeys) {
                String val = SystemProperties.get(key, "");
                if (!val.isEmpty() && checkAppInstalled(val)) {
                    AppPackageNmae = val;
                    Log.d(TAG, "Found valid navi package from " + key + ": " + AppPackageNmae);
                    break;
                }
            }

            // Ưu tiên 3: Fallback ứng dụng bản đồ phổ biến đã cài
            if (AppPackageNmae.isEmpty()) {
                if (checkAppInstalled("com.vietmap.vietmaplive")) {
                    AppPackageNmae = "com.vietmap.vietmaplive";
                } else if (checkAppInstalled(FytPackage.mapsAction)) {
                    AppPackageNmae = FytPackage.mapsAction;
                } else if (checkAppInstalled("com.google.android.maps")) {
                    AppPackageNmae = "com.google.android.maps";
                } else {
                    AppPackageNmae = FytPackage.mapsAction;
                }
                SystemProperties.set("persist.launcher.packagename", AppPackageNmae);
            }
        }
        
        Log.d("AppPackageNmae", "AppPackageNmae final: " + AppPackageNmae);
    }

    private static Object getIActivityManager() {
        if (mActivityManager == null) {
            try {
                mActivityManager = ActivityManager.class
                        .getMethod("getService")
                        .invoke(null);
                Log.d(TAG, "mActivityManager: " + mActivityManager);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mActivityManager;
    }

    private static boolean isPinnedStackVisible() {
        Object am = getIActivityManager();
        Log.d(TAG, "IActivityManager am: " + am);
        if (am != null) {
            try {
                Method method = Class.forName("android.app.IActivityManager")
                            .getMethod("getPinnedStackVisible");

                    return (Boolean) method.invoke(am);
                } catch (Throwable t) {
                    Log.e(TAG, "getPinnedStackVisible error: " + t.getMessage());
                }
        }
        return false;

    }

    private static void setPinnedStackVisibleSafe(boolean visible) {
        try {
            Object service = getIActivityManager();
            if (service != null) {
                Method setPinnedStackVisible = Class.forName("android.app.IActivityManager")
                        .getMethod("setPinnedStackVisible", boolean.class);
                setPinnedStackVisible.invoke(service, visible);
            }
        } catch (Throwable t) {
            Log.e(TAG, "setPinnedStackVisible error: " + t.getMessage());
        }
    }

    public static boolean isAppRunning(Context context, String packageName) {
        if (packageName == null || packageName.isEmpty()) return false;
        try {
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            if (am == null) return false;

            // 1. Kiểm tra Running Tasks (Hiệu quả nhất trên FYT/SYU ROM)
            try {
                List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(100);
                if (tasks != null) {
                    for (ActivityManager.RunningTaskInfo task : tasks) {
                        String topPkg = task.topActivity != null ? task.topActivity.getPackageName() : "";
                        String basePkg = task.baseActivity != null ? task.baseActivity.getPackageName() : "";
                        
                        if ((!topPkg.isEmpty() && (topPkg.contains(packageName) || packageName.contains(topPkg))) ||
                            (!basePkg.isEmpty() && (basePkg.contains(packageName) || packageName.contains(basePkg)))) {
                            Log.d(TAG, "isAppRunning found in RunningTasks: top=" + topPkg + ", base=" + basePkg);
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                Log.w(TAG, "getRunningTasks check failed: " + e.getMessage());
            }

            // 2. Kiểm tra Running Processes
            try {
                List<ActivityManager.RunningAppProcessInfo> processes = am.getRunningAppProcesses();
                if (processes != null) {
                    for (ActivityManager.RunningAppProcessInfo p : processes) {
                        if (p.processName != null && (p.processName.contains(packageName) || packageName.contains(p.processName))) {
                            Log.d(TAG, "isAppRunning found in RunningProcesses: " + p.processName);
                            return true;
                        }
                        if (p.pkgList != null) {
                            for (String pkg : p.pkgList) {
                                if (pkg != null && (pkg.contains(packageName) || packageName.contains(pkg))) {
                                    Log.d(TAG, "isAppRunning found in Process pkgList: " + pkg);
                                    return true;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                Log.w(TAG, "getRunningAppProcesses check failed: " + e.getMessage());
            }

            // 3. Kiểm tra Running Services
            try {
                List<ActivityManager.RunningServiceInfo> services = am.getRunningServices(100);
                if (services != null) {
                    for (ActivityManager.RunningServiceInfo s : services) {
                        if (s.service != null && s.service.getPackageName() != null &&
                            (s.service.getPackageName().contains(packageName) || packageName.contains(s.service.getPackageName()))) {
                            Log.d(TAG, "isAppRunning found in RunningServices: " + s.service.getPackageName());
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                Log.w(TAG, "getRunningServices check failed: " + e.getMessage());
            }

        } catch (Exception e) {
            Log.e(TAG, "isAppRunning error", e);
        }
        return false;
    }


    public static void startMapPip() {
        ThreadManager.getLongPool().execute(new Runnable() {
            @Override
            public void run() {
                WindowUtil.openPip(AppPackageNmae, false);
            }
        });
    }

    public static void startMapPip(String PackageName) {
        ThreadManager.getLongPool().execute(new Runnable() {
            @Override
            public void run() {
                WindowUtil.openPip(PackageName, true);
            }
        });
    }

    public static void startMapPip(final View v, final boolean show) {
        ThreadManager.getLongPool().execute(new Runnable() {
            @Override
            public void run() {
                WindowUtil.openPip(AppPackageNmae, show);
            }
        });
    }

    public static void startMapPip(final View v, final boolean show, int millis) {
        delayMillis = millis;
        ThreadManager.getLongPool().execute(new Runnable() {
            @Override
            public void run() {
                WindowUtil.openPip(AppPackageNmae, show);
            }
        });
    }

    public static void removePip(final View v, int millis) {
        delayMillis = millis;
        ThreadManager.getLongPool().execute(new Runnable() {
            @Override
            public void run() {
                WindowUtil.removePip(v);
            }
        });
    }

    public static void openPip(String AAppPackageNmae) {
        openPip(AAppPackageNmae, true);
    }

    public static boolean isMapStarted = false;

    public static void openPip(String AAppPackageNmae, boolean force) {
        Log.d("startMapPip", "startMapPip:" + AAppPackageNmae + " (force=" + force + ", visible=" + visible + ", isMapStarted=" + isMapStarted + ", isMainScreen=" + AndrewLauncherActivity.isMainScreen + ")");
        try {
            if (AAppPackageNmae.equals(FytPackage.fourcamera2Action)) {
                Log.d("LZP", "fourcamera2Action ignored");
                return;
            }

            if (!AndrewLauncherActivity.isMainScreen) {
                Log.d("LZP", "WindowUtil --- Open window skipped (not on launcher main screen)");
                return;
            }

            if (Utils.topApp()) {
                Log.d(TAG, "isMapStarted: " + isMapStarted);
                Log.d(TAG, "isPinnedStackVisible: " + isPinnedStackVisible());

                boolean running = isAppRunning(LauncherApplication.sApp, AAppPackageNmae);
                Log.d(TAG, "App " + AAppPackageNmae + " is running: " + running);


                intent = FytPackage.getIntent(LauncherApplication.sApp, AAppPackageNmae);
                Log.d(TAG, "intent: " + intent);
                if (intent == null) {
                    Log.e("LZP", "Không tìm thấy Intent cho package: " + AAppPackageNmae);
                    return;
                }

                if (AAppPackageNmae.equals("com.syu.camera360")) {
                    AndrewLauncherActivity.getInstance().sendBroadcast(new Intent("com.syu.camera360.show"));
                }

                if (!isPinnedStackVisible() || !isMapStarted || !running || !force) {
                    AndrewLauncherActivity.getInstance().handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                SystemProperties.set("sys.lsec.force_pip", "true");
                                SystemProperties.set("sys.lsec.pip_show", "1");
                                SystemProperties.set("sys.lsec.pip_mode", "1");

                                SharedPreferences sp = LauncherApplication.sApp.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
                                String savedRect = sp.getString(PREFS_RECT, "");
                                if (!savedRect.isEmpty()) {
                                    Intent i = new Intent("com.syu.action.PIP_RECT");
                                    i.putExtra("pip_rect", savedRect);
                                    i.putExtra("rect", savedRect);
                                    i.putExtra("show", true);
                                    LauncherApplication.sApp.sendBroadcast(i);
                                    LauncherApplication.sApp.sendBroadcast(new Intent("com.syu.pip.show").putExtra("show", true).putExtra("packagename", AAppPackageNmae));
                                    LauncherApplication.sApp.sendBroadcast(new Intent("com.syu.pip.update").putExtra("rect", savedRect));
                                }

                                setPinnedStackVisibleSafe(true);
                                visible = true;
                                Log.d("LZP", "WindowUtil --- Map already started, restored PiP stack visibility without restarting activity");
                            } catch (Exception e) {
                                Log.e("LZP", "Failed to restore PiP for started map", e);
                            }
                        }
                    }, delayMillis);
                    delayMillis = 0;
                } else {
//                    intent = FytPackage.getIntent(LauncherApplication.sApp, AAppPackageNmae);
//                    if (intent == null) {
//                        Log.e("LZP", "Không tìm thấy Intent cho package: " + AAppPackageNmae);
//                        return;
//                    }

                    AndrewLauncherActivity.getInstance().handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                SystemProperties.set("sys.lsec.force_pip", "true");
                            } catch (Throwable e) {
                            }
                            
                            WindowUtil.intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                            WindowUtil.intent.putExtra("force_pip", true);
                            WindowUtil.intent.putExtra("pip_mode", 1);

                            SharedPreferences sp = LauncherApplication.sApp.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
                            String savedRect = sp.getString(PREFS_RECT, "");
                            if (!savedRect.isEmpty()) {
                                WindowUtil.intent.putExtra("pip_rect", savedRect);
                                WindowUtil.intent.putExtra("rect", savedRect);
                            }

                            try {
                                setPinnedStackVisibleSafe(true);
                                AndrewLauncherActivity.getInstance().startActivity(WindowUtil.intent);
                                isMapStarted = true;
                                Log.d("LZP", "WindowUtil --- startActivity executed successfully in PiP mode");
                                visible = true;
                            } catch (Exception e) {
                                Log.e("LZP", "StartActivity failed", e);
                                visible = false;
                                isMapStarted = false;
                            }
                        }
                    }, delayMillis);
                    Log.d("LZP", "WindowUtil --- Open window scheduled");
                    delayMillis = 0;
                }
            } else {
                Log.d("LZP", "WindowUtil --- Open window skipped (not topApp)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void openPip(View v, boolean show) {
        openPip(AppPackageNmae, show);
    }

    public static void removePip(View v) {
        Log.d("LZP", "removePip..");
        try {
            if (!AppPackageNmae.equals(FytPackage.fourcamera2Action)) {
                if (visible || v == null || isPinnedStackVisible()) {
                    AndrewLauncherActivity.getInstance().handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            setPinnedStackVisibleSafe(false);
                            Log.d("LZP", "WindowUtil --- remove window done");
                        }
                    }, delayMillis);
                    if (AppPackageNmae.equals(FytPackage.GaodeACTION)) {
                        try {
                            LauncherApplication.sApp.removeGaoDeCoverView();
                        } catch (Exception e) {
                        }
                    }
                    visible = false;
                    delayMillis = 0;
                    return;
                }
                Log.d("LZP", "WindowUtil --- remove window filter");
                Log.d("WindowUtil", "WindowUtil ------ 关闭窗口被过滤");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

//    public static void sendBROADCAST(boolean show) {
//        Intent intent2 = new Intent();
//        intent2.setAction("FOURCAMERA2_BROADCAST_RECV");
//        Bundle bundle = new Bundle();
//        bundle.putBoolean("SHOW", show);
//        bundle.putInt(MapConfig.KEY_TYPE, 10000);
//        if (Utils.getRes().getDisplayMetrics().widthPixels == 1024) {
//            bundle.putInt("POS_X", FinalCanbus.CAR_0397);
//            bundle.putInt("POS_Y", FinalCanbus.CAR_XP2_OPEL);
//            bundle.putInt("POS_W", 614);
//            bundle.putInt("POS_H", FinalCanbus.CAR_FYT_WC1_15YiDong);
//        } else {
//            bundle.putInt("POS_X", 495);
//            bundle.putInt("POS_Y", FinalCanbus.CAR_RZC_XP1_JiangHuaiRuiFengS3);
//            bundle.putInt("POS_W", 770);
//            bundle.putInt("POS_H", 432);
//        }
//        intent2.putExtras(bundle);
//        LauncherApplication.sApp.sendBroadcast(intent2);
//    }

    private static boolean checkAppInstalled(String packageName) {
        PackageInfo packageInfo;
        if (packageName == null || packageName.isEmpty()) {
            return false;
        }
        try {
            packageInfo = LauncherApplication.sApp.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        return packageInfo != null;
    }
}
