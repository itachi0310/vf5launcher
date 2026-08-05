package android.a.a.c;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ac {
    static long a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }
}
