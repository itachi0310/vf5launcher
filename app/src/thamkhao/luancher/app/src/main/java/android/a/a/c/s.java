package android.a.a.c;

import android.graphics.Paint;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class s implements aa {
    s() {
    }

    @Override // android.a.a.c.aa
    public int a(View view) {
        return 2;
    }

    long a() {
        return 10L;
    }

    @Override // android.a.a.c.aa
    public void a(View view, int i, Paint paint) {
    }

    @Override // android.a.a.c.aa
    public void a(View view, Runnable runnable) {
        view.postDelayed(runnable, a());
    }

    @Override // android.a.a.c.aa
    public void a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, a() + j);
    }

    @Override // android.a.a.c.aa
    public boolean a(View view, int i) {
        return false;
    }

    @Override // android.a.a.c.aa
    public void b(View view) {
        view.postInvalidateDelayed(a());
    }
}
