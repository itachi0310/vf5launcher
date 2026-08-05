package android.support.v4.view;

import android.os.Build;
import android.view.VelocityTracker;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/VelocityTrackerCompat.class */
public final class VelocityTrackerCompat {
    static final VelocityTrackerVersionImpl IMPL;

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/VelocityTrackerCompat$VelocityTrackerVersionImpl.class */
    interface VelocityTrackerVersionImpl {
        float getXVelocity(VelocityTracker velocityTracker, int i);

        float getYVelocity(VelocityTracker velocityTracker, int i);
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/VelocityTrackerCompat$BaseVelocityTrackerVersionImpl.class */
    static class BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        BaseVelocityTrackerVersionImpl() {
        }

        @Override // android.support.v4.view.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getXVelocity(VelocityTracker tracker, int pointerId) {
            return tracker.getXVelocity();
        }

        @Override // android.support.v4.view.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getYVelocity(VelocityTracker tracker, int pointerId) {
            return tracker.getYVelocity();
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/VelocityTrackerCompat$HoneycombVelocityTrackerVersionImpl.class */
    static class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        HoneycombVelocityTrackerVersionImpl() {
        }

        @Override // android.support.v4.view.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getXVelocity(VelocityTracker tracker, int pointerId) {
            return VelocityTrackerCompatHoneycomb.getXVelocity(tracker, pointerId);
        }

        @Override // android.support.v4.view.VelocityTrackerCompat.VelocityTrackerVersionImpl
        public float getYVelocity(VelocityTracker tracker, int pointerId) {
            return VelocityTrackerCompatHoneycomb.getYVelocity(tracker, pointerId);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombVelocityTrackerVersionImpl();
        } else {
            IMPL = new BaseVelocityTrackerVersionImpl();
        }
    }

    public static float getXVelocity(VelocityTracker tracker, int pointerId) {
        return IMPL.getXVelocity(tracker, pointerId);
    }

    public static float getYVelocity(VelocityTracker tracker, int pointerId) {
        return IMPL.getYVelocity(tracker, pointerId);
    }

    private VelocityTrackerCompat() {
    }
}
