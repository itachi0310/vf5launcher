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

        // Danh sách các key cấu hình navi phổ biến trên màn hình Android Auto
        String[] naviKeys = {
            "persist.syu.navi.packagename", // Key chuẩn của SYU/FYT
            "persist.launcher.packagename", // Key tùy chỉnh của launcher cũ
            "persist.sys.fyt.navi_package"  // Một số bản mod khác
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

        // Nếu vẫn không tìm thấy, dùng Google Maps làm mặc định (kiểm tra cả bản cũ và mới)
        if (AppPackageNmae.isEmpty()) {
            if (checkAppInstalled(FytPackage.mapsAction)) {
                AppPackageNmae = FytPackage.mapsAction;
            } else if (checkAppInstalled("com.google.android.maps")) {
                AppPackageNmae = "com.google.android.maps";
            } else {
                // Fallback cuối cùng nếu không có gì cả
                AppPackageNmae = FytPackage.mapsAction;
            }
            // Lưu lại vào persist.launcher.packagename để các lần sau nhanh hơn
            SystemProperties.set("persist.launcher.packagename", AppPackageNmae);
        }
        
        Log.d("AppPackageNmae", "AppPackageNmae final: " + AppPackageNmae);
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

    public static void openPip(String AAppPackageNmae, boolean force) {
        Log.d("startMapPip", "startMapPip:" + AAppPackageNmae + " (force=" + force + ", visible=" + visible + ")");
        try {
            if (AAppPackageNmae.equals(FytPackage.fourcamera2Action)) {
                Log.d("LZP", "fourcamera2Action ignored");
                return;
            }

            // Theo launcher 34: Chỉ chạy nếu chưa visible, hoặc nếu yêu cầu force, 
            // và quan trọng nhất là Launcher phải đang ở Foreground (topApp)
            if ((!visible || force) && Utils.topApp()) {
                intent = FytPackage.getIntent(LauncherApplication.sApp, AAppPackageNmae);
                if (intent == null) {
                    Log.e("LZP", "Không tìm thấy Intent cho package: " + AAppPackageNmae);
                    return;
                }

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
            } else {
                Log.d("LZP", "WindowUtil --- Open window skipped (already visible or not topApp)");
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
