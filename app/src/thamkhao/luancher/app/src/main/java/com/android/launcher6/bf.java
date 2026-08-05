package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class bf extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DeleteDropTarget f129a;
    private final /* synthetic */ ir b;
    private final /* synthetic */ it c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bf(DeleteDropTarget deleteDropTarget, String str, ir irVar, it itVar) {
        super(str);
        this.f129a = deleteDropTarget;
        this.b = irVar;
        this.c = itVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.b.deleteAppWidgetId(this.c.f314a);
    }
}
