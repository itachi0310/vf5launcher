package com.syu.a;

import com.syu.g.j;

/* JADX INFO: loaded from: classes.dex */
class b implements com.syu.f.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f506a;

    b(a aVar) {
        this.f506a = aVar;
    }

    @Override // com.syu.f.e
    public void a(int i, int[] iArr, float[] fArr, String[] strArr) {
        if (i == 0 && j.a(iArr, 1)) {
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            a.g = iArr[0];
            return;
        }
        if (i != 50 || iArr == null || iArr.length <= 0) {
            return;
        }
        a.h = iArr[0];
    }
}
