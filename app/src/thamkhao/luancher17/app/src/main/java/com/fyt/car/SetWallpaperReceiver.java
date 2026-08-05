package com.fyt.car;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.android.launcher17.Launcher;
import com.android.launcher17.LauncherApplication;
import com.android.launcher17.R;

/* JADX INFO: loaded from: classes.dex */
public class SetWallpaperReceiver extends BroadcastReceiver {
    private Handler handler = new Handler(Looper.getMainLooper());
    Runnable runnable = new Runnable() { // from class: com.fyt.car.SetWallpaperReceiver.1
        @Override // java.lang.Runnable
        public void run() {
            if (Launcher.getLauncher() == null) {
                SetWallpaperReceiver.this.handler.postDelayed(this, 1000L);
            } else {
                Launcher.getLauncher().setDefaultWallpaper();
            }
        }
    };

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String name = intent.getAction();
        String pak = (String) intent.getExtras().get("msg");
        int a = LauncherApplication.sApp.getResources().getInteger(R.integer.apps_launcher_packagename);
        String launcherpackagename = "com.android.launcher" + a;
        if (name.equals("android.intent.LAUNCHER.LauncherChoose") && pak.equals(launcherpackagename)) {
            this.handler.postDelayed(this.runnable, 200L);
        }
    }
}
