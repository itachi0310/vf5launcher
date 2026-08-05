package com.android.launcher6;

import android.app.Application;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemProperties;
import android.util.DisplayMetrics;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class LauncherApplication extends Application {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LauncherApplication f88a;
    public static Boolean g;
    public static Boolean h;
    public static String i;
    public static String j;
    public static boolean l;
    public static boolean m;
    private com.android.a.a n;
    private Typeface o;
    private String p;
    private final String q = "firenze.apk";
    public static Handler b = new Handler(Looper.getMainLooper());
    public static boolean c = false;
    public static float d = 0.0f;
    public static float e = 0.0f;
    public static int f = 0;
    public static boolean k = false;

    public static void a(String str, int i2) {
        int i3 = i2 == 0 ? 2 : 1;
        try {
            if (i3 != f88a.getPackageManager().getApplicationEnabledSetting(str)) {
                f88a.getPackageManager().setApplicationEnabledSetting(str, i3, 1);
            }
        } catch (Exception e2) {
        }
    }

    public String a() {
        return this.p;
    }

    public Typeface b() {
        return this.o;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        com.fyt.b.d.a(this);
        j = SystemProperties.get("ro.client.foreign", "false");
        ax.a(getApplicationContext());
        f88a = this;
        com.syu.g.d.a(this, R.xml.custom_icons);
        com.syu.h.b.a(this);
        SystemProperties.set("persist.syu.launcher.haspip", "true");
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Log.i("mql", String.valueOf(displayMetrics.widthPixels) + "," + displayMetrics.heightPixels);
        if (displayMetrics.widthPixels == 1280 && displayMetrics.heightPixels == 720) {
            SystemProperties.set("sys.lsec.pip_rect", "128 88 802 474");
        } else {
            SystemProperties.set("sys.lsec.pip_rect", "98 76 656 396");
        }
        ip.a(this);
        ip.a();
        com.syu.a.a.a(this);
        this.o = Typeface.createFromAsset(getAssets(), "fonts/LTHJ.TTF");
        this.n = new com.android.a.a(this, "table_1", null, 1);
        this.p = String.valueOf(f88a.getFilesDir().getAbsolutePath()) + File.separator + "firenze.apk";
        if (!new File(this.p).exists()) {
            com.fyt.b.b.a.a(this, "firenze.apk", this.p);
        }
        l = com.syu.g.l.c().getBoolean("mAppWallPaper", true);
        m = com.syu.g.l.c().getBoolean("mWallPaperUpdate", true);
        if (getResources().getBoolean(R.bool.apps_widget_amauto)) {
            b.postDelayed(new iu(this), 300L);
        }
        if (getResources().getBoolean(R.bool.apps_foreign_launcher)) {
            try {
                SystemProperties.get("sys.fyt.subplatform", "0");
                if (SystemProperties.get("ro.client.foreign", "false").equals("true")) {
                    c = true;
                }
            } catch (Exception e2) {
            }
        }
        f = getResources().getInteger(R.integer.appwidget_host_id) + 1024;
        if (getResources().getBoolean(R.bool.apps_textview_shadow)) {
            d = 4.0f;
            e = 1.75f;
        }
        if (!getResources().getBoolean(R.bool.showFrontAndAux)) {
            g = Boolean.valueOf(SystemProperties.getBoolean("persist.fyt.zh_frontview_enable", true));
            h = Boolean.valueOf(SystemProperties.getBoolean("persist.fyt.justfrontView", false));
            if (g.booleanValue()) {
                a("com.syu.frontvideo", 1);
                if (!h.booleanValue()) {
                    a("com.syu.av", 0);
                }
            } else {
                a("com.syu.frontvideo", 0);
                if (!h.booleanValue()) {
                    a("com.syu.av", 1);
                }
            }
        }
        com.syu.g.n.a();
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        ip.a().c();
    }
}
