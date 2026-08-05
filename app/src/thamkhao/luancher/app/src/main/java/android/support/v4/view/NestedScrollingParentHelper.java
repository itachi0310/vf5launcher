package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/NestedScrollingParentHelper.class */
public class NestedScrollingParentHelper {
    private final ViewGroup mViewGroup;
    private int mNestedScrollAxes;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
    }

    public void onNestedScrollAccepted(View child, View target, int axes) {
        this.mNestedScrollAxes = axes;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollAxes;
    }

    public void onStopNestedScroll(View target) {
        this.mNestedScrollAxes = 0;
    }
}
