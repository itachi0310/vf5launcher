package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class gl extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f257a;
    private final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    gl(Launcher launcher, String str, int i) {
        super(str);
        this.f257a = launcher;
        this.b = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f257a.br.deleteAppWidgetId(this.b);
    }
}
