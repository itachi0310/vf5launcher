package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class jj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ long f330a;
    private final /* synthetic */ ec b;
    private final /* synthetic */ StackTraceElement[] c;

    jj(long j, ec ecVar, StackTraceElement[] stackTraceElementArr) {
        this.f330a = j;
        this.b = ecVar;
        this.c = stackTraceElementArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (iv.c) {
            iv.a(this.f330a, this.b, this.c);
        }
    }
}
