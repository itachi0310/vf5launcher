package cn.kuwo.autosdk;

/* JADX INFO: loaded from: classes.dex */
public final class r {
    private static volatile int a = 0;
    private static t[] b = new t[5];

    public static void a(s sVar, Runnable runnable) {
        if (sVar == s.NET) {
        }
        c().a(runnable, 0);
    }

    private static t c() {
        t tVar;
        t tVar2 = null;
        if (a == 0) {
            return new t(tVar2);
        }
        synchronized (b) {
            if (a == 0) {
                tVar = new t(null);
            } else {
                a--;
                tVar = b[a];
                b[a] = null;
            }
        }
        return tVar;
    }
}
