package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class es extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f210a;
    private final /* synthetic */ ie b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    es(Launcher launcher, String str, ie ieVar) {
        super(str);
        this.f210a = launcher;
        this.b = ieVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        Launcher.d(this.f210a, this.b);
    }
}
