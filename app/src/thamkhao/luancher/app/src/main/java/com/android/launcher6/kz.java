package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class kz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MemoryDumpActivity f365a;

    kz(MemoryDumpActivity memoryDumpActivity) {
        this.f365a = memoryDumpActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f365a.finish();
    }
}
