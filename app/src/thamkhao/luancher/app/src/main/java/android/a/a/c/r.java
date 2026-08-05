package android.a.a.c;

import android.graphics.Paint;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final aa f19a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            f19a = new z();
            return;
        }
        if (i >= 17) {
            f19a = new y();
            return;
        }
        if (i >= 16) {
            f19a = new x();
            return;
        }
        if (i >= 14) {
            f19a = new w();
            return;
        }
        if (i >= 11) {
            f19a = new v();
        } else if (i >= 9) {
            f19a = new u();
        } else {
            f19a = new s();
        }
    }

    public static int a(View view) {
        return f19a.a(view);
    }

    public static void a(View view, int i, Paint paint) {
        f19a.a(view, i, paint);
    }

    public static void a(View view, Runnable runnable) {
        f19a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        f19a.a(view, runnable, j);
    }

    public static boolean a(View view, int i) {
        return f19a.a(view, i);
    }

    public static void b(View view) {
        f19a.b(view);
    }
}
