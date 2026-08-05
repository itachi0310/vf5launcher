package android.support.v4.view;

import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewGroupCompatLollipop.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ViewGroupCompatLollipop {
    ViewGroupCompatLollipop() {
    }

    public static void setTransitionGroup(ViewGroup group, boolean isTransitionGroup) {
        group.setTransitionGroup(isTransitionGroup);
    }

    public static boolean isTransitionGroup(ViewGroup group) {
        return group.isTransitionGroup();
    }

    public static int getNestedScrollAxes(ViewGroup group) {
        return group.getNestedScrollAxes();
    }
}
