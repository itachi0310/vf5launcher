package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewPropertyAnimatorCompatJB.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ViewPropertyAnimatorCompatJB {
    ViewPropertyAnimatorCompatJB() {
    }

    public static void withStartAction(View view, Runnable runnable) {
        view.animate().withStartAction(runnable);
    }

    public static void withEndAction(View view, Runnable runnable) {
        view.animate().withEndAction(runnable);
    }

    public static void withLayer(View view) {
        view.animate().withLayer();
    }

    public static void setListener(final View view, final ViewPropertyAnimatorListener listener) {
        if (listener != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: android.support.v4.view.ViewPropertyAnimatorCompatJB.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    listener.onAnimationCancel(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    listener.onAnimationEnd(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    listener.onAnimationStart(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }
}
