package com.syu.widget.a;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.android.launcher6.Launcher;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static List f557a = new ArrayList();
    private static h b;

    public static void a(Context context) {
        synchronized (h.class) {
            if (b == null) {
                b = new h();
            }
            l.a(context, AppWidgetManager.getInstance(context));
            IntentFilter intentFilter = new IntentFilter("android.intent.action.TIME_TICK");
            intentFilter.addAction("android.intent.action.DATE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("com.syu.show_time");
            context.registerReceiver(b, intentFilter);
        }
        if (Launcher.G() != null) {
            Launcher.G().p.a(new k());
        }
    }

    public static void a(l lVar) {
        if (f557a.contains(lVar)) {
            return;
        }
        f557a.add(lVar);
    }

    public static void b(l lVar) {
        if (f557a.contains(lVar)) {
            f557a.remove(lVar);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        new Thread(new i(this)).start();
    }
}
