package com.android.launcher6;

import android.animation.AnimatorSet;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
class hh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f280a;
    private final /* synthetic */ AnimatorSet b;
    private final /* synthetic */ Collection c;

    hh(Launcher launcher, AnimatorSet animatorSet, Collection collection) {
        this.f280a = launcher;
        this.b = animatorSet;
        this.c = collection;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.playTogether(this.c);
        this.b.start();
    }
}
