package com.vf5regenlauncher.util;

import static com.vf5regenlauncher.AppEmbedManager.PREFS_RECT;


import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;

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

    public static void setPinnedStackVisibleSafe(boolean visibleState) {
        try {
            Class<?> activityManagerNativeClass = Class.forName("android.app.ActivityManagerNative");
            Method getDefaultMethod = activityManagerNativeClass.getMethod("getDefault");
            Object am = getDefaultMethod.invoke(null);
            Method setPinnedStackVisibleMethod = am.getClass().getMethod("setPinnedStackVisible", boolean.class);
            setPinnedStackVisibleMethod.invoke(am, visibleState);
            Log.d(TAG, "setPinnedStackVisible via ActivityManagerNative success: " + visibleState);
        } catch (Throwable e) {
            try {
                Class<?> activityManagerClass = Class.forName("android.app.ActivityManager");
                Method getServiceMethod = activityManagerClass.getMethod("getService");
                Object am = getServiceMethod.invoke(null);
                Method setPinnedStackVisibleMethod = am.getClass().getMethod("setPinnedStackVisible", boolean.class);
                setPinnedStackVisibleMethod.invoke(am, visibleState);
                Log.d(TAG, "setPinnedStackVisible via ActivityManager success: " + visibleState);
            } catch (Throwable t) {
                Log.e(TAG, "setPinnedStackVisible failed", t);
            }
        }
    }

    public static void initDefaultApp() {
        Log.d(TAG, "initDefaultApp");
        intent = new Intent();
        visible = false;
        removePip(null);
        AppPackageNmae = SystemProperties.get("persist.launcher.packagename", "");
        if (AppPackageNmae.isEmpty()) {
            SystemProperties.set("persist.launcher.packagename", FytPackage.googlemapAction);
            AppPackageNmae = SystemProperties.get("persist.launcher.packagename", "");
        }
        Log.d("AppPackageNmae", "AppPackageNmae:" + AppPackageNmae);
    }

    public static void startMapPip() {
        ThreadManager.getLongPool().execute(new Runnable() {
            @Override
            public void run() {
                WindowUtil.openPip(AppPackageNmae);
            }
        });
    }

    public static void startMapPip(String PackageName) {
        ThreadManager.getLongPool().execute(new Runnable() {
            @Override
            public void run() {
                WindowUtil.openPip(PackageName);
            }
        });
    }

    public static void startMapPip(final View v, final boolean show) {
        ThreadManager.getLongPool().execute(new Runnable() {
            @Override
            public void run() {
                WindowUtil.openPip(v, show);
            }
        });
    }

    public static void startMapPip(final View v, final boolean show, int millis) {
        delayMillis = millis;
        ThreadManager.getLongPool().execute(new Runnable() {
            @Override
            public void run() {
                WindowUtil.openPip(v, show);
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
        Log.d("startMapPip","startMapPip:" + AAppPackageNmae);
        Log.d("LZP", "openPip AppPackageNmae : " + AAppPackageNmae);
        try {
            // Loại bỏ Utils.topApp() để đảm bảo Map luôn được kích hoạt khi Launcher gọi
            if (AAppPackageNmae.equals(FytPackage.fourcamera2Action)) {
                Log.d("LZP", "fourcamera2Action");
                return;
            }
            intent = FytPackage.getIntent(LauncherApplication.sApp, AAppPackageNmae);
            if (intent == null) {
                Log.e("LZP", "Không tìm thấy Intent cho package: " + AAppPackageNmae);
                return;
            }
            
            // Đảm bảo trạng thái visible được reset để lệnh được thực thi
            visible = false;

            if (AAppPackageNmae.equals("com.syu.camera360")) {
                AndrewLauncherActivity.getInstance().sendBroadcast(new Intent("com.syu.camera360.show"));
            }
            AndrewLauncherActivity.getInstance().handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        SystemProperties.set("sys.lsec.force_pip", "true");
                    } catch (Throwable e) {
                    }
                    
                    WindowUtil.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    WindowUtil.intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    WindowUtil.intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    WindowUtil.intent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                    WindowUtil.intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);

                    // Các extra bổ trợ - gửi rect đã lưu
                    WindowUtil.intent.putExtra("force_pip", true);
                    WindowUtil.intent.putExtra("pip_mode", 1);

                    SharedPreferences sp = LauncherApplication.sApp.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
                    String savedRect = sp.getString(PREFS_RECT, "");
                    if (!savedRect.isEmpty()) {
                        WindowUtil.intent.putExtra("pip_rect", savedRect);
                        WindowUtil.intent.putExtra("rect", savedRect);
                    }

                    try {
                        AndrewLauncherActivity.getInstance().startActivity(WindowUtil.intent);
                        Log.d("LZP", "WindowUtil --- startActivity executed successfully");
                        visible = true;
                    } catch (Exception e) {
                        Log.e("LZP", "StartActivity failed", e);
                        visible = false;
                    }
                }
            }, delayMillis);
            Log.d("LZP", "WindowUtil --- Open window scheduled");
            delayMillis = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void openPip(View v, boolean show) {
        Log.d("startMapPip","startMapPip:" + AppPackageNmae);
        Log.d("LZP", "openPip AppPackageNmae" + AppPackageNmae);
        try {
            if ((!visible) &&Utils.topApp()) {
                if (AppPackageNmae.equals(FytPackage.fourcamera2Action)) {
                    Log.d("LZP", "fourcamera2Action");
                    return;
                }
                intent = FytPackage.getIntent(LauncherApplication.sApp, AppPackageNmae);
                if (intent == null) {
                    Log.e("LZP", "Không tìm thấy Intent cho package: " + AppPackageNmae);
                    return;
                }
                if (AppPackageNmae.equals("com.syu.camera360")) {
                    AndrewLauncherActivity.getInstance().sendBroadcast(new Intent("com.syu.camera360.show"));
                }
                AndrewLauncherActivity.getInstance().handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        WindowUtil.intent.putExtra("force_pip", true);
                        try {
                            SystemProperties.set("sys.lsec.force_pip", "true");
                        } catch (Throwable e) {
                        }
                        if (WindowUtil.intent != null) {
                            WindowUtil.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            LauncherApplication.sApp.startActivity(WindowUtil.intent);
                        }
                    }
                }, delayMillis);
                Log.d("LZP", "WindowUtil --- Open window done");
                visible = true;
                delayMillis = 0;
                return;
            }
            Log.d("LZP", "WindowUtil --- Open window filter");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removePip(View v) {
        Log.d("LZP", "removePip..");
        try {
            if (!AppPackageNmae.equals(FytPackage.fourcamera2Action)) {
                if (visible || v == null) {
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
