package com.android.b.b;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Charset f52a = Charset.forName("US-ASCII");
    private static final int[] b = new int[11];
    private static final SimpleDateFormat j;
    private final short c;
    private final short d;
    private boolean e;
    private int f;
    private int g;
    private Object h = null;
    private int i;

    static {
        b[1] = 1;
        b[2] = 1;
        b[3] = 2;
        b[4] = 4;
        b[5] = 8;
        b[7] = 1;
        b[9] = 4;
        b[10] = 8;
        j = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
    }

    j(short s, short s2, int i, int i2, boolean z) {
        this.c = s;
        this.d = s2;
        this.f = i;
        this.e = z;
        this.g = i2;
    }

    public static boolean a(int i) {
        return i == 0 || i == 1 || i == 2 || i == 3 || i == 4;
    }

    public static boolean a(short s) {
        return s == 1 || s == 2 || s == 3 || s == 4 || s == 5 || s == 7 || s == 9 || s == 10;
    }

    public static int b(short s) {
        return b[s];
    }

    private boolean b(int[] iArr) {
        for (int i : iArr) {
            if (i > 65535 || i < 0) {
                return true;
            }
        }
        return false;
    }

    private boolean b(long[] jArr) {
        for (long j2 : jArr) {
            if (j2 < 0 || j2 > 4294967295L) {
                return true;
            }
        }
        return false;
    }

    private boolean b(m[] mVarArr) {
        for (m mVar : mVarArr) {
            if (mVar.a() < 0 || mVar.b() < 0 || mVar.a() > 4294967295L || mVar.b() > 4294967295L) {
                return true;
            }
        }
        return false;
    }

    private static String c(short s) {
        switch (s) {
            case 1:
                return "UNSIGNED_BYTE";
            case 2:
                return HTTP.ASCII;
            case 3:
                return "UNSIGNED_SHORT";
            case 4:
                return "UNSIGNED_LONG";
            case 5:
                return "UNSIGNED_RATIONAL";
            case 6:
            case 8:
            default:
                return "";
            case 7:
                return "UNDEFINED";
            case 9:
                return "LONG";
            case 10:
                return "RATIONAL";
        }
    }

    private boolean c(int[] iArr) {
        for (int i : iArr) {
            if (i < 0) {
                return true;
            }
        }
        return false;
    }

    private boolean c(m[] mVarArr) {
        for (m mVar : mVarArr) {
            if (mVar.a() < -2147483648L || mVar.b() < -2147483648L || mVar.a() > 2147483647L || mVar.b() > 2147483647L) {
                return true;
            }
        }
        return false;
    }

    private boolean f(int i) {
        return this.e && this.f != i;
    }

    public int a() {
        return this.g;
    }

    protected void a(boolean z) {
        this.e = z;
    }

    public boolean a(String str) {
        if (this.d != 2 && this.d != 7) {
            return false;
        }
        byte[] bytes = str.getBytes(f52a);
        if (bytes.length > 0) {
            if (bytes[bytes.length - 1] != 0 && this.d != 7) {
                bytes = Arrays.copyOf(bytes, bytes.length + 1);
            }
        } else if (this.d == 2 && this.f == 1) {
            bytes = new byte[1];
        }
        int length = bytes.length;
        if (f(length)) {
            return false;
        }
        this.f = length;
        this.h = bytes;
        return true;
    }

    public boolean a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public boolean a(byte[] bArr, int i, int i2) {
        if (f(i2)) {
            return false;
        }
        if (this.d != 1 && this.d != 7) {
            return false;
        }
        this.h = new byte[i2];
        System.arraycopy(bArr, i, this.h, 0, i2);
        this.f = i2;
        return true;
    }

    public boolean a(int[] iArr) {
        if (f(iArr.length)) {
            return false;
        }
        if (this.d != 3 && this.d != 9 && this.d != 4) {
            return false;
        }
        if (this.d == 3 && b(iArr)) {
            return false;
        }
        if (this.d == 4 && c(iArr)) {
            return false;
        }
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        this.h = jArr;
        this.f = iArr.length;
        return true;
    }

    public boolean a(long[] jArr) {
        if (f(jArr.length) || this.d != 4 || b(jArr)) {
            return false;
        }
        this.h = jArr;
        this.f = jArr.length;
        return true;
    }

    public boolean a(m[] mVarArr) {
        if (f(mVarArr.length)) {
            return false;
        }
        if (this.d != 5 && this.d != 10) {
            return false;
        }
        if (this.d == 5 && b(mVarArr)) {
            return false;
        }
        if (this.d == 10 && c(mVarArr)) {
            return false;
        }
        this.h = mVarArr;
        this.f = mVarArr.length;
        return true;
    }

    public short b() {
        return this.c;
    }

    protected void b(int i) {
        this.g = i;
    }

    public short c() {
        return this.d;
    }

    protected void c(int i) {
        this.f = i;
    }

    public int d() {
        return e() * b(c());
    }

    protected long d(int i) {
        if (this.h instanceof long[]) {
            return ((long[]) this.h)[i];
        }
        if (this.h instanceof byte[]) {
            return ((byte[]) this.h)[i];
        }
        throw new IllegalArgumentException("Cannot get integer value from " + c(this.d));
    }

    public int e() {
        return this.f;
    }

    protected void e(int i) {
        this.i = i;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (jVar.c != this.c || jVar.f != this.f || jVar.d != this.d) {
            return false;
        }
        if (this.h == null) {
            return jVar.h == null;
        }
        if (jVar.h == null) {
            return false;
        }
        if (this.h instanceof long[]) {
            if (jVar.h instanceof long[]) {
                return Arrays.equals((long[]) this.h, (long[]) jVar.h);
            }
            return false;
        }
        if (this.h instanceof m[]) {
            if (jVar.h instanceof m[]) {
                return Arrays.equals((m[]) this.h, (m[]) jVar.h);
            }
            return false;
        }
        if (!(this.h instanceof byte[])) {
            return this.h.equals(jVar.h);
        }
        if (jVar.h instanceof byte[]) {
            return Arrays.equals((byte[]) this.h, (byte[]) jVar.h);
        }
        return false;
    }

    public boolean f() {
        return this.h != null;
    }

    public int[] g() {
        if (this.h == null || !(this.h instanceof long[])) {
            return null;
        }
        long[] jArr = (long[]) this.h;
        int[] iArr = new int[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            iArr[i] = (int) jArr[i];
        }
        return iArr;
    }

    public String h() {
        if (this.h == null) {
            return "";
        }
        if (this.h instanceof byte[]) {
            return this.d == 2 ? new String((byte[]) this.h, f52a) : Arrays.toString((byte[]) this.h);
        }
        if (this.h instanceof long[]) {
            return ((long[]) this.h).length == 1 ? String.valueOf(((long[]) this.h)[0]) : Arrays.toString((long[]) this.h);
        }
        if (!(this.h instanceof Object[])) {
            return this.h.toString();
        }
        if (((Object[]) this.h).length != 1) {
            return Arrays.toString((Object[]) this.h);
        }
        Object obj = ((Object[]) this.h)[0];
        return obj == null ? "" : obj.toString();
    }

    protected int i() {
        return this.i;
    }

    protected boolean j() {
        return this.e;
    }

    public String toString() {
        return String.valueOf(String.format("tag id: %04X\n", Short.valueOf(this.c))) + "ifd id: " + this.g + "\ntype: " + c(this.d) + "\ncount: " + this.f + "\noffset: " + this.i + "\nvalue: " + h() + "\n";
    }
}
