package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class at implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Cling f117a;

    at(Cling cling) {
        this.f117a = cling;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f117a.setFocusable(true);
        this.f117a.requestFocus();
    }
}
