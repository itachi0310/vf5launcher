package android.a.a.c;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ae {
    public static void a(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }
}
