package com.syu.widget.a;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class n extends AppWidgetProvider {
    public abstract void a(Context context, int i);

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        super.onDeleted(context, iArr);
        for (int i : iArr) {
            l lVarA = l.a(i);
            if (lVarA != null) {
                lVarA.c();
            }
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        String action = intent.getAction();
        Log.e("TT", "WidgetProvider onReceive =====  ");
        if (action.equals("android.appwidget.action.APPWIDGET_UPDATE")) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, getClass()));
            if (appWidgetIds.length > 0) {
                onUpdate(context, appWidgetManager, appWidgetIds);
            }
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i : iArr) {
            Log.e("TT", "WidgetProvider onUpdate =====  " + i);
            a(context, i);
        }
        super.onUpdate(context, appWidgetManager, iArr);
    }
}
