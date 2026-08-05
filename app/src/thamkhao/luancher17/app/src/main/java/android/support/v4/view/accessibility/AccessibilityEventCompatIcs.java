package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/accessibility/AccessibilityEventCompatIcs.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityEventCompatIcs {
    AccessibilityEventCompatIcs() {
    }

    public static int getRecordCount(AccessibilityEvent event) {
        return event.getRecordCount();
    }

    public static void appendRecord(AccessibilityEvent event, Object record) {
        event.appendRecord((AccessibilityRecord) record);
    }

    public static Object getRecord(AccessibilityEvent event, int index) {
        return event.getRecord(index);
    }

    public static void setScrollable(AccessibilityEvent event, boolean scrollable) {
        event.setScrollable(scrollable);
    }
}
