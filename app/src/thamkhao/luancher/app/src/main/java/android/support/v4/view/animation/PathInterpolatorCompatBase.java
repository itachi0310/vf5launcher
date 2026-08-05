package android.support.v4.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/animation/PathInterpolatorCompatBase.class */
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
