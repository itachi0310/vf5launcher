package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
public class lh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f372a;
    int b;

    public lh() {
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.app_indicator)) {
            this.f372a = a.b.a().ba;
            this.b = a.b.a().bb;
        } else {
            this.f372a = a.b.a().bc;
            this.b = a.b.a().bd;
        }
    }

    public lh(int i, int i2) {
        this.f372a = i;
        this.b = i2;
    }
}
