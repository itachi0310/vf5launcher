package com.syu.g;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static int a(byte[] bArr, byte[] bArr2, int i) {
        int length = bArr.length;
        if (i <= bArr2.length) {
            for (int i2 = 0; i2 < (i - length) + 1; i2++) {
                for (int i3 = 0; i3 < length && bArr2[i2 + i3] == bArr[i3]; i3++) {
                    if (i3 == length - 1) {
                        return i2;
                    }
                }
            }
        }
        return -1;
    }

    public static byte[] a(int i, int i2, byte[] bArr) {
        int i3;
        byte[] bArr2 = null;
        if (i >= 0 && i2 <= bArr.length && (i3 = i2 - i) > 0) {
            bArr2 = new byte[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                bArr2[i4] = bArr[i + i4];
            }
        }
        return bArr2;
    }

    public static int b(byte[] bArr, byte[] bArr2, int i) {
        if (i <= bArr2.length) {
            int length = bArr.length;
            for (int i2 = i - length; i2 >= 0; i2--) {
                for (int i3 = 0; i3 < length && bArr2[i2 + i3] == bArr[i3]; i3++) {
                    if (i3 == length - 1) {
                        return i2;
                    }
                }
            }
        }
        return -1;
    }
}
