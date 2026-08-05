package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/NestedScrollingParentHelper.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class NestedScrollingParentHelper {
    private int mNestedScrollAxes;
    private final ViewGroup mViewGroup;

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
