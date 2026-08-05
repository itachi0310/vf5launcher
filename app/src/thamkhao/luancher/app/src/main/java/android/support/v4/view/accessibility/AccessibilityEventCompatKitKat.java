package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/accessibility/AccessibilityEventCompatKitKat.class */
class AccessibilityEventCompatKitKat {
    AccessibilityEventCompatKitKat() {
    }

    public static void setContentChangeTypes(AccessibilityEvent event, int changeTypes) {
        event.setContentChangeTypes(changeTypes);
    }

    public static int getContentChangeTypes(AccessibilityEvent event) {
        return event.getContentChangeTypes();
    }
}
