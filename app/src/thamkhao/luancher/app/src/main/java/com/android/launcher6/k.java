package com.android.launcher6;

import android.appwidget.AppWidgetManager;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppsCustomizePagedView f345a;
    private final /* synthetic */ Bundle b;
    private final /* synthetic */ mf c;

    k(AppsCustomizePagedView appsCustomizePagedView, Bundle bundle, mf mfVar) {
        this.f345a = appsCustomizePagedView;
        this.b = bundle;
        this.c = mfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f345a.e = this.f345a.as.q().allocateAppWidgetId();
        if (this.b == null) {
            if (AppWidgetManager.getInstance(this.f345a.as).bindAppWidgetIdIfAllowed(this.f345a.e, this.c.f390a)) {
                this.f345a.d = 1;
            }
        } else if (AppWidgetManager.getInstance(this.f345a.as).bindAppWidgetIdIfAllowed(this.f345a.e, this.c.f390a, this.b)) {
            this.f345a.d = 1;
        }
    }
}
