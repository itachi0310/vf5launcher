package android.support.v4.animation;

import android.view.View;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/animation/AnimatorProvider.class */
interface AnimatorProvider {
    ValueAnimatorCompat emptyValueAnimator();

    void clearInterpolator(View view);
}
