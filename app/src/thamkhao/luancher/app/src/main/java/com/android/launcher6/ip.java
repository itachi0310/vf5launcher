package com.android.launcher6;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.content.IntentCompat;
import android.util.Log;
import java.lang.ref.WeakReference;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class ip {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f310a = true;
    private static WeakReference i;
    private static Context j;
    private static ip k;
    private iv b;
    private dv c;
    private c d;
    private of e;
    private boolean f;
    private float g;
    private ch l;
    private int h = HttpStatus.SC_MULTIPLE_CHOICES;
    private final ContentObserver m = new iq(this, new Handler());

    private ip() {
        if (j == null) {
            throw new IllegalStateException("LauncherAppState inited before app context set");
        }
        Log.v("Launcher", "LauncherAppState inited");
        if (j.getResources().getBoolean(R.bool.debug_memory_enabled)) {
            MemoryTracker.a(j, "L");
        }
        this.f = a(j.getResources());
        this.g = j.getResources().getDisplayMetrics().density;
        this.e = new of(j);
        this.c = new dv(j);
        f310a = j.getResources().getBoolean(R.bool.apps_widgets_detach);
        this.d = c.a(j.getString(R.string.app_filter_class));
        this.b = new iv(this, this.c, this.d);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addDataScheme("package");
        j.registerReceiver(this.b, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(IntentCompat.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE);
        intentFilter2.addAction(IntentCompat.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE);
        intentFilter2.addAction("android.intent.action.LOCALE_CHANGED");
        intentFilter2.addAction("android.intent.action.CONFIGURATION_CHANGED");
        j.registerReceiver(this.b, intentFilter2);
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction("android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED");
        j.registerReceiver(this.b, intentFilter3);
        IntentFilter intentFilter4 = new IntentFilter();
        intentFilter4.addAction("android.search.action.SEARCHABLES_CHANGED");
        j.registerReceiver(this.b, intentFilter4);
        j.getContentResolver().registerContentObserver(kq.f358a, true, this.m);
    }

    public static ip a() {
        if (k == null) {
            k = new ip();
        }
        return k;
    }

    public static void a(Context context) {
        if (j != null) {
            Log.w("Launcher", "setApplicationContext called twice! old=" + j + " new=" + context);
        }
        j = context.getApplicationContext();
    }

    static void a(LauncherProvider launcherProvider) {
        i = new WeakReference(launcherProvider);
    }

    public static boolean a(Resources resources) {
        return resources.getBoolean(R.bool.is_large_tablet);
    }

    public static boolean b(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    static LauncherProvider g() {
        return (LauncherProvider) i.get();
    }

    public static String h() {
        return "com.android.launcher6.prefs";
    }

    bl a(Context context, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (this.l == null) {
            this.l = new ch(context, context.getResources(), i2, i3, i4, i5, i6, i7);
        }
        bl blVarA = this.l.a();
        my.a(context.getResources().getDimensionPixelSize(R.dimen.app_icon_size));
        blVarA.a(context.getResources(), i4, i5, i6, i7);
        return blVarA;
    }

    iv a(Launcher launcher) {
        if (this.b == null) {
            throw new IllegalStateException("setLauncher() called before init()");
        }
        this.b.a((jn) launcher);
        return this.b;
    }

    boolean a(ComponentName componentName) {
        return this.d == null || this.d.a(componentName);
    }

    public Context b() {
        return j;
    }

    public void c() {
        j.unregisterReceiver(this.b);
        j.getContentResolver().unregisterContentObserver(this.m);
    }

    dv d() {
        return this.c;
    }

    iv e() {
        return this.b;
    }

    of f() {
        return this.e;
    }

    ch i() {
        return this.l;
    }

    public boolean j() {
        return this.f;
    }

    public float k() {
        return this.g;
    }

    public int l() {
        return this.h;
    }
}
