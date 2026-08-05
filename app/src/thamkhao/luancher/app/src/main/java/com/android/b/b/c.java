package com.android.b.b;

import android.util.SparseIntArray;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class c {
    protected static HashSet br;
    public static final ByteOrder bs;
    private b bu = new b(bs);
    private final DateFormat bv = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
    private final DateFormat bw = new SimpleDateFormat("yyyy:MM:dd");
    private final Calendar bx = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    private SparseIntArray by = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46a = a(0, (short) 256);
    public static final int b = a(0, (short) 257);
    public static final int c = a(0, (short) 258);
    public static final int d = a(0, (short) 259);
    public static final int e = a(0, (short) 262);
    public static final int f = a(0, (short) 270);
    public static final int g = a(0, (short) 271);
    public static final int h = a(0, (short) 272);
    public static final int i = a(0, (short) 273);
    public static final int j = a(0, (short) 274);
    public static final int k = a(0, (short) 277);
    public static final int l = a(0, (short) 278);
    public static final int m = a(0, (short) 279);
    public static final int n = a(0, (short) 282);
    public static final int o = a(0, (short) 283);
    public static final int p = a(0, (short) 284);
    public static final int q = a(0, (short) 296);
    public static final int r = a(0, (short) 301);
    public static final int s = a(0, (short) 305);
    public static final int t = a(0, (short) 306);
    public static final int u = a(0, (short) 315);
    public static final int v = a(0, (short) 318);
    public static final int w = a(0, (short) 319);
    public static final int x = a(0, (short) 529);
    public static final int y = a(0, (short) 530);
    public static final int z = a(0, (short) 531);
    public static final int A = a(0, (short) 532);
    public static final int B = a(0, (short) -32104);
    public static final int C = a(0, (short) -30871);
    public static final int D = a(0, (short) -30683);
    public static final int E = a(1, (short) 513);
    public static final int F = a(1, (short) 514);
    public static final int G = a(2, (short) -32102);
    public static final int H = a(2, (short) -32099);
    public static final int I = a(2, (short) -30686);
    public static final int J = a(2, (short) -30684);
    public static final int K = a(2, (short) -30681);
    public static final int L = a(2, (short) -30680);
    public static final int M = a(2, (short) -28672);
    public static final int N = a(2, (short) -28669);
    public static final int O = a(2, (short) -28668);
    public static final int P = a(2, (short) -28415);
    public static final int Q = a(2, (short) -28414);
    public static final int R = a(2, (short) -28159);
    public static final int S = a(2, (short) -28158);
    public static final int T = a(2, (short) -28157);
    public static final int U = a(2, (short) -28156);
    public static final int V = a(2, (short) -28155);
    public static final int W = a(2, (short) -28154);
    public static final int X = a(2, (short) -28153);
    public static final int Y = a(2, (short) -28152);
    public static final int Z = a(2, (short) -28151);
    public static final int aa = a(2, (short) -28150);
    public static final int ab = a(2, (short) -28140);
    public static final int ac = a(2, (short) -28036);
    public static final int ad = a(2, (short) -28026);
    public static final int ae = a(2, (short) -28016);
    public static final int af = a(2, (short) -28015);
    public static final int ag = a(2, (short) -28014);
    public static final int ah = a(2, (short) -24576);
    public static final int ai = a(2, (short) -24575);
    public static final int aj = a(2, (short) -24574);
    public static final int ak = a(2, (short) -24573);
    public static final int al = a(2, (short) -24572);
    public static final int am = a(2, (short) -24571);
    public static final int an = a(2, (short) -24053);
    public static final int ao = a(2, (short) -24052);
    public static final int ap = a(2, (short) -24050);
    public static final int aq = a(2, (short) -24049);
    public static final int ar = a(2, (short) -24048);
    public static final int as = a(2, (short) -24044);
    public static final int at = a(2, (short) -24043);
    public static final int au = a(2, (short) -24041);
    public static final int av = a(2, (short) -23808);
    public static final int aw = a(2, (short) -23807);
    public static final int ax = a(2, (short) -23806);
    public static final int ay = a(2, (short) -23551);
    public static final int az = a(2, (short) -23550);
    public static final int aA = a(2, (short) -23549);
    public static final int aB = a(2, (short) -23548);
    public static final int aC = a(2, (short) -23547);
    public static final int aD = a(2, (short) -23546);
    public static final int aE = a(2, (short) -23545);
    public static final int aF = a(2, (short) -23544);
    public static final int aG = a(2, (short) -23543);
    public static final int aH = a(2, (short) -23542);
    public static final int aI = a(2, (short) -23541);
    public static final int aJ = a(2, (short) -23540);
    public static final int aK = a(2, (short) -23520);
    public static final int aL = a(4, (short) 0);
    public static final int aM = a(4, (short) 1);
    public static final int aN = a(4, (short) 2);
    public static final int aO = a(4, (short) 3);
    public static final int aP = a(4, (short) 4);
    public static final int aQ = a(4, (short) 5);
    public static final int aR = a(4, (short) 6);
    public static final int aS = a(4, (short) 7);
    public static final int aT = a(4, (short) 8);
    public static final int aU = a(4, (short) 9);
    public static final int aV = a(4, (short) 10);
    public static final int aW = a(4, (short) 11);
    public static final int aX = a(4, (short) 12);
    public static final int aY = a(4, (short) 13);
    public static final int aZ = a(4, (short) 14);
    public static final int ba = a(4, (short) 15);
    public static final int bb = a(4, (short) 16);
    public static final int bc = a(4, (short) 17);
    public static final int bd = a(4, (short) 18);
    public static final int be = a(4, (short) 19);
    public static final int bf = a(4, (short) 20);
    public static final int bg = a(4, (short) 21);
    public static final int bh = a(4, (short) 22);
    public static final int bi = a(4, (short) 23);
    public static final int bj = a(4, (short) 24);
    public static final int bk = a(4, (short) 25);
    public static final int bl = a(4, (short) 26);
    public static final int bm = a(4, (short) 27);
    public static final int bn = a(4, (short) 28);
    public static final int bo = a(4, (short) 29);
    public static final int bp = a(4, (short) 30);
    public static final int bq = a(3, (short) 1);
    private static HashSet bt = new HashSet();

    static {
        bt.add(Short.valueOf(a(D)));
        bt.add(Short.valueOf(a(C)));
        bt.add(Short.valueOf(a(E)));
        bt.add(Short.valueOf(a(am)));
        bt.add(Short.valueOf(a(i)));
        br = new HashSet(bt);
        br.add(Short.valueOf(a(-1)));
        br.add(Short.valueOf(a(F)));
        br.add(Short.valueOf(a(m)));
        bs = ByteOrder.BIG_ENDIAN;
    }

    public c() {
        this.bw.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static int a(int i2, short s2) {
        return (65535 & s2) | (i2 << 16);
    }

    protected static int a(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        int[] iArrA = k.a();
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            for (int i4 : iArr) {
                if (iArrA[i3] == i4) {
                    i2 |= 1 << i3;
                    break;
                }
            }
        }
        return i2;
    }

    public static short a(int i2) {
        return (short) i2;
    }

    protected static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    protected static boolean a(short s2) {
        return bt.contains(Short.valueOf(s2));
    }

    public static int b(int i2) {
        return i2 >>> 16;
    }

    public static int b(short s2) {
        switch (s2) {
            case 1:
            case 2:
            case 4:
            case 5:
            case 7:
            default:
                return 0;
            case 3:
                return 180;
            case 6:
                return 90;
            case 8:
                return 270;
        }
    }

    private void b() {
        int iA = a(new int[]{0, 1}) << 24;
        this.by.put(g, iA | 131072);
        this.by.put(f46a, iA | 262144 | 1);
        this.by.put(b, iA | 262144 | 1);
        this.by.put(c, iA | 196608 | 3);
        this.by.put(d, iA | 196608 | 1);
        this.by.put(e, iA | 196608 | 1);
        this.by.put(j, iA | 196608 | 1);
        this.by.put(k, iA | 196608 | 1);
        this.by.put(p, iA | 196608 | 1);
        this.by.put(y, iA | 196608 | 2);
        this.by.put(z, iA | 196608 | 1);
        this.by.put(n, iA | 327680 | 1);
        this.by.put(o, iA | 327680 | 1);
        this.by.put(q, iA | 196608 | 1);
        this.by.put(i, iA | 262144);
        this.by.put(l, iA | 262144 | 1);
        this.by.put(m, iA | 262144);
        this.by.put(r, iA | 196608 | 768);
        this.by.put(v, iA | 327680 | 2);
        this.by.put(w, iA | 327680 | 6);
        this.by.put(x, iA | 327680 | 3);
        this.by.put(A, iA | 327680 | 6);
        this.by.put(t, iA | 131072 | 20);
        this.by.put(f, iA | 131072);
        this.by.put(g, iA | 131072);
        this.by.put(h, iA | 131072);
        this.by.put(s, iA | 131072);
        this.by.put(u, iA | 131072);
        this.by.put(B, iA | 131072);
        this.by.put(C, iA | 262144 | 1);
        this.by.put(D, iA | 262144 | 1);
        int iA2 = a(new int[]{1}) << 24;
        this.by.put(E, iA2 | 262144 | 1);
        this.by.put(F, iA2 | 262144 | 1);
        int iA3 = a(new int[]{2}) << 24;
        this.by.put(M, iA3 | 458752 | 4);
        this.by.put(ah, iA3 | 458752 | 4);
        this.by.put(ai, iA3 | 196608 | 1);
        this.by.put(P, iA3 | 458752 | 4);
        this.by.put(Q, iA3 | 327680 | 1);
        this.by.put(aj, iA3 | 262144 | 1);
        this.by.put(ak, iA3 | 262144 | 1);
        this.by.put(ac, iA3 | 458752);
        this.by.put(ad, iA3 | 458752);
        this.by.put(al, iA3 | 131072 | 13);
        this.by.put(N, iA3 | 131072 | 20);
        this.by.put(O, iA3 | 131072 | 20);
        this.by.put(ae, iA3 | 131072);
        this.by.put(af, iA3 | 131072);
        this.by.put(ag, iA3 | 131072);
        this.by.put(aK, iA3 | 131072 | 33);
        this.by.put(G, iA3 | 327680 | 1);
        this.by.put(H, iA3 | 327680 | 1);
        this.by.put(I, iA3 | 196608 | 1);
        this.by.put(J, iA3 | 131072);
        this.by.put(K, iA3 | 196608);
        this.by.put(L, iA3 | 458752);
        this.by.put(R, 655360 | iA3 | 1);
        this.by.put(S, iA3 | 327680 | 1);
        this.by.put(T, 655360 | iA3 | 1);
        this.by.put(U, 655360 | iA3 | 1);
        this.by.put(V, iA3 | 327680 | 1);
        this.by.put(W, iA3 | 327680 | 1);
        this.by.put(X, iA3 | 196608 | 1);
        this.by.put(Y, iA3 | 196608 | 1);
        this.by.put(Z, iA3 | 196608 | 1);
        this.by.put(aa, iA3 | 327680 | 1);
        this.by.put(ab, iA3 | 196608);
        this.by.put(an, iA3 | 327680 | 1);
        this.by.put(ao, iA3 | 458752);
        this.by.put(ap, iA3 | 327680 | 1);
        this.by.put(aq, iA3 | 327680 | 1);
        this.by.put(ar, iA3 | 196608 | 1);
        this.by.put(as, iA3 | 196608 | 2);
        this.by.put(at, iA3 | 327680 | 1);
        this.by.put(au, iA3 | 196608 | 1);
        this.by.put(av, iA3 | 458752 | 1);
        this.by.put(aw, iA3 | 458752 | 1);
        this.by.put(ax, iA3 | 458752);
        this.by.put(ay, iA3 | 196608 | 1);
        this.by.put(az, iA3 | 196608 | 1);
        this.by.put(aA, iA3 | 196608 | 1);
        this.by.put(aB, iA3 | 327680 | 1);
        this.by.put(aC, iA3 | 196608 | 1);
        this.by.put(aD, iA3 | 196608 | 1);
        this.by.put(aE, iA3 | 327680 | 1);
        this.by.put(aF, iA3 | 196608 | 1);
        this.by.put(aG, iA3 | 196608 | 1);
        this.by.put(aH, iA3 | 196608 | 1);
        this.by.put(aI, iA3 | 458752);
        this.by.put(aJ, iA3 | 196608 | 1);
        this.by.put(am, iA3 | 262144 | 1);
        int iA4 = a(new int[]{4}) << 24;
        this.by.put(aL, 65536 | iA4 | 4);
        this.by.put(aM, iA4 | 131072 | 2);
        this.by.put(aO, iA4 | 131072 | 2);
        this.by.put(aN, 655360 | iA4 | 3);
        this.by.put(aP, 655360 | iA4 | 3);
        this.by.put(aQ, 65536 | iA4 | 1);
        this.by.put(aR, iA4 | 327680 | 1);
        this.by.put(aS, iA4 | 327680 | 3);
        this.by.put(aT, iA4 | 131072);
        this.by.put(aU, iA4 | 131072 | 2);
        this.by.put(aV, iA4 | 131072 | 2);
        this.by.put(aW, iA4 | 327680 | 1);
        this.by.put(aX, iA4 | 131072 | 2);
        this.by.put(aY, iA4 | 327680 | 1);
        this.by.put(aZ, iA4 | 131072 | 2);
        this.by.put(ba, iA4 | 327680 | 1);
        this.by.put(bb, iA4 | 131072 | 2);
        this.by.put(bc, iA4 | 327680 | 1);
        this.by.put(bd, iA4 | 131072);
        this.by.put(be, iA4 | 131072 | 2);
        this.by.put(bf, iA4 | 327680 | 1);
        this.by.put(bi, iA4 | 131072 | 2);
        this.by.put(bj, iA4 | 327680 | 1);
        this.by.put(bk, iA4 | 131072 | 2);
        this.by.put(bl, iA4 | 327680 | 1);
        this.by.put(bm, iA4 | 458752);
        this.by.put(bn, iA4 | 458752);
        this.by.put(bo, iA4 | 131072 | 11);
        this.by.put(bp, iA4 | 196608 | 11);
        this.by.put(bq, (a(new int[]{3}) << 24) | 131072);
    }

    protected static boolean d(int i2, int i3) {
        int[] iArrA = k.a();
        int iE = e(i2);
        for (int i4 = 0; i4 < iArrA.length; i4++) {
            if (i3 == iArrA[i4] && ((iE >> i4) & 1) == 1) {
                return true;
            }
        }
        return false;
    }

    protected static int e(int i2) {
        return i2 >>> 24;
    }

    protected SparseIntArray a() {
        if (this.by == null) {
            this.by = new SparseIntArray();
            b();
        }
        return this.by;
    }

    public j a(int i2, int i3) {
        if (j.a(i3)) {
            return this.bu.a(a(i2), i3);
        }
        return null;
    }

    public void a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        try {
            this.bu = new i(this).a(inputStream);
        } catch (d e2) {
            throw new IOException("Invalid exif format : " + e2);
        }
    }

    public void a(String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        if (str == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                a((InputStream) bufferedInputStream);
                bufferedInputStream.close();
            } catch (IOException e2) {
                e = e2;
                a((Closeable) bufferedInputStream);
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
        }
    }

    public Integer b(int i2, int i3) {
        int[] iArrC = c(i2, i3);
        if (iArrC == null || iArrC.length <= 0) {
            return null;
        }
        return new Integer(iArrC[0]);
    }

    public Integer c(int i2) {
        return b(i2, d(i2));
    }

    public int[] c(int i2, int i3) {
        j jVarA = a(i2, i3);
        if (jVarA == null) {
            return null;
        }
        return jVarA.g();
    }

    public int d(int i2) {
        if (a().get(i2) == 0) {
            return -1;
        }
        return b(i2);
    }
}
