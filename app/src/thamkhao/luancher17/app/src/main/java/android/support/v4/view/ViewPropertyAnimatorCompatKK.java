package android.support.v4.view;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewPropertyAnimatorCompatKK.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ViewPropertyAnimatorCompatKK {
    ViewPropertyAnimatorCompatKK() {
    }

    public static void setUpdateListener(final View view, final ViewPropertyAnimatorUpdateListener listener) {
        ValueAnimator.AnimatorUpdateListener wrapped = null;
        if (listener != null) {
            wrapped = new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v4.view.ViewPropertyAnimatorCompatKK.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    listener.onAnimationUpdate(view);
                }
            };
        }
        view.animate().setUpdateListener(wrapped);
    }
}
