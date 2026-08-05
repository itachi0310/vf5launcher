package com.android.launcher6;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class le extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f371a;
    public static String b;
    public static int d;
    public static int e;
    public static int f;
    public static int g;
    public static int c = -1;
    public static int h = -1;
    public static int i = 0;
    public static int j = 0;
    public static int k = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            g = 0;
            return;
        }
        Bundle extras = intent.getExtras();
        if (!("com.android.launcher" + LauncherApplication.f88a.getResources().getInteger(R.integer.apps_launcher_packagename)).equals(((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName())) {
            c = -1;
            d = -1;
            e = 0;
            f = -1;
            g = 0;
            h = -1;
            i = -1;
            j = -1;
            k = 0;
            b = "";
            return;
        }
        if (!LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_widget_navi) || com.syu.a.a.h == 0 || extras == null) {
            return;
        }
        if (extras.getInt("KEY_TYPE") == 10001) {
            if (extras.getString("CUR_ROAD_NAME") != null && !extras.getString("CUR_ROAD_NAME").equals("")) {
                f371a = extras.getString("CUR_ROAD_NAME");
            }
            b = extras.getString("NEXT_ROAD_NAME");
            c = extras.getInt("CAMERA_DIST", 0);
            d = extras.getInt("ICON");
            e = extras.getInt("SEG_REMAIN_DIS");
            f = extras.getInt("ROUTE_ALL_DIS");
            g = extras.getInt("CUR_SPEED");
            i = extras.getInt("ROUTE_ALL_TIME");
            j = extras.getInt("ROUTE_REMAIN_TIME");
            k = extras.getInt("ROUTE_REMAIN_DIS");
            if (f371a != null && !LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_widget_design)) {
                com.fyt.car.c.h.a(new int[]{e, h}, null, null, new String[]{f371a}, null);
            }
        }
        if (extras.getInt("KEY_TYPE") == 10019) {
            h = extras.getInt("EXTRA_STATE");
            if (!LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_widget_design)) {
                com.fyt.car.c.i.a(new int[]{e, h}, null, null, new String[]{f371a}, null);
            }
        }
        Log.i("xx", "mCurDis_Remain: " + e + " mCurState: " + h);
        if (!LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_widget_design) || LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_widget_amauto)) {
            return;
        }
        com.syu.widget.a.l.a(LauncherApplication.f88a);
    }
}
