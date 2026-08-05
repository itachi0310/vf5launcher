package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class ov implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f449a;
    private final /* synthetic */ ec b;
    private final /* synthetic */ is c;
    private final /* synthetic */ CellLayout d;

    ov(Workspace workspace, ec ecVar, is isVar, CellLayout cellLayout) {
        this.f449a = workspace;
        this.b = ecVar;
        this.c = isVar;
        this.d = cellLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f449a.aQ.f().a(this.b, this.c, this.d);
    }
}
