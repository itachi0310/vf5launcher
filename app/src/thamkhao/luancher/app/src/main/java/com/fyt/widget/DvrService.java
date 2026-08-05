package com.fyt.widget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class DvrService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f489a = "";
    public static String b = "";
    public static int c = 0;
    public static String d = "";
    public static long e = 0;
    public static long f = 0;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        if ("com.fyt.launcher.dvr".equals(intent.getAction())) {
            c = intent.getExtras().getInt("DVR");
            Log.i("hy", "state" + c);
            com.fyt.car.c.g.a(new int[]{c}, null, null, null, null);
        }
        return super.onStartCommand(intent, i, i2);
    }
}
