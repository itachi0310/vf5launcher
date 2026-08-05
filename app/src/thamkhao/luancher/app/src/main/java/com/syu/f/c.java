package com.syu.f;

/* JADX INFO: loaded from: classes.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f525a;
    int[] b;
    float[] c;
    String[] d;
    Runnable e = new d(this);
    final /* synthetic */ a f;

    public c(a aVar, int i, int[] iArr, float[] fArr, String[] strArr) {
        this.f = aVar;
        this.f525a = i;
        this.b = iArr;
        this.c = fArr;
        this.d = strArr;
    }

    void a() {
        if (this.f.f523a != null) {
            this.f.f523a.post(this.e);
        }
    }
}
