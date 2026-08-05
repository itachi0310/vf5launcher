package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/ViewParentCompatICS.class */
class ViewParentCompatICS {
    ViewParentCompatICS() {
    }

    public static boolean requestSendAccessibilityEvent(ViewParent parent, View child, AccessibilityEvent event) {
        return parent.requestSendAccessibilityEvent(child, event);
    }
}
