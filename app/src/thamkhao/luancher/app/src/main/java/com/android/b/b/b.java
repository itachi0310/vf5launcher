package com.android.b.b;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f45a = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final byte[] b;
    private static final byte[] c;
    private byte[] e;
    private final ByteOrder g;
    private final k[] d = new k[5];
    private ArrayList f = new ArrayList();

    static {
        byte[] bArr = new byte[8];
        bArr[0] = 74;
        bArr[1] = 73;
        bArr[2] = 83;
        b = bArr;
        c = new byte[]{85, 78, 73, 67, 79, 68, 69, 0};
    }

    b(ByteOrder byteOrder) {
        this.g = byteOrder;
    }

    protected j a(short s, int i) {
        k kVar = this.d[i];
        if (kVar == null) {
            return null;
        }
        return kVar.a(s);
    }

    protected k a(int i) {
        if (j.a(i)) {
            return this.d[i];
        }
        return null;
    }

    protected void a(int i, byte[] bArr) {
        if (i < this.f.size()) {
            this.f.set(i, bArr);
            return;
        }
        for (int size = this.f.size(); size < i; size++) {
            this.f.add(null);
        }
        this.f.add(bArr);
    }

    protected void a(k kVar) {
        this.d[kVar.c()] = kVar;
    }

    protected void a(byte[] bArr) {
        this.e = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (bVar.g != this.g || bVar.f.size() != this.f.size() || !Arrays.equals(bVar.e, this.e)) {
            return false;
        }
        for (int i = 0; i < this.f.size(); i++) {
            if (!Arrays.equals((byte[]) bVar.f.get(i), (byte[]) this.f.get(i))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < 5; i2++) {
            k kVarA = bVar.a(i2);
            k kVarA2 = a(i2);
            if (kVarA != kVarA2 && kVarA != null && !kVarA.equals(kVarA2)) {
                return false;
            }
        }
        return true;
    }
}
