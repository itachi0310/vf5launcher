package android.a.a.b;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f8a = new int[0];
    static final long[] b = new long[0];
    static final Object[] c = new Object[0];

    public static int a(int i) {
        return b(i * 8) / 8;
    }

    static int a(long[] jArr, int i, long j) {
        int i2 = 0;
        int i3 = i - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i2 = i4 + 1;
            } else {
                if (j2 <= j) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return i2 ^ (-1);
    }

    public static int b(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }
}
