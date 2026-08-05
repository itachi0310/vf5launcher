package com.syu.util;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Log;
import android.view.View;
import com.android.launcher17.Launcher;
import com.android.launcher17.LauncherApplication;
import com.fyt.car.MapConfig;
import com.fyt.thread.ThreadManager;
import com.syu.ipc.data.FinalCanbus;
import com.syu.log.LogPreview;

/* JADX INFO: loaded from: classes.dex */
public class WindowUtil {
    private static final String TAG = "WindowUtil";
    private static Intent intent;
    private static IActivityManager mActivityManager;
    public static String AppPackageNmae = "";
    public static boolean visible = true;
    public static int delayMillis = 0;

    public static void initDefaultApp() {
        intent = new Intent();
        removePip(null);
        AppPackageNmae = SystemProperties.get("persist.launcher.packagename", "");
        if (AppPackageNmae.isEmpty()) {
            SystemProperties.set("persist.launcher.packagename", FytPackage.GaodeACTION);
            AppPackageNmae = SystemProperties.get("persist.launcher.packagename", "");
        }
        LogPreview.show("AppPackageNmae:" + AppPackageNmae);
    }

    public static void startMapPip(final View v, final boolean show) {
        ThreadManager.getLongPool().execute(new Runnable() { // from class: com.syu.util.WindowUtil.1
            @Override // java.lang.Runnable
            public void run() {
                WindowUtil.openPip(v, show);
            }
        });
    }

    public static void startMapPip(final View v, final boolean show, int millis) {
        delayMillis = millis;
        ThreadManager.getLongPool().execute(new Runnable() { // from class: com.syu.util.WindowUtil.2
            @Override // java.lang.Runnable
            public void run() {
                WindowUtil.openPip(v, show);
            }
        });
    }

    public static void removePip(final View v, int millis) {
        delayMillis = millis;
        ThreadManager.getLongPool().execute(new Runnable() { // from class: com.syu.util.WindowUtil.3
            @Override // java.lang.Runnable
            public void run() {
                WindowUtil.removePip(v);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void openPip(View v, boolean show) {
        LogPreview.show("startMapPip:" + AppPackageNmae);
        Log.d("LZP", "openPip AppPackageNmae" + AppPackageNmae);
        try {
            if (!mActivityManager.getPinnedStackVisible()) {
                if (AppPackageNmae.equals(FytPackage.fourcamera2Action)) {
                    Log.d("LZP", "fourcamera2Action");
                    return;
                }
                intent = FytPackage.getIntent(LauncherApplication.sApp, AppPackageNmae);
                if (AppPackageNmae.equals("com.syu.camera360")) {
                    Launcher.mLauncher.sendBroadcast(new Intent("com.syu.camera360.show"));
                }
                Launcher.getLauncher().handler.postDelayed(new Runnable() { // from class: com.syu.util.WindowUtil.4
                    @Override // java.lang.Runnable
                    public void run() {
                        WindowUtil.intent.putExtra("force_pip", true);
                        SystemProperties.set("sys.lsec.force_pip", "true");
                        LauncherApplication.sApp.startActivity(WindowUtil.intent);
                    }
                }, delayMillis);
                Log.d("LZP", "WindowUtil --- Open window done");
                visible = true;
                delayMillis = 0;
                return;
            }
            Log.d("LZP", "WindowUtil --- Open window filter");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void removePip(View v) {
        Log.d("LZP", "removePip..");
        try {
            if (!AppPackageNmae.equals(FytPackage.fourcamera2Action)) {
                mActivityManager = ActivityManager.getService();
                if (mActivityManager.getPinnedStackVisible()) {
                    Launcher.getLauncher().handler.postDelayed(new Runnable() { // from class: com.syu.util.WindowUtil.5
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                WindowUtil.mActivityManager.setPinnedStackVisible(false);
                                Log.d("LZP", "WindowUtil --- remove window done");
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
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
                LogPreview.show("WindowUtil ------ 关闭窗口被过滤");
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public static void sendBROADCAST(boolean show) {
        Intent intent2 = new Intent();
        intent2.setAction("FOURCAMERA2_BROADCAST_RECV");
        Bundle bundle = new Bundle();
        bundle.putBoolean("SHOW", show);
        bundle.putInt(MapConfig.KEY_TYPE, 10000);
        if (Utils.getRes().getDisplayMetrics().widthPixels == 1024) {
            bundle.putInt("POS_X", FinalCanbus.CAR_0397);
            bundle.putInt("POS_Y", FinalCanbus.CAR_XP2_OPEL);
            bundle.putInt("POS_W", 614);
            bundle.putInt("POS_H", FinalCanbus.CAR_FYT_WC1_15YiDong);
        } else {
            bundle.putInt("POS_X", 495);
            bundle.putInt("POS_Y", FinalCanbus.CAR_RZC_XP1_JiangHuaiRuiFengS3);
            bundle.putInt("POS_W", 770);
            bundle.putInt("POS_H", 432);
        }
        intent2.putExtras(bundle);
        LauncherApplication.sApp.sendBroadcast(intent2);
    }

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
