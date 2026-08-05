package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityRecord;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/accessibility/AccessibilityRecordCompatIcsMr1.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityRecordCompatIcsMr1 {
    AccessibilityRecordCompatIcsMr1() {
    }

    public static int getMaxScrollX(Object record) {
        return ((AccessibilityRecord) record).getMaxScrollX();
    }

    public static int getMaxScrollY(Object record) {
        return ((AccessibilityRecord) record).getMaxScrollY();
    }

    public static void setMaxScrollX(Object record, int maxScrollX) {
        ((AccessibilityRecord) record).setMaxScrollX(maxScrollX);
    }

    public static void setMaxScrollY(Object record, int maxScrollY) {
        ((AccessibilityRecord) record).setMaxScrollY(maxScrollY);
    }
}
