package com.android.b.b;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Charset f47a = Charset.forName("US-ASCII");
    private static final short s = c.a(c.C);
    private static final short t = c.a(c.D);
    private static final short u = c.a(c.am);
    private static final short v = c.a(c.E);
    private static final short w = c.a(c.F);
    private static final short x = c.a(c.i);
    private static final short y = c.a(c.m);
    private final a b;
    private final int c;
    private int f;
    private j g;
    private h h;
    private j i;
    private j j;
    private boolean k;
    private boolean l;
    private int m;
    private byte[] o;
    private int p;
    private int q;
    private final c r;
    private int d = 0;
    private int e = 0;
    private int n = 0;
    private final TreeMap z = new TreeMap();

    private e(InputStream inputStream, int i, c cVar) throws IOException, d {
        this.l = false;
        if (inputStream == null) {
            throw new IOException("Null argument inputStream to ExifParser");
        }
        this.r = cVar;
        this.l = a(inputStream);
        this.b = new a(inputStream);
        this.c = i;
        if (this.l) {
            q();
            long jF = this.b.f();
            if (jF > 2147483647L) {
                throw new d("Invalid offset " + jF);
            }
            this.p = (int) jF;
            this.f = 0;
            if (b(0) || o()) {
                a(0, jF);
                if (jF != 8) {
                    this.o = new byte[((int) jF) - 8];
                    a(this.o);
                }
            }
        }
    }

    protected static e a(InputStream inputStream, c cVar) {
        return new e(inputStream, 63, cVar);
    }

    private void a(int i, long j) {
        this.z.put(Integer.valueOf((int) j), new g(i, b(i)));
    }

    private void a(long j) {
        this.z.put(Integer.valueOf((int) j), new h(3));
    }

    private boolean a(int i, int i2) {
        int i3 = this.r.a().get(i2);
        if (i3 == 0) {
            return false;
        }
        return c.d(i3, i);
    }

    private boolean a(InputStream inputStream) throws d {
        a aVar = new a(inputStream);
        if (aVar.c() != -40) {
            throw new d("Invalid JPEG format");
        }
        short sC = aVar.c();
        while (true) {
            short s2 = sC;
            if (s2 == -39 || l.a(s2)) {
                return false;
            }
            int iD = aVar.d();
            if (s2 == -31 && iD >= 8) {
                int iE = aVar.e();
                short sC2 = aVar.c();
                iD -= 6;
                if (iE == 1165519206 && sC2 == 0) {
                    this.q = aVar.a();
                    this.m = iD;
                    this.n = this.q + this.m;
                    return true;
                }
            }
            if (iD < 2 || iD - 2 != aVar.skip(iD - 2)) {
                Log.w("ExifParser", "Invalid JPEG format.");
                return false;
            }
            sC = aVar.c();
        }
    }

    private void b(int i, long j) {
        this.z.put(Integer.valueOf((int) j), new h(4, i));
    }

    private boolean b(int i) {
        switch (i) {
            case 0:
                return (this.c & 1) != 0;
            case 1:
                return (this.c & 2) != 0;
            case 2:
                return (this.c & 4) != 0;
            case 3:
                return (this.c & 16) != 0;
            case 4:
                return (this.c & 8) != 0;
            default:
                return false;
        }
    }

    private void c(int i) {
        this.b.b(i);
        while (!this.z.isEmpty() && ((Integer) this.z.firstKey()).intValue() < i) {
            this.z.pollFirstEntry();
        }
    }

    private void c(j jVar) {
        if (jVar.e() == 0) {
            return;
        }
        short sB = jVar.b();
        int iA = jVar.a();
        if (sB == s && a(iA, c.C)) {
            if (b(2) || b(3)) {
                a(2, jVar.d(0));
                return;
            }
            return;
        }
        if (sB == t && a(iA, c.D)) {
            if (b(4)) {
                a(4, jVar.d(0));
                return;
            }
            return;
        }
        if (sB == u && a(iA, c.am)) {
            if (b(3)) {
                a(3, jVar.d(0));
                return;
            }
            return;
        }
        if (sB == v && a(iA, c.E)) {
            if (n()) {
                a(jVar.d(0));
                return;
            }
            return;
        }
        if (sB == w && a(iA, c.F)) {
            if (n()) {
                this.j = jVar;
                return;
            }
            return;
        }
        if (sB != x || !a(iA, c.i)) {
            if (sB == y && a(iA, c.m) && n() && jVar.f()) {
                this.i = jVar;
                return;
            }
            return;
        }
        if (n()) {
            if (!jVar.f()) {
                this.z.put(Integer.valueOf(jVar.i()), new f(jVar, false));
                return;
            }
            for (int i = 0; i < jVar.e(); i++) {
                if (jVar.c() == 3) {
                    b(i, jVar.d(i));
                } else {
                    b(i, jVar.d(i));
                }
            }
        }
    }

    private boolean n() {
        return (this.c & 32) != 0;
    }

    private boolean o() {
        switch (this.f) {
            case 0:
                return b(2) || b(4) || b(3) || b(1);
            case 1:
                return n();
            case 2:
                return b(3);
            default:
                return false;
        }
    }

    private j p() throws d {
        short sC = this.b.c();
        short sC2 = this.b.c();
        long jF = this.b.f();
        if (jF > 2147483647L) {
            throw new d("Number of component is larger then Integer.MAX_VALUE");
        }
        if (!j.a(sC2)) {
            Log.w("ExifParser", String.format("Tag %04x: Invalid data type %d", Short.valueOf(sC), Short.valueOf(sC2)));
            this.b.skip(4L);
            return null;
        }
        j jVar = new j(sC, sC2, (int) jF, this.f, ((int) jF) != 0);
        int iD = jVar.d();
        if (iD <= 4) {
            boolean zJ = jVar.j();
            jVar.a(false);
            b(jVar);
            jVar.a(zJ);
            this.b.skip(4 - iD);
            jVar.e(this.b.a() - 4);
            return jVar;
        }
        long jF2 = this.b.f();
        if (jF2 > 2147483647L) {
            throw new d("offset is larger then Integer.MAX_VALUE");
        }
        if (jF2 >= this.p || sC2 != 7) {
            jVar.e((int) jF2);
            return jVar;
        }
        byte[] bArr = new byte[(int) jF];
        System.arraycopy(this.o, ((int) jF2) - 8, bArr, 0, (int) jF);
        jVar.a(bArr);
        return jVar;
    }

    private void q() throws d {
        short sC = this.b.c();
        if (18761 == sC) {
            this.b.a(ByteOrder.LITTLE_ENDIAN);
        } else {
            if (19789 != sC) {
                throw new d("Invalid TIFF header");
            }
            this.b.a(ByteOrder.BIG_ENDIAN);
        }
        if (this.b.c() != 42) {
            throw new d("Invalid TIFF header");
        }
    }

    protected int a() {
        if (!this.l) {
            return 5;
        }
        int iA = this.b.a();
        int i = this.d + 2 + (this.e * 12);
        if (iA < i) {
            this.g = p();
            if (this.g == null) {
                return a();
            }
            if (!this.k) {
                return 1;
            }
            c(this.g);
            return 1;
        }
        if (iA == i) {
            if (this.f == 0) {
                long jI = i();
                if ((b(1) || n()) && jI != 0) {
                    a(1, jI);
                }
            } else {
                int iIntValue = this.z.size() > 0 ? ((Integer) this.z.firstEntry().getKey()).intValue() - this.b.a() : 4;
                if (iIntValue < 4) {
                    Log.w("ExifParser", "Invalid size of link to next IFD: " + iIntValue);
                } else {
                    long jI2 = i();
                    if (jI2 != 0) {
                        Log.w("ExifParser", "Invalid link to next IFD: " + jI2);
                    }
                }
            }
        }
        while (this.z.size() != 0) {
            Map.Entry entryPollFirstEntry = this.z.pollFirstEntry();
            Object value = entryPollFirstEntry.getValue();
            try {
                c(((Integer) entryPollFirstEntry.getKey()).intValue());
                if (value instanceof g) {
                    this.f = ((g) value).f49a;
                    this.e = this.b.d();
                    this.d = ((Integer) entryPollFirstEntry.getKey()).intValue();
                    if ((this.e * 12) + this.d + 2 > this.m) {
                        Log.w("ExifParser", "Invalid size of IFD " + this.f);
                        return 5;
                    }
                    this.k = o();
                    if (((g) value).b) {
                        return 0;
                    }
                    b();
                } else {
                    if (value instanceof h) {
                        this.h = (h) value;
                        return this.h.b;
                    }
                    f fVar = (f) value;
                    this.g = fVar.f48a;
                    if (this.g.c() != 7) {
                        b(this.g);
                        c(this.g);
                    }
                    if (fVar.b) {
                        return 2;
                    }
                }
            } catch (IOException e) {
                Log.w("ExifParser", "Failed to skip to data at: " + entryPollFirstEntry.getKey() + " for " + value.getClass().getName() + ", the file may be broken.");
            }
        }
        return 5;
    }

    protected int a(byte[] bArr) {
        return this.b.read(bArr);
    }

    protected String a(int i) {
        return a(i, f47a);
    }

    protected String a(int i, Charset charset) {
        return i > 0 ? this.b.a(i, charset) : "";
    }

    protected void a(j jVar) {
        if (jVar.i() >= this.b.a()) {
            this.z.put(Integer.valueOf(jVar.i()), new f(jVar, true));
        }
    }

    protected void b() {
        int i = (this.e * 12) + this.d + 2;
        int iA = this.b.a();
        if (iA > i) {
            return;
        }
        if (this.k) {
            while (iA < i) {
                this.g = p();
                iA += 12;
                if (this.g != null) {
                    c(this.g);
                }
            }
        } else {
            c(i);
        }
        long jI = i();
        if (this.f == 0) {
            if ((b(1) || n()) && jI > 0) {
                a(1, jI);
            }
        }
    }

    protected void b(j jVar) {
        int i = 0;
        short sC = jVar.c();
        if (sC == 2 || sC == 7 || sC == 1) {
            int iE = jVar.e();
            if (this.z.size() > 0 && ((Integer) this.z.firstEntry().getKey()).intValue() < iE + this.b.a()) {
                Object value = this.z.firstEntry().getValue();
                if (value instanceof h) {
                    Log.w("ExifParser", "Thumbnail overlaps value for tag: \n" + jVar.toString());
                    Log.w("ExifParser", "Invalid thumbnail offset: " + this.z.pollFirstEntry().getKey());
                } else {
                    if (value instanceof g) {
                        Log.w("ExifParser", "Ifd " + ((g) value).f49a + " overlaps value for tag: \n" + jVar.toString());
                    } else if (value instanceof f) {
                        Log.w("ExifParser", "Tag value for tag: \n" + ((f) value).f48a.toString() + " overlaps value for tag: \n" + jVar.toString());
                    }
                    int iIntValue = ((Integer) this.z.firstEntry().getKey()).intValue() - this.b.a();
                    Log.w("ExifParser", "Invalid size of tag: \n" + jVar.toString() + " setting count to: " + iIntValue);
                    jVar.c(iIntValue);
                }
            }
        }
        switch (jVar.c()) {
            case 1:
            case 7:
                byte[] bArr = new byte[jVar.e()];
                a(bArr);
                jVar.a(bArr);
                break;
            case 2:
                jVar.a(a(jVar.e()));
                break;
            case 3:
                int[] iArr = new int[jVar.e()];
                int length = iArr.length;
                while (i < length) {
                    iArr[i] = h();
                    i++;
                }
                jVar.a(iArr);
                break;
            case 4:
                long[] jArr = new long[jVar.e()];
                int length2 = jArr.length;
                while (i < length2) {
                    jArr[i] = i();
                    i++;
                }
                jVar.a(jArr);
                break;
            case 5:
                m[] mVarArr = new m[jVar.e()];
                int length3 = mVarArr.length;
                while (i < length3) {
                    mVarArr[i] = j();
                    i++;
                }
                jVar.a(mVarArr);
                break;
            case 9:
                int[] iArr2 = new int[jVar.e()];
                int length4 = iArr2.length;
                while (i < length4) {
                    iArr2[i] = k();
                    i++;
                }
                jVar.a(iArr2);
                break;
            case 10:
                m[] mVarArr2 = new m[jVar.e()];
                int length5 = mVarArr2.length;
                for (int i2 = 0; i2 < length5; i2++) {
                    mVarArr2[i2] = l();
                }
                jVar.a(mVarArr2);
                break;
        }
    }

    protected j c() {
        return this.g;
    }

    protected int d() {
        return this.f;
    }

    protected int e() {
        return this.h.f50a;
    }

    protected int f() {
        if (this.i == null) {
            return 0;
        }
        return (int) this.i.d(0);
    }

    protected int g() {
        if (this.j == null) {
            return 0;
        }
        return (int) this.j.d(0);
    }

    protected int h() {
        return this.b.c() & 65535;
    }

    protected long i() {
        return ((long) k()) & 4294967295L;
    }

    protected m j() {
        return new m(i(), i());
    }

    protected int k() {
        return this.b.e();
    }

    protected m l() {
        return new m(k(), k());
    }

    protected ByteOrder m() {
        return this.b.b();
    }
}
