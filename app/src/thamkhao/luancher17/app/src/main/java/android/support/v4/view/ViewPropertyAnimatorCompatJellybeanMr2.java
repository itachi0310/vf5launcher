package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewPropertyAnimatorCompatJellybeanMr2.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ViewPropertyAnimatorCompatJellybeanMr2 {
    ViewPropertyAnimatorCompatJellybeanMr2() {
    }

    public static Interpolator getInterpolator(View view) {
        return (Interpolator) view.animate().getInterpolator();
    }
}
