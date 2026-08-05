package com.syu.a;

import android.content.ComponentName;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.view.MotionEventCompat;
import com.android.launcher6.LauncherApplication;
import com.android.launcher6.R;
import com.syu.g.j;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.android.launcher6.c implements com.syu.f.e, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap f508a;
    public static final HashMap b = new HashMap();
    Looper c = null;
    Handler d = null;
    e e;

    static {
        f508a = null;
        f508a = new HashMap();
        f508a.put("com.android.calendar", true);
        f508a.put("com.android.inputmethod.latin", false);
        f508a.put("com.syu.exdvr", false);
        f508a.put("com.syu.dvr", false);
        f508a.put("com.syu.ipod", true);
        f508a.put("com.syu.dvd", false);
        f508a.put("com.syu.cdc", true);
        f508a.put("com.syu.canbus", false);
        f508a.put("com.syu.calibration", true);
        f508a.put("com.syu.tv", false);
        f508a.put("com.android.settings", true);
        f508a.put("com.syu.radio", true);
        f508a.put("com.syu.bt", true);
        f508a.put("com.syu.allapps", false);
        f508a.put("com.syu.camera360", false);
    }

    @Override // com.android.launcher6.c
    public void a() {
        if (this.c == null) {
            HandlerThread handlerThread = new HandlerThread("app_visibility_handler");
            handlerThread.start();
            this.c = handlerThread.getLooper();
        }
        this.d = new Handler(this.c);
        a.a(LauncherApplication.f88a).a().a(0, this, 39);
    }

    @Override // com.syu.f.e
    public void a(int i, int[] iArr, float[] fArr, String[] strArr) {
        boolean z = true;
        switch (i) {
            case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                if (j.a(iArr, 1) && j.a(strArr, 1)) {
                    String str = strArr[0];
                    boolean zContainsKey = f508a.containsKey(str);
                    if (iArr[0] == 1 && zContainsKey) {
                        f508a.remove(str);
                    } else if (iArr[0] == 1 || zContainsKey) {
                        z = false;
                    } else {
                        f508a.put(str, false);
                    }
                    if (z && this.e != null && this.d != null) {
                        this.d.removeCallbacks(this);
                        this.d.postDelayed(this, 150L);
                    }
                    if (z && LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_all_disable)) {
                        LauncherApplication.a(str, iArr[0]);
                        break;
                    }
                }
                break;
        }
    }

    public void a(e eVar) {
        this.e = eVar;
    }

    @Override // com.android.launcher6.c
    public boolean a(ComponentName componentName) {
        if (componentName == null) {
            return false;
        }
        String packageName = componentName.getPackageName();
        if (packageName == null || !f508a.containsKey(packageName)) {
            return true;
        }
        return ((Boolean) f508a.get(packageName)).booleanValue();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.e != null) {
            this.e.a();
        }
    }
}
