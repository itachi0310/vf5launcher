package com.android.launcher6;

import android.animation.AnimatorSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ha implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f273a;
    private final /* synthetic */ AnimatorSet b;
    private final /* synthetic */ AppsCustomizeTabHost c;
    private final /* synthetic */ float d;
    private final /* synthetic */ View e;
    private final /* synthetic */ boolean f;

    ha(Launcher launcher, AnimatorSet animatorSet, AppsCustomizeTabHost appsCustomizeTabHost, float f, View view, boolean z) {
        this.f273a = launcher;
        this.b = animatorSet;
        this.c = appsCustomizeTabHost;
        this.d = f;
        this.e = view;
        this.f = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f273a.ai != this.b) {
            return;
        }
        this.f273a.a(this.c, this.d);
        this.f273a.b(this.e, this.f, false);
        this.f273a.b((View) this.c, this.f, false);
        ik.a(this.f273a.ai, this.c);
    }
}
