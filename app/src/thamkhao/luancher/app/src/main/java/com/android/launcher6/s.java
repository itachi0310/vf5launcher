package com.android.launcher6;

import android.view.View;
import android.widget.TabHost;

/* JADX INFO: loaded from: classes.dex */
class s implements TabHost.TabContentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppsCustomizeTabHost f463a;
    private final /* synthetic */ AppsCustomizePagedView b;

    s(AppsCustomizeTabHost appsCustomizeTabHost, AppsCustomizePagedView appsCustomizePagedView) {
        this.f463a = appsCustomizeTabHost;
        this.b = appsCustomizePagedView;
    }

    @Override // android.widget.TabHost.TabContentFactory
    public View createTabContent(String str) {
        return this.b;
    }
}
