package android.a.a.c;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
final class ah implements Interpolator {
    ah() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * f2 * f2 * f2 * f2) + 1.0f;
    }
}
