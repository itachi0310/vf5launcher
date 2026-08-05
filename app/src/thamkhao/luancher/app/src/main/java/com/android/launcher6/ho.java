package com.android.launcher6;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ho implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f287a;
    private final /* synthetic */ ArrayList b;

    ho(Launcher launcher, ArrayList arrayList) {
        this.f287a = launcher;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f287a.d(this.b);
    }
}
