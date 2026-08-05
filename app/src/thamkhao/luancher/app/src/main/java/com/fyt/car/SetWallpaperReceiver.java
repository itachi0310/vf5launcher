package com.fyt.car;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.android.launcher6.LauncherApplication;
import com.android.launcher6.R;
import com.syu.g.l;

/* JADX INFO: loaded from: classes.dex */
public class SetWallpaperReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f482a;
    String b;
    private Handler d = new Handler(Looper.getMainLooper());
    Runnable c = new d(this);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!intent.getAction().equals("android.intent.action.WALLPAPER_CHANGED")) {
            this.f482a = intent.getAction();
            if (intent.getExtras() != null) {
                this.b = (String) intent.getExtras().get("msg");
            }
            String str = "com.android.launcher" + LauncherApplication.f88a.getResources().getInteger(R.integer.apps_launcher_packagename);
            if (this.f482a.equals("android.intent.LAUNCHER.LauncherChoose") && this.b.equals(str)) {
                com.syu.d.a.b("android.intent.LAUNCHER.LauncherChoose");
                this.d.postDelayed(this.c, 200L);
                return;
            }
            return;
        }
        if (!LauncherApplication.l) {
            LauncherApplication.m = false;
            SharedPreferences.Editor editorEdit = l.c().edit();
            editorEdit.putBoolean("mWallPaperUpdate", LauncherApplication.m);
            editorEdit.commit();
            return;
        }
        LauncherApplication.l = false;
        LauncherApplication.m = true;
        SharedPreferences.Editor editorEdit2 = l.c().edit();
        editorEdit2.putBoolean("mAppWallPaper", LauncherApplication.l);
        editorEdit2.putBoolean("mWallPaperUpdate", LauncherApplication.m);
        editorEdit2.commit();
    }
}
