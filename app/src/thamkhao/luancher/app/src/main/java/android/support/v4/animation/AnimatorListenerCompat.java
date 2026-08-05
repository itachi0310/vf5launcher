package android.support.v4.animation;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/animation/AnimatorListenerCompat.class */
public interface AnimatorListenerCompat {
    void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat);

    void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat);

    void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat);

    void onAnimationRepeat(ValueAnimatorCompat valueAnimatorCompat);
}
