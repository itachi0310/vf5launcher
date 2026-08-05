package com.syu.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f511a = new ArrayList();

    public c(byte[] bArr, d dVar) {
        int[] iArrA;
        if (bArr == null || dVar == null || (iArrA = dVar.a()) == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= iArrA.length / 2) {
                return;
            }
            Object objA = e.a(bArr, iArrA[i2 << 1]);
            if (objA instanceof a) {
                this.f511a.add((a) objA);
            }
            i = i2 + 1;
        }
    }
}
