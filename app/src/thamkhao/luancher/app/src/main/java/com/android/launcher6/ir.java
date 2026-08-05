package com.android.launcher6;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class ir extends AppWidgetHost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Launcher f312a;

    public ir(Launcher launcher, int i) {
        super(launcher, i);
        this.f312a = launcher;
    }

    @Override // android.appwidget.AppWidgetHost
    protected AppWidgetHostView onCreateView(Context context, int i, AppWidgetProviderInfo appWidgetProviderInfo) {
        return new is(context);
    }

    @Override // android.appwidget.AppWidgetHost
    protected void onProvidersChanged() {
        this.f312a.e(iv.b(this.f312a));
    }

    @Override // android.appwidget.AppWidgetHost
    public void stopListening() {
        super.stopListening();
        clearViews();
    }
}
