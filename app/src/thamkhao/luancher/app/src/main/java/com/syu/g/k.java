package com.syu.g;

import android.text.TextUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f539a = new ArrayList();
    public List b = new ArrayList();

    public int a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    public h a(String str) throws Throwable {
        h hVar = new h();
        if (!TextUtils.isEmpty(str) && str.toLowerCase().endsWith(".mp3")) {
            if (!c(str, hVar) && !d(str, hVar)) {
                b(str, hVar);
            }
            a(str, hVar);
        }
        return hVar;
    }

    String a(int i) {
        switch (i) {
            case 1:
                return "UTF-16LE";
            case 2:
                return "UTF-16BE";
            case 3:
                return HTTP.UTF_8;
            default:
                return f.a(Locale.getDefault());
        }
    }

    String a(RandomAccessFile randomAccessFile, int i, int[] iArr, int i2, boolean z) throws IOException {
        int i3;
        int i4;
        iArr[0] = 0;
        if (i <= 0 || i >= 1024) {
            return null;
        }
        long filePointer = randomAccessFile.getFilePointer();
        if (!z || i < 3) {
            i3 = i;
        } else {
            byte[] bArr = new byte[3];
            randomAccessFile.read(bArr, 0, 3);
            int[] iArr2 = new int[3];
            for (int i5 = 0; i5 < 3; i5++) {
                iArr2[i5] = bArr[i5] & 255;
            }
            if (iArr2[0] == 255 && iArr2[1] == 254) {
                i2 = 1;
                randomAccessFile.seek(randomAccessFile.getFilePointer() - 1);
                i3 = i - 2;
            } else if (iArr2[0] == 254 && iArr2[1] == 255) {
                i2 = 2;
                randomAccessFile.seek(randomAccessFile.getFilePointer() - 1);
                i3 = i - 2;
            } else if (iArr2[0] == 239 && iArr2[1] == 187 && iArr2[2] == 191) {
                i2 = 3;
                i3 = i - 3;
            } else {
                randomAccessFile.seek(randomAccessFile.getFilePointer() - 3);
                i3 = i;
            }
        }
        boolean z2 = i2 == 1 || i2 == 2;
        byte[] bArr2 = new byte[1];
        byte[] bArr3 = new byte[i3 + 2];
        Arrays.fill(bArr3, (byte) 0);
        int i6 = i3;
        while (i6 > 0) {
            randomAccessFile.read(bArr2, 0, 1);
            bArr3[iArr[0]] = bArr2[0];
            iArr[0] = iArr[0] + 1;
            i6--;
            if (i6 > 0 && bArr2[0] == 0) {
                if (!z2) {
                    break;
                }
                randomAccessFile.read(bArr2, 0, 1);
                bArr3[iArr[0]] = bArr2[0];
                iArr[0] = iArr[0] + 1;
                i6--;
                if (bArr2[0] == 0) {
                    if ((iArr[0] & 1) != 0) {
                        randomAccessFile.read(bArr3, iArr[0], 1);
                        i4 = i6;
                    }
                    iArr[0] = (int) (randomAccessFile.getFilePointer() - filePointer);
                    randomAccessFile.seek(((long) i4) + randomAccessFile.getFilePointer());
                    return a(bArr3, i3 + 2, i2);
                }
            }
        }
        i4 = i6;
        iArr[0] = (int) (randomAccessFile.getFilePointer() - filePointer);
        randomAccessFile.seek(((long) i4) + randomAccessFile.getFilePointer());
        return a(bArr3, i3 + 2, i2);
    }

    String a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, a(i2));
        } catch (Exception e) {
            return "";
        }
    }

    public void a(RandomAccessFile randomAccessFile, int i, int i2, h hVar) throws IOException {
        boolean[] zArr = new boolean[3];
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2 || i <= 10) {
                return;
            }
            randomAccessFile.read(bArr, 0, 4);
            randomAccessFile.read(bArr2, 0, 4);
            int[] iArr = new int[1];
            int iB = (i - 8) - b(bArr, 0);
            String strA = a(randomAccessFile, iB, iArr, 3, true);
            if (strA != null) {
                randomAccessFile.seek(randomAccessFile.getFilePointer() - ((long) (iB - iArr[0])));
                if (strA.startsWith("Artist")) {
                    zArr[0] = true;
                    hVar.b = a(randomAccessFile, b(bArr, 0), new int[1], 3, true);
                    if (!TextUtils.isEmpty(hVar.b)) {
                        hVar.b = hVar.b.trim();
                    }
                } else if (strA.startsWith("Album")) {
                    zArr[1] = true;
                    hVar.c = a(randomAccessFile, b(bArr, 0), new int[1], 3, true);
                    if (!TextUtils.isEmpty(hVar.c)) {
                        hVar.c = hVar.c.trim();
                    }
                } else if (strA.startsWith("Title")) {
                    zArr[2] = true;
                    hVar.f537a = a(randomAccessFile, b(bArr, 0), new int[1], 3, true);
                    if (!TextUtils.isEmpty(hVar.f537a)) {
                        hVar.f537a = hVar.f537a.trim();
                    }
                } else {
                    a(randomAccessFile, b(bArr, 0), new int[1], 3, true);
                }
            }
            if (zArr[0] && zArr[1] && zArr[2]) {
                return;
            }
            i = iB - iArr[0];
            i3 = i4 + 1;
        }
    }

    void a(RandomAccessFile randomAccessFile, int i, h hVar) throws IOException {
        int iA;
        boolean z = false;
        byte[] bArr = new byte[1];
        byte[] bArr2 = new byte[10];
        while (i > 10) {
            randomAccessFile.read(bArr, 0, 1);
            if (bArr[0] == 0) {
                i--;
            } else {
                randomAccessFile.read(bArr, 0, 1);
                if (bArr[0] == 0) {
                    i--;
                } else {
                    randomAccessFile.seek(randomAccessFile.getFilePointer() - 2);
                    if (randomAccessFile.read(bArr2, 0, 10) != 10 || !a(bArr2) || (iA = a(bArr2, 4)) < 0 || iA > i) {
                        return;
                    }
                    new byte[1][0] = 0;
                    long filePointer = randomAccessFile.getFilePointer() + ((long) iA);
                    if (bArr2[0] == 65 && bArr2[1] == 80 && bArr2[2] == 73 && bArr2[3] == 67) {
                        z = true;
                        if (iA > 13) {
                            randomAccessFile.seek(randomAccessFile.getFilePointer() + 13);
                            int i2 = iA - 13;
                            byte[] bArr3 = new byte[i2];
                            if (bArr3 != null) {
                                randomAccessFile.read(bArr3, 0, i2);
                                hVar.d = c.a(c.a(new byte[]{-1, -40}, bArr3, bArr3.length), c.b(new byte[]{-1, -39}, bArr3, bArr3.length) + 2, bArr3);
                            }
                        }
                    }
                    if (z) {
                        return;
                    }
                    randomAccessFile.seek(filePointer);
                    i -= iA + 10;
                }
            }
        }
    }

    void a(RandomAccessFile randomAccessFile, h hVar) throws IOException {
        long length = randomAccessFile.length();
        byte[] bArr = new byte[10];
        randomAccessFile.read(bArr, 0, 10);
        if (bArr[0] == 73 && bArr[1] == 68 && bArr[2] == 51 && bArr[4] != 2) {
            a(randomAccessFile, (int) (length - randomAccessFile.getFilePointer()), hVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    void a(String str, h hVar) throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    a(randomAccessFile, hVar);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    boolean a(byte[] bArr) {
        for (int i = 0; i < 4; i++) {
            if ((bArr[i] < 65 || bArr[i] > 90) && (bArr[i] < 48 || bArr[i] > 57)) {
                return false;
            }
        }
        return true;
    }

    public int b(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) + ((bArr[i + 2] & 255) << 16) + ((bArr[i + 1] & 255) << 8) + (bArr[i] & 255);
    }

    void b(RandomAccessFile randomAccessFile, int i, h hVar) throws IOException {
        int i2;
        boolean[] zArr = new boolean[3];
        byte[] bArr = new byte[1];
        byte[] bArr2 = new byte[6];
        while (i > 6) {
            randomAccessFile.read(bArr, 0, 1);
            if (bArr[0] == 0) {
                i--;
            } else {
                randomAccessFile.seek(randomAccessFile.getFilePointer() - 1);
                if (randomAccessFile.read(bArr2, 0, 6) != 6 || !b(bArr2) || (i2 = ((bArr2[3] & 255) << 16) + ((bArr2[4] & 255) << 8) + (bArr2[5] & 255)) < 0 || i2 > i || i2 == 0 || i2 > 100) {
                    return;
                }
                byte[] bArr3 = {0};
                int[] iArr = new int[1];
                long filePointer = ((long) i2) + randomAccessFile.getFilePointer();
                if (bArr2[0] == 84 && bArr2[1] == 80 && bArr2[2] == 49) {
                    randomAccessFile.read(bArr3, 0, 1);
                    zArr[0] = true;
                    hVar.b = a(randomAccessFile, i2 - 1, iArr, bArr3[0], true);
                    if (!TextUtils.isEmpty(hVar.b)) {
                        hVar.b = hVar.b.trim();
                    }
                } else if (bArr2[0] == 84 && bArr2[1] == 65 && bArr2[2] == 76) {
                    randomAccessFile.read(bArr3, 0, 1);
                    zArr[1] = true;
                    hVar.c = a(randomAccessFile, i2 - 1, iArr, bArr3[0], true);
                    if (!TextUtils.isEmpty(hVar.c)) {
                        hVar.c = hVar.c.trim();
                    }
                } else if (bArr2[0] == 84 && bArr2[1] == 84 && bArr2[2] == 50) {
                    randomAccessFile.read(bArr3, 0, 1);
                    zArr[2] = true;
                    hVar.f537a = a(randomAccessFile, i2 - 1, iArr, bArr3[0], true);
                    if (!TextUtils.isEmpty(hVar.f537a)) {
                        hVar.f537a = hVar.f537a.trim();
                    }
                }
                if (zArr[0] && zArr[1] && zArr[2]) {
                    return;
                }
                randomAccessFile.seek(filePointer);
                i -= i2 + 6;
            }
        }
    }

    boolean b(RandomAccessFile randomAccessFile, h hVar) throws IOException {
        long length = randomAccessFile.length();
        if (length <= 128) {
            return false;
        }
        randomAccessFile.seek(length - 128);
        byte[] bArr = new byte[3];
        randomAccessFile.read(bArr, 0, 3);
        if (bArr[0] != 84 || bArr[1] != 65 || bArr[2] != 71) {
            return false;
        }
        byte[] bArr2 = new byte[30];
        byte[] bArr3 = new byte[30];
        byte[] bArr4 = new byte[30];
        randomAccessFile.read(bArr2, 0, 30);
        randomAccessFile.read(bArr3, 0, 30);
        randomAccessFile.read(bArr4, 0, 30);
        bArr2[29] = 0;
        bArr3[29] = 0;
        bArr4[29] = 0;
        for (int i = 29; i >= 0 && bArr3[i] == 32; i--) {
            bArr3[i] = 0;
        }
        if (bArr3[0] == 0) {
            return false;
        }
        hVar.f537a = a(bArr2, 30, 0);
        if (!TextUtils.isEmpty(hVar.f537a)) {
            hVar.f537a = hVar.f537a.trim();
        }
        hVar.b = a(bArr3, 30, 0);
        if (!TextUtils.isEmpty(hVar.b)) {
            hVar.b = hVar.b.trim();
        }
        hVar.c = a(bArr4, 30, 0);
        if (!TextUtils.isEmpty(hVar.c)) {
            hVar.c = hVar.c.trim();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    boolean b(String str, h hVar) throws Throwable {
        RandomAccessFile randomAccessFile;
        boolean zB = false;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    zB = b(randomAccessFile, hVar);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            return zB;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    boolean b(byte[] bArr) {
        for (int i = 0; i < 3; i++) {
            if ((bArr[i] < 65 || bArr[i] > 90) && (bArr[i] < 48 || bArr[i] > 57)) {
                return false;
            }
        }
        return true;
    }

    void c(RandomAccessFile randomAccessFile, int i, h hVar) throws IOException {
        int iA;
        boolean[] zArr = new boolean[3];
        byte[] bArr = new byte[1];
        byte[] bArr2 = new byte[10];
        while (i > 10) {
            randomAccessFile.read(bArr, 0, 1);
            if (bArr[0] == 0) {
                i--;
            } else {
                randomAccessFile.read(bArr, 0, 1);
                if (bArr[0] == 0) {
                    i--;
                } else {
                    randomAccessFile.seek(randomAccessFile.getFilePointer() - 2);
                    if (randomAccessFile.read(bArr2, 0, 10) != 10 || !a(bArr2) || (iA = a(bArr2, 4)) < 0 || iA > i) {
                        return;
                    }
                    byte[] bArr3 = {0};
                    int[] iArr = new int[1];
                    long filePointer = ((long) iA) + randomAccessFile.getFilePointer();
                    if (bArr2[0] == 84 && bArr2[1] == 80 && bArr2[2] == 69 && bArr2[3] == 49) {
                        zArr[0] = true;
                        randomAccessFile.read(bArr3, 0, 1);
                        hVar.b = a(randomAccessFile, iA - 1, iArr, bArr3[0], true);
                        if (!TextUtils.isEmpty(hVar.b)) {
                            hVar.b = hVar.b.trim();
                        }
                    } else if (bArr2[0] == 84 && bArr2[1] == 65 && bArr2[2] == 76 && bArr2[3] == 66) {
                        zArr[1] = true;
                        randomAccessFile.read(bArr3, 0, 1);
                        hVar.c = a(randomAccessFile, iA - 1, iArr, bArr3[0], true);
                        if (!TextUtils.isEmpty(hVar.c)) {
                            hVar.c = hVar.c.trim();
                        }
                    } else if (bArr2[0] == 84 && bArr2[1] == 73 && bArr2[2] == 84 && bArr2[3] == 50) {
                        zArr[2] = true;
                        randomAccessFile.read(bArr3, 0, 1);
                        hVar.f537a = a(randomAccessFile, iA - 1, iArr, bArr3[0], true);
                        if (!TextUtils.isEmpty(hVar.f537a)) {
                            hVar.f537a = hVar.f537a.trim();
                        }
                    }
                    if (zArr[0] && zArr[1] && zArr[2]) {
                        return;
                    }
                    randomAccessFile.seek(filePointer);
                    i -= iA + 10;
                }
            }
        }
    }

    boolean c(RandomAccessFile randomAccessFile, h hVar) throws IOException {
        if (randomAccessFile.length() < 128) {
            return false;
        }
        byte[] bArr = new byte[3];
        randomAccessFile.seek(randomAccessFile.length() - 128);
        randomAccessFile.read(bArr, 0, 3);
        int i = bArr[0] == 84 && bArr[1] == 65 && bArr[2] == 71 ? 160 : 32;
        randomAccessFile.seek(randomAccessFile.length() - ((long) i));
        byte[] bArr2 = new byte[32];
        randomAccessFile.read(bArr2, 0, 32);
        if (bArr2[0] != 65 || bArr2[1] != 80 || bArr2[2] != 69 || bArr2[3] != 84 || bArr2[4] != 65 || bArr2[5] != 71 || bArr2[6] != 69 || bArr2[7] != 88) {
            return false;
        }
        int iB = b(bArr2, 12) - 32;
        randomAccessFile.seek(randomAccessFile.length() - ((long) (i + iB)));
        a(randomAccessFile, iB, b(bArr2, 16), hVar);
        return !TextUtils.isEmpty(hVar.b);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public boolean c(String str, h hVar) throws Throwable {
        RandomAccessFile randomAccessFile;
        boolean zC = false;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    zC = c(randomAccessFile, hVar);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            return zC;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    boolean d(RandomAccessFile randomAccessFile, h hVar) throws IOException {
        long length = randomAccessFile.length();
        byte[] bArr = new byte[10];
        randomAccessFile.read(bArr, 0, 10);
        if (bArr[0] != 73 || bArr[1] != 68 || bArr[2] != 51) {
            return false;
        }
        if (bArr[4] == 2) {
            b(randomAccessFile, (int) (length - randomAccessFile.getFilePointer()), hVar);
        } else {
            c(randomAccessFile, (int) (length - randomAccessFile.getFilePointer()), hVar);
        }
        return !TextUtils.isEmpty(hVar.b);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    boolean d(String str, h hVar) throws Throwable {
        RandomAccessFile randomAccessFile;
        boolean zD = false;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    zD = d(randomAccessFile, hVar);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            return zD;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }
}
