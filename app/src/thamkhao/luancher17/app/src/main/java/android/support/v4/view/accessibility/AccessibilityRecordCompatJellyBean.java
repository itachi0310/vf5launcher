package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/accessibility/AccessibilityRecordCompatJellyBean.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityRecordCompatJellyBean {
    AccessibilityRecordCompatJellyBean() {
    }

    public static void setSource(Object record, View root, int virtualDescendantId) {
        ((AccessibilityRecord) record).setSource(root, virtualDescendantId);
    }
}
