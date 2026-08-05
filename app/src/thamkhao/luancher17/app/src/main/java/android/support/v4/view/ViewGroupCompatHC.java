package android.support.v4.view;

import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewGroupCompatHC.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ViewGroupCompatHC {
    private ViewGroupCompatHC() {
    }

    public static void setMotionEventSplittingEnabled(ViewGroup group, boolean split) {
        group.setMotionEventSplittingEnabled(split);
    }
}
