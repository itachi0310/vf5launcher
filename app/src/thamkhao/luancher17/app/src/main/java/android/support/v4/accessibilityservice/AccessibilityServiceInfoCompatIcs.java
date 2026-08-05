package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/accessibilityservice/AccessibilityServiceInfoCompatIcs.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class AccessibilityServiceInfoCompatIcs {
    AccessibilityServiceInfoCompatIcs() {
    }

    public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo info) {
        return info.getCanRetrieveWindowContent();
    }

    public static String getDescription(AccessibilityServiceInfo info) {
        return info.getDescription();
    }

    public static String getId(AccessibilityServiceInfo info) {
        return info.getId();
    }

    public static ResolveInfo getResolveInfo(AccessibilityServiceInfo info) {
        return info.getResolveInfo();
    }

    public static String getSettingsActivityName(AccessibilityServiceInfo info) {
        return info.getSettingsActivityName();
    }
}
