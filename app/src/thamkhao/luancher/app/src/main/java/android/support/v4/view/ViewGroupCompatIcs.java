package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/ViewGroupCompatIcs.class */
class ViewGroupCompatIcs {
    ViewGroupCompatIcs() {
    }

    public static boolean onRequestSendAccessibilityEvent(ViewGroup group, View child, AccessibilityEvent event) {
        return group.onRequestSendAccessibilityEvent(child, event);
    }
}
