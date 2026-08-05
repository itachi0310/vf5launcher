package android.a.a.d;

import android.graphics.Canvas;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final h b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f23a;

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            b = new g();
        } else {
            b = new f();
        }
    }

    public void a(int i, int i2) {
        b.a(this.f23a, i, i2);
    }

    public boolean a() {
        return b.a(this.f23a);
    }

    public boolean a(float f) {
        return b.a(this.f23a, f);
    }

    public boolean a(Canvas canvas) {
        return b.a(this.f23a, canvas);
    }

    public void b() {
        b.b(this.f23a);
    }

    public boolean c() {
        return b.c(this.f23a);
    }
}
