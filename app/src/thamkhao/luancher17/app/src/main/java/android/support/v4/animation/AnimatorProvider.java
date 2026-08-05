package android.support.v4.animation;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/animation/AnimatorProvider.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
interface AnimatorProvider {
    void clearInterpolator(View view);

    ValueAnimatorCompat emptyValueAnimator();
}
