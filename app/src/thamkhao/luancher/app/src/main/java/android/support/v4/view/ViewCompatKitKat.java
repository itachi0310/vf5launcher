package android.support.v4.view;

import android.view.View;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/ViewCompatKitKat.class */
class ViewCompatKitKat {
    ViewCompatKitKat() {
    }

    public static int getAccessibilityLiveRegion(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static void setAccessibilityLiveRegion(View view, int mode) {
        view.setAccessibilityLiveRegion(mode);
    }

    public static boolean isLaidOut(View view) {
        return view.isLaidOut();
    }

    public static boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }
}
