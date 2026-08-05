package android.support.v4.animation;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/animation/AnimatorListenerCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public interface AnimatorListenerCompat {
    void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat);

    void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat);

    void onAnimationRepeat(ValueAnimatorCompat valueAnimatorCompat);

    void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat);
}
