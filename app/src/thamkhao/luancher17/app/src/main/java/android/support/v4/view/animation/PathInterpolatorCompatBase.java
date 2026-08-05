package android.support.v4.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/animation/PathInterpolatorCompatBase.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class PathInterpolatorCompatBase {
    private PathInterpolatorCompatBase() {
    }

    public static Interpolator create(Path path) {
        return new PathInterpolatorDonut(path);
    }

    public static Interpolator create(float controlX, float controlY) {
        return new PathInterpolatorDonut(controlX, controlY);
    }

    public static Interpolator create(float controlX1, float controlY1, float controlX2, float controlY2) {
        return new PathInterpolatorDonut(controlX1, controlY1, controlX2, controlY2);
    }
}
