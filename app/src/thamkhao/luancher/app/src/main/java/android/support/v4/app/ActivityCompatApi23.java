package android.support.v4.app;

import android.app.Activity;

/* JADX INFO: compiled from: ActivityCompat23.java */
/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/ActivityCompatApi23.class */
class ActivityCompatApi23 {

    /* JADX INFO: compiled from: ActivityCompat23.java */
    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/ActivityCompatApi23$RequestPermissionsRequestCodeValidator.class */
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
