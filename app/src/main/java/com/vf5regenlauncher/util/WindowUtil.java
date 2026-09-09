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

import com.vf5regenlauncher.AndrewLauncherActivity;
import com.vf5regenlauncher.util.android.os.SystemProperties;
import com.vf5regenlauncher.util.launcher.LauncherApplication;
import com.vf5regenlauncher.util.thread.ThreadManager;


public class WindowUtil {
    private static final String TAG = "WindowUtil";
    private static Intent intent;
    private static IActivityManager mActivityManager;
    public static String AppPackageNmae = "com.google.android.maps";
    public static boolean visible = true;
    public static int delayMillis = 0;

    public static void initDefaultApp() {
        intent = new Intent();
        removePip(null);
        AppPackageNmae = SystemProperties.get("persist.launcher.packagename", "com.google.android.maps");
        if (AppPackageNmae.isEmpty()) {
            try {
                SystemProperties.set("persist.launcher.packagename", FytPackage.googlemapAction);
            } catch (Throwable e) {
            }
            AppPackageNmae = SystemProperties.get("persist.launcher.packagename", "com.google.android.maps");
        }
        Log.d("AppPackageNmae", "AppPackageNmae:" + AppPackageNmae);
    }

    private static IActivityManager getIActivityManager() {
        if (mActivityManager == null) {
            try {
                mActivityManager = (IActivityManager) ActivityManager.class.getMethod("getService").invoke(null);
                Log.d(TAG, "mActivityManager: " + mActivityManager);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mActivityManager;
    }


    private static boolean isPinnedStackVisible() {
        IActivityManager am = getIActivityManager();
        Log.d(TAG, "IActivityManager am: " + am);
        if (am != null) {
            try {
                return am.getPinnedStackVisible();
            } catch (Throwable t) {
                Log.e(TAG, "getPinnedStackVisible error: " + t.getMessage());
            }
        }
        return false;
    }

    private static void setPinnedStackVisibleSafe(boolean visible) {
        IActivityManager am = getIActivityManager();
        if (am != null) {
            try {
                am.setPinnedStackVisible(visible);
            } catch (Throwable t) {
                Log.e(TAG, "setPinnedStackVisible error: " + t.getMessage());
            }
        }
    }

    public static void startMapPip() {
        ThreadManager.getLongPool().execute(new Runnable() {
            @Override
            public void run() {
                WindowUtil.openPip(AppPackageNmae);
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
            if (!isPinnedStackVisible()) {
                if (AAppPackageNmae.equals(FytPackage.fourcamera2Action)) {
                    Log.d("LZP", "fourcamera2Action");
                    return;
                }
                intent = FytPackage.getIntent(LauncherApplication.sApp, AAppPackageNmae);
                if (AAppPackageNmae.equals("com.syu.camera360")) {
                    AndrewLauncherActivity.getInstance().sendBroadcast(new Intent("com.syu.camera360.show"));
                }
                AndrewLauncherActivity.getInstance().handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        WindowUtil.intent.putExtra("force_pip", true);
                        WindowUtil.intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        WindowUtil.intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

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
                            SystemProperties.set("sys.lsec.force_pip", "true");
                        } catch (Throwable e) {
                        }
//                        LauncherApplication.sApp.startActivity(WindowUtil.intent);
                        AndrewLauncherActivity.getInstance().startActivity(WindowUtil.intent);
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

    private static void openPip(View v, boolean show) {
        Log.d("startMapPip","startMapPip:" + AppPackageNmae);
        Log.d("LZP", "openPip AppPackageNmae" + AppPackageNmae);
        try {
            if (!isPinnedStackVisible()) {
                if (AppPackageNmae.equals(FytPackage.fourcamera2Action)) {
                    Log.d("LZP", "fourcamera2Action");
                    return;
                }
                intent = FytPackage.getIntent(LauncherApplication.sApp, AppPackageNmae);
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
                if (isPinnedStackVisible()) {
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
