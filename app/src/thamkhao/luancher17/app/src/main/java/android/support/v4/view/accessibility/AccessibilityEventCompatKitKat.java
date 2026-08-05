package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/accessibility/AccessibilityEventCompatKitKat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
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
