package android.support.v4.view;

import android.view.ViewGroup;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/ViewGroupCompatLollipop.class */
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
