package com.fyt.car;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class VideoService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f483a = "";
    public static String b = "";
    public static Boolean c = false;
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
        if ("com.fyt.launcher.video".equals(intent.getAction())) {
            c = Boolean.valueOf(intent.getExtras().getBoolean("play_state"));
            c.b.a(null, new long[]{f, e}, null, new String[]{c.toString(), b, f483a}, null);
        }
        return super.onStartCommand(intent, i, i2);
    }
}
