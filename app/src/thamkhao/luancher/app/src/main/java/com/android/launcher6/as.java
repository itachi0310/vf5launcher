package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class as implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ar f116a;

    as(ar arVar) {
        this.f116a = arVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f116a.f115a.getParent() == null || !this.f116a.f115a.hasWindowFocus() || this.f116a.b || !this.f116a.f115a.performLongClick()) {
            return;
        }
        this.f116a.f115a.setPressed(false);
        this.f116a.b = true;
    }
}
