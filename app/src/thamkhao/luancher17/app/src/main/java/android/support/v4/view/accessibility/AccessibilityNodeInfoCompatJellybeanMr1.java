package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/accessibility/AccessibilityNodeInfoCompatJellybeanMr1.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityNodeInfoCompatJellybeanMr1 {
    AccessibilityNodeInfoCompatJellybeanMr1() {
    }

    public static void setLabelFor(Object info, View labeled) {
        ((AccessibilityNodeInfo) info).setLabelFor(labeled);
    }

    public static void setLabelFor(Object info, View root, int virtualDescendantId) {
        ((AccessibilityNodeInfo) info).setLabelFor(root, virtualDescendantId);
    }

    public static Object getLabelFor(Object info) {
        return ((AccessibilityNodeInfo) info).getLabelFor();
    }

    public static void setLabeledBy(Object info, View labeled) {
        ((AccessibilityNodeInfo) info).setLabeledBy(labeled);
    }

    public static void setLabeledBy(Object info, View root, int virtualDescendantId) {
        ((AccessibilityNodeInfo) info).setLabeledBy(root, virtualDescendantId);
    }

    public static Object getLabeledBy(Object info) {
        return ((AccessibilityNodeInfo) info).getLabeledBy();
    }
}
