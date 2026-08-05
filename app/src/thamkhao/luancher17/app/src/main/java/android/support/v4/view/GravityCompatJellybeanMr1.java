package android.support.v4.view;

import android.graphics.Rect;
import android.view.Gravity;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/GravityCompatJellybeanMr1.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class GravityCompatJellybeanMr1 {
    GravityCompatJellybeanMr1() {
    }

    public static int getAbsoluteGravity(int gravity, int layoutDirection) {
        return Gravity.getAbsoluteGravity(gravity, layoutDirection);
    }

    public static void apply(int gravity, int w, int h, Rect container, Rect outRect, int layoutDirection) {
        Gravity.apply(gravity, w, h, container, outRect, layoutDirection);
    }

    public static void apply(int gravity, int w, int h, Rect container, int xAdj, int yAdj, Rect outRect, int layoutDirection) {
        Gravity.apply(gravity, w, h, container, xAdj, yAdj, outRect, layoutDirection);
    }

    public static void applyDisplay(int gravity, Rect display, Rect inoutObj, int layoutDirection) {
        Gravity.applyDisplay(gravity, display, inoutObj, layoutDirection);
    }
}
