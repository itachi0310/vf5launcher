package com.syu.widget.a;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.android.launcher6.LauncherApplication;
import com.android.launcher6.R;
import com.android.launcher6.le;

/* JADX INFO: loaded from: classes.dex */
public class e extends l {
    private static int h = 0;

    public e(Context context, int i) {
        super(context, i);
    }

    @Override // com.syu.widget.a.l
    void a() {
        this.d = a("fyt_xml_naviwidget");
    }

    @Override // com.syu.widget.a.l
    protected void a(RemoteViews remoteViews) {
        if (com.syu.a.a.h == 0) {
            remoteViews.setTextViewText(a.b.a().fi, "0");
            remoteViews.setTextViewText(a.b.a().fj, "0m");
            remoteViews.setImageViewResource(a.b.a().fk, a.b.a().fM);
        }
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.apps_widget_amauto)) {
            if (le.g >= 10) {
                remoteViews.setImageViewResource(a.b.a().fn, a.b.a().fN + h);
                h++;
                if (h == LauncherApplication.f88a.getResources().getInteger(R.integer.apps_widget_pic_sum)) {
                    h = 0;
                }
            } else {
                remoteViews.setImageViewResource(a.b.a().fn, a.b.a().fN);
            }
        }
        switch (le.d) {
            case 0:
                remoteViews.setImageViewResource(a.b.a().fk, a.b.a().fM);
                break;
            case 2:
                remoteViews.setImageViewResource(a.b.a().fk, a.b.a().e);
                break;
            case 3:
                remoteViews.setImageViewResource(a.b.a().fk, a.b.a().f);
                break;
            case 4:
                remoteViews.setImageViewResource(a.b.a().fk, a.b.a().g);
                break;
            case 5:
                remoteViews.setImageViewResource(a.b.a().fk, a.b.a().h);
                break;
            case 6:
                remoteViews.setImageViewResource(a.b.a().fk, a.b.a().i);
                break;
            case 7:
                remoteViews.setImageViewResource(a.b.a().fk, a.b.a().j);
                break;
            case 8:
                remoteViews.setImageViewResource(a.b.a().fk, a.b.a().k);
                break;
            case 9:
                remoteViews.setImageViewResource(a.b.a().fk, a.b.a().m);
                break;
            case 16:
                remoteViews.setImageViewResource(a.b.a().fk, a.b.a().n);
                break;
            case 19:
                remoteViews.setImageViewResource(a.b.a().fk, a.b.a().l);
                break;
        }
        if (le.c == -1) {
            remoteViews.setViewVisibility(a.b.a().fl, 4);
        } else {
            remoteViews.setViewVisibility(a.b.a().fl, 0);
        }
        if (le.e > 1500) {
            remoteViews.setTextViewText(a.b.a().fj, String.valueOf(String.format("%1$.1f", Float.valueOf(le.e / 1000.0f))) + "km");
        } else {
            remoteViews.setTextViewText(a.b.a().fj, String.valueOf(le.e) + "m");
        }
        remoteViews.setTextViewText(a.b.a().fi, new StringBuilder(String.valueOf(le.g)).toString());
        switch (le.h) {
            case 2:
            case 9:
            case 12:
                le.d = 0;
                le.g = 0;
                le.e = 0;
                remoteViews.setTextViewText(a.b.a().fi, "0");
                remoteViews.setTextViewText(a.b.a().fj, "0m");
                remoteViews.setImageViewResource(a.b.a().fk, a.b.a().fM);
                break;
        }
    }

    @Override // com.syu.widget.a.l
    protected void b() {
        h.a(this);
        super.b();
    }

    @Override // com.syu.widget.a.l
    void b(RemoteViews remoteViews) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.autonavi.amapauto", "com.autonavi.auto.remote.fill.UsbFillActivity"));
        remoteViews.setOnClickPendingIntent(a.b.a().fm, PendingIntent.getActivity(this.f560a, 0, intent, 0));
    }

    @Override // com.syu.widget.a.l
    public void c() {
        h.b(this);
        super.c();
    }
}
