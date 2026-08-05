package com.syu.widget.a;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.android.launcher6.LauncherApplication;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    protected static SparseArray f = new SparseArray();
    protected static HashMap g = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f560a;
    protected int b;
    protected Resources c;
    protected AppWidgetManager e;
    protected int d = 0;
    private Handler h = new Handler();
    private Runnable i = new m(this);

    static {
        g.put(a.class, b.class);
        g.put(f.class, g.class);
        g.put(d.class, e.class);
    }

    public l(Context context, int i) {
        this.c = null;
        this.e = null;
        this.f560a = context;
        this.e = AppWidgetManager.getInstance(this.f560a);
        this.c = context.getResources();
        this.b = i;
        a();
        b();
    }

    public static l a(int i) {
        return (l) f.get(i);
    }

    public static void a(Context context) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(LauncherApplication.f88a);
        Iterator it = g.keySet().iterator();
        while (it.hasNext()) {
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) it.next()));
            if (appWidgetIds != null && appWidgetIds.length != 0) {
                for (int i : appWidgetIds) {
                    l lVarA = a(i);
                    if (lVarA != null) {
                        lVarA.d();
                    }
                }
            }
        }
    }

    public static void a(Context context, AppWidgetManager appWidgetManager) {
        Class cls;
        Exception e;
        for (Class cls2 : g.keySet()) {
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, (Class<?>) cls2));
            if (appWidgetIds != null && appWidgetIds.length != 0) {
                int length = appWidgetIds.length;
                int i = 0;
                Class cls3 = cls2;
                while (i < length) {
                    int i2 = appWidgetIds[i];
                    if (a(i2) != null) {
                        cls = cls3;
                    } else {
                        try {
                            cls = (Class) g.get(cls3);
                            try {
                                cls.getConstructor(Context.class, Integer.TYPE).newInstance(context, Integer.valueOf(i2));
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                            }
                        } catch (Exception e3) {
                            cls = cls3;
                            e = e3;
                        }
                    }
                    i++;
                    cls3 = cls;
                }
            }
        }
    }

    public int a(String str) {
        return a(str, "layout");
    }

    public int a(String str, String str2) {
        return this.c.getIdentifier(str, str2, this.f560a.getPackageName());
    }

    abstract void a();

    abstract void a(RemoteViews remoteViews);

    protected void b() {
        synchronized (f) {
            f.put(this.b, this);
        }
    }

    abstract void b(RemoteViews remoteViews);

    public void c() {
        synchronized (f) {
            f.remove(this.b);
        }
    }

    public void c(RemoteViews remoteViews) {
        if (this.b == 0 || remoteViews == null) {
            return;
        }
        this.e.updateAppWidget(this.b, remoteViews);
    }

    public void d() {
        this.h.removeCallbacks(this.i);
        this.h.postDelayed(this.i, 300L);
    }

    public RemoteViews e() {
        RemoteViews remoteViews = null;
        if (this.d != 0 && (remoteViews = new RemoteViews(this.f560a.getPackageName(), this.d)) != null) {
            a(remoteViews);
            b(remoteViews);
        }
        return remoteViews;
    }
}
