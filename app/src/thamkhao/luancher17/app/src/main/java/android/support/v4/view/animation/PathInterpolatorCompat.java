package android.support.v4.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/animation/PathInterpolatorCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static Interpolator create(Path path) {
        return Build.VERSION.SDK_INT >= 21 ? PathInterpolatorCompatApi21.create(path) : PathInterpolatorCompatBase.create(path);
    }

    public static Interpolator create(float controlX, float controlY) {
        return Build.VERSION.SDK_INT >= 21 ? PathInterpolatorCompatApi21.create(controlX, controlY) : PathInterpolatorCompatBase.create(controlX, controlY);
    }

    public static Interpolator create(float controlX1, float controlY1, float controlX2, float controlY2) {
        return Build.VERSION.SDK_INT >= 21 ? PathInterpolatorCompatApi21.create(controlX1, controlY1, controlX2, controlY2) : PathInterpolatorCompatBase.create(controlX1, controlY1, controlX2, controlY2);
    }
}
