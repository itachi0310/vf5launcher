package com.syu.a;

import com.syu.g.j;

/* JADX INFO: loaded from: classes.dex */
class c implements com.syu.f.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f507a;

    c(a aVar) {
        this.f507a = aVar;
    }

    @Override // com.syu.f.e
    public void a(int i, int[] iArr, float[] fArr, String[] strArr) {
        if (i == 1000 && j.a(iArr, 1)) {
            a.o = iArr[0];
        } else if (i == 1016 && j.a(iArr, 1)) {
            a.i = iArr[0];
        }
    }
}
