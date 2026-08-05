package com.android.launcher6;

import android.appwidget.AppWidgetHostView;
import android.content.ComponentName;
import android.content.ContentValues;

/* JADX INFO: loaded from: classes.dex */
class it extends ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f314a;
    ComponentName b;
    int c = -1;
    int d = -1;
    AppWidgetHostView e = null;
    private boolean s;

    it(int i, ComponentName componentName) {
        this.f314a = -1;
        this.g = 4;
        this.f314a = i;
        this.b = componentName;
        this.l = -1;
        this.m = -1;
    }

    @Override // com.android.launcher6.ec
    void a(ContentValues contentValues) {
        super.a(contentValues);
        contentValues.put("appWidgetId", Integer.valueOf(this.f314a));
        contentValues.put("appWidgetProvider", this.b.flattenToString());
    }

    void a(Launcher launcher) {
        if (this.s) {
            return;
        }
        b(launcher);
    }

    void b(Launcher launcher) {
        e.a(this.e, launcher, this.l, this.m);
        this.s = true;
    }

    @Override // com.android.launcher6.ec
    void b_() {
        super.b_();
        this.e = null;
    }

    @Override // com.android.launcher6.ec
    public String toString() {
        return "AppWidget(id=" + Integer.toString(this.f314a) + ")";
    }
}
