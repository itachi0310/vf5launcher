package com.fyt.car;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.android.launcher6.LauncherApplication;
import com.android.launcher6.R;
import com.syu.widget.a.l;

/* JADX INFO: loaded from: classes.dex */
public class MusicService extends Service {
    public static byte[] f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f481a = "";
    public static String b = "";
    public static String c = "";
    public static Boolean d = false;
    public static String e = "";
    public static long g = 0;
    public static long h = 0;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        if ("com.fyt.launcher.music".equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            g = extras.getLong("play_total");
            h = extras.getLong("play_cur");
            f481a = extras.getString("title");
            b = extras.getString("play_artist");
            c = extras.getString("play_path");
            d = Boolean.valueOf(extras.getBoolean("play_state"));
            if (extras.getString("play_album") != null) {
                e = extras.getString("play_album");
            } else {
                e = "";
            }
            if (LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_widget_design)) {
                l.a(LauncherApplication.f88a);
            } else {
                c.f485a.a(null, new long[]{g, h}, null, new String[]{f481a, b, d.toString(), e, c}, f);
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
