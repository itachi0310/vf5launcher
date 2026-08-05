package android.support.v4.app;

import android.app.Activity;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/ActivityCompatApi23.class
  classes.dex
 */
/* JADX INFO: compiled from: ActivityCompat23.java */
/* JADX INFO: loaded from: classes.dex */
class ActivityCompatApi23 {

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/ActivityCompatApi23$RequestPermissionsRequestCodeValidator.class
  classes.dex
 */
    /* JADX INFO: compiled from: ActivityCompat23.java */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    ActivityCompatApi23() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(Activity activity, String[] permissions, int requestCode) {
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(requestCode);
        }
        activity.requestPermissions(permissions, requestCode);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String permission) {
        return activity.shouldShowRequestPermissionRationale(permission);
    }
}
