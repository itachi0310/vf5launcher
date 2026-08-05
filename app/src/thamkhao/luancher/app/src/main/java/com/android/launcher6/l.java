package com.android.launcher6;

import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;

/* JADX INFO: loaded from: classes.dex */
class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppsCustomizePagedView f366a;
    private final /* synthetic */ AppWidgetProviderInfo b;
    private final /* synthetic */ mf c;

    l(AppsCustomizePagedView appsCustomizePagedView, AppWidgetProviderInfo appWidgetProviderInfo, mf mfVar) {
        this.f366a = appsCustomizePagedView;
        this.b = appWidgetProviderInfo;
        this.c = mfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f366a.d != 1) {
            return;
        }
        AppWidgetHostView appWidgetHostViewCreateView = this.f366a.as.q().createView(this.f366a.getContext(), this.f366a.e, this.b);
        this.c.v = appWidgetHostViewCreateView;
        this.f366a.d = 2;
        appWidgetHostViewCreateView.setVisibility(4);
        int[] iArrA = this.f366a.as.I().a(this.c.l, this.c.m, (ec) this.c, false);
        bw bwVar = new bw(iArrA[0], iArrA[1]);
        bwVar.b = 0;
        bwVar.f145a = 0;
        bwVar.c = true;
        appWidgetHostViewCreateView.setLayoutParams(bwVar);
        this.f366a.as.f().addView(appWidgetHostViewCreateView);
    }
}
