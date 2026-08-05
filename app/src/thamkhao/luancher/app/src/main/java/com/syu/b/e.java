package com.syu.b;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static d a(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        dataInputStream.skipBytes(20);
        int i2 = dataInputStream.readInt();
        byte[] bArr = new byte[4];
        dataInputStream.read(bArr, 0, 4);
        int iD = d(bArr, 0);
        dataInputStream.read(bArr, 0, 4);
        int iD2 = d(bArr, 0);
        byte[] bArr2 = new byte[8];
        dataInputStream.read(bArr2, 0, 8);
        double dE = e(bArr2, 0);
        dataInputStream.read(bArr2, 0, 8);
        double dE2 = e(bArr2, 0);
        dataInputStream.read(bArr2, 0, 8);
        double dE3 = e(bArr2, 0);
        dataInputStream.read(bArr2, 0, 8);
        double dE4 = e(bArr2, 0);
        dataInputStream.skip(32L);
        ArrayList arrayList = new ArrayList(1024);
        while (dataInputStream.available() > 0) {
            int i3 = dataInputStream.readInt();
            int i4 = dataInputStream.readInt();
            arrayList.add(Integer.valueOf(i3));
            arrayList.add(Integer.valueOf(i4));
        }
        int[] iArr = new int[arrayList.size()];
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= arrayList.size()) {
                return new d(i, i2, iD, iD2, dE, dE2, dE3, dE4, iArr);
            }
            iArr[i6] = ((Integer) arrayList.get(i6)).intValue();
            i5 = i6 + 1;
        }
    }

    public static Object a(byte[] bArr, int i) {
        int i2 = i << 1;
        switch (d(bArr, i2 + 8)) {
            case 1:
            case 2:
            case 3:
            case 4:
            default:
                return null;
            case 5:
                return b(bArr, i2);
        }
    }

    public static a b(byte[] bArr, int i) {
        int iC = c(bArr, i);
        int i2 = i + 12;
        double dE = e(bArr, i2);
        double dE2 = e(bArr, i2 + 8);
        double dE3 = e(bArr, i2 + 16);
        double dE4 = e(bArr, i2 + 24);
        int iD = d(bArr, i2 + 32);
        int iD2 = d(bArr, i2 + 36);
        int i3 = i2 + 40;
        int[] iArr = new int[iD];
        for (int i4 = 0; i4 < iD; i4++) {
            iArr[i4] = d(bArr, (i4 * 4) + i3);
        }
        int i5 = i3 + (iD * 4);
        double[][] dArr = new double[iD][];
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= iD) {
                return new a(iC, dE, dE2, dE3, dE4, dArr);
            }
            int i8 = iD == 1 ? iD2 : (i7 == iD + (-1) ? iD2 : iArr[i7 + 1]) - iArr[i7];
            dArr[i7] = new double[i8 << 1];
            for (int i9 = 0; i9 < i8; i9++) {
                dArr[i7][i9 << 1] = e(bArr, i5);
                dArr[i7][(i9 << 1) + 1] = e(bArr, i5 + 8);
                i5 += 16;
            }
            i6 = i7 + 1;
        }
    }

    public static int c(byte[] bArr, int i) {
        return (bArr[i + 0] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
    }

    public static int d(byte[] bArr, int i) {
        return (bArr[i + 3] << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | (bArr[i + 0] & 255);
    }

    public static double e(byte[] bArr, int i) {
        return Double.longBitsToDouble((((long) bArr[i + 7]) << 56) | (((long) (bArr[i + 6] & 255)) << 48) | (((long) (bArr[i + 5] & 255)) << 40) | (((long) (bArr[i + 4] & 255)) << 32) | (((long) (bArr[i + 3] & 255)) << 24) | (((long) (bArr[i + 2] & 255)) << 16) | (((long) (bArr[i + 1] & 255)) << 8) | ((long) (bArr[i + 0] & 255)));
    }
}
