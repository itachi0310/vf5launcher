package android.support.v4.view;

import android.view.VelocityTracker;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/VelocityTrackerCompatHoneycomb.class */
class VelocityTrackerCompatHoneycomb {
    VelocityTrackerCompatHoneycomb() {
    }

    public static float getXVelocity(VelocityTracker tracker, int pointerId) {
        return tracker.getXVelocity(pointerId);
    }

    public static float getYVelocity(VelocityTracker tracker, int pointerId) {
        return tracker.getYVelocity(pointerId);
    }
}
