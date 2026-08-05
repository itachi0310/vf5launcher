package com.android.launcher6;

import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;

/* JADX INFO: loaded from: classes.dex */
class eu implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f212a;
    private final /* synthetic */ int b;
    private final /* synthetic */ AppWidgetHostView c;
    private final /* synthetic */ int d;

    eu(Launcher launcher, int i, AppWidgetHostView appWidgetHostView, int i2) {
        this.f212a = launcher;
        this.b = i;
        this.c = appWidgetHostView;
        this.d = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f212a.a(this.b, this.f212a.bs.h, this.f212a.bs.i, this.c, (AppWidgetProviderInfo) null);
        this.f212a.a(this.d != 0, false, (Runnable) null);
    }
}
