package com.android.launcher6;

import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.os.Bundle;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
class mf extends md {
    int b;
    int c;
    int d;
    int e;
    int s;
    int t;
    AppWidgetProviderInfo u;
    AppWidgetHostView v;
    Bundle w;
    String x;
    Parcelable y;

    public mf(AppWidgetProviderInfo appWidgetProviderInfo, String str, Parcelable parcelable) {
        this.w = null;
        this.g = 4;
        this.u = appWidgetProviderInfo;
        this.f390a = appWidgetProviderInfo.provider;
        this.b = appWidgetProviderInfo.minWidth;
        this.c = appWidgetProviderInfo.minHeight;
        this.d = appWidgetProviderInfo.minResizeWidth;
        this.e = appWidgetProviderInfo.minResizeHeight;
        this.s = appWidgetProviderInfo.previewImage;
        this.t = appWidgetProviderInfo.icon;
        if (str == null || parcelable == null) {
            return;
        }
        this.x = str;
        this.y = parcelable;
    }

    public mf(mf mfVar) {
        this.w = null;
        this.b = mfVar.b;
        this.c = mfVar.c;
        this.d = mfVar.d;
        this.e = mfVar.e;
        this.s = mfVar.s;
        this.t = mfVar.t;
        this.u = mfVar.u;
        this.v = mfVar.v;
        this.x = mfVar.x;
        this.y = mfVar.y;
        this.f390a = mfVar.f390a;
        this.g = mfVar.g;
        this.l = mfVar.l;
        this.m = mfVar.m;
        this.n = mfVar.n;
        this.o = mfVar.o;
        this.w = mfVar.w != null ? (Bundle) mfVar.w.clone() : null;
    }

    @Override // com.android.launcher6.ec
    public String toString() {
        return "Widget: " + this.f390a.toShortString();
    }
}
