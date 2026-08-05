package android.support.v4.view;

import android.view.View;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/NestedScrollingParent.class */
public interface NestedScrollingParent {
    boolean onStartNestedScroll(View view, View view2, int i);

    void onNestedScrollAccepted(View view, View view2, int i);

    void onStopNestedScroll(View view);

    void onNestedScroll(View view, int i, int i2, int i3, int i4);

    void onNestedPreScroll(View view, int i, int i2, int[] iArr);

    boolean onNestedFling(View view, float f, float f2, boolean z);

    boolean onNestedPreFling(View view, float f, float f2);

    int getNestedScrollAxes();
}
