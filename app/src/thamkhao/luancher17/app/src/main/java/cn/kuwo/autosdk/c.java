package cn.kuwo.autosdk;

/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {
    private static /* synthetic */ int[] d;
    final /* synthetic */ b a;
    private final /* synthetic */ e b;
    private final /* synthetic */ int c;

    c(b bVar, e eVar, int i) {
        this.a = bVar;
        this.b = eVar;
        this.c = i;
    }

    static /* synthetic */ int[] a() {
        int[] iArr = d;
        if (iArr == null) {
            iArr = new int[e.a().length];
            try {
                iArr[e.NOTIFY_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[e.NOTIFY_FINISH.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[e.NOTIFY_START.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            d = iArr;
        }
        return iArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.a) {
            if (this.a.p) {
                return;
            }
            switch (a()[this.b.ordinal()]) {
                case 1:
                    this.a.x.a(this.a, this.c, this.a.z);
                    break;
                case 2:
                    this.a.x.b(this.a, this.a.z);
                    break;
                case 3:
                    this.a.x.a(this.a, this.a.z);
                    break;
            }
        }
    }
}
