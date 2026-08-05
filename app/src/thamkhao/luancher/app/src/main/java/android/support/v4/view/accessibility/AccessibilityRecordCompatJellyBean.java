package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/accessibility/AccessibilityRecordCompatJellyBean.class */
class AccessibilityRecordCompatJellyBean {
    AccessibilityRecordCompatJellyBean() {
    }

    public static void setSource(Object record, View root, int virtualDescendantId) {
        ((AccessibilityRecord) record).setSource(root, virtualDescendantId);
    }
}
