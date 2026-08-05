package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/ViewParentCompatKitKat.class */
class ViewParentCompatKitKat {
    ViewParentCompatKitKat() {
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent parent, View child, View source, int changeType) {
        parent.notifySubtreeAccessibilityStateChanged(child, source, changeType);
    }
}
