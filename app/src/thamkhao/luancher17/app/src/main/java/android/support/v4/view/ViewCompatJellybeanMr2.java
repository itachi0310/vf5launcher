package android.support.v4.view;

import android.graphics.Rect;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewCompatJellybeanMr2.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ViewCompatJellybeanMr2 {
    ViewCompatJellybeanMr2() {
    }

    public static Rect getClipBounds(View view) {
        return view.getClipBounds();
    }

    public static void setClipBounds(View view, Rect clipBounds) {
        view.setClipBounds(clipBounds);
    }
}
