package com.syu.g;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Log;
import android.view.View;
import com.android.launcher6.LauncherApplication;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f541a = "";
    public static boolean b = false;
    private static Intent c;
    private static IActivityManager d;

    public static void a() {
        c = new Intent();
        f541a = SystemProperties.get("persist.launcher.packagename", "");
    }

    public static void a(View view) {
        if (a(f541a)) {
            com.syu.d.a.b("startMapPip  " + f541a);
            if (f541a.equals("")) {
                return;
            }
            if (b) {
                com.syu.d.a.b("WindowUtil --- 打开窗口被过滤");
                return;
            }
            new Thread(new o()).start();
            com.syu.d.a.b("WindowUtil --- 打开窗口已执行");
            b = true;
        }
    }

    public static boolean a(String str) {
        PackageInfo packageInfo;
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            packageInfo = LauncherApplication.f88a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static void b(View view) {
        if (!a(f541a)) {
            Log.i("hy", "removePip 1");
            return;
        }
        if (f541a.equals("")) {
            return;
        }
        if (!b) {
            Log.i("hy", "removePip 4 过滤");
            com.syu.d.a.b("WindowUtil --- 关闭窗口被过滤");
            return;
        }
        Log.i("hy", "removePip 3");
        com.syu.d.a.b("WindowUtil --- 关闭窗口");
        d = ActivityManager.getService();
        try {
            if (f541a.equals("com.syu.camera360")) {
                LauncherApplication.f88a.sendBroadcast(new Intent("com.syu.camera360.hide"));
            }
            d.setPinnedStackVisible(false);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        b = false;
    }
}
