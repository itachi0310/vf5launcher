package android.support.v4.animation;

import android.os.Build;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/animation/AnimatorCompatHelper.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatorCompatHelper {
    private static final AnimatorProvider IMPL;

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            IMPL = new HoneycombMr1AnimatorCompatProvider();
        } else {
            IMPL = new DonutAnimatorCompatProvider();
        }
    }

    public static ValueAnimatorCompat emptyValueAnimator() {
        return IMPL.emptyValueAnimator();
    }

    private AnimatorCompatHelper() {
    }

    public static void clearInterpolator(View view) {
        IMPL.clearInterpolator(view);
    }
}
