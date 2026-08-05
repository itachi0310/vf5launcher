package android.support.v4.view;

import android.os.Build;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/ScaleGestureDetectorCompat.class */
public final class ScaleGestureDetectorCompat {
    static final ScaleGestureDetectorImpl IMPL;

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/ScaleGestureDetectorCompat$ScaleGestureDetectorImpl.class */
    interface ScaleGestureDetectorImpl {
        void setQuickScaleEnabled(Object obj, boolean z);

        boolean isQuickScaleEnabled(Object obj);
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/ScaleGestureDetectorCompat$BaseScaleGestureDetectorImpl.class */
    private static class BaseScaleGestureDetectorImpl implements ScaleGestureDetectorImpl {
        private BaseScaleGestureDetectorImpl() {
        }

        @Override // android.support.v4.view.ScaleGestureDetectorCompat.ScaleGestureDetectorImpl
        public void setQuickScaleEnabled(Object o, boolean enabled) {
        }

        @Override // android.support.v4.view.ScaleGestureDetectorCompat.ScaleGestureDetectorImpl
        public boolean isQuickScaleEnabled(Object o) {
            return false;
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/ScaleGestureDetectorCompat$ScaleGestureDetectorCompatKitKatImpl.class */
    private static class ScaleGestureDetectorCompatKitKatImpl implements ScaleGestureDetectorImpl {
        private ScaleGestureDetectorCompatKitKatImpl() {
        }

        @Override // android.support.v4.view.ScaleGestureDetectorCompat.ScaleGestureDetectorImpl
        public void setQuickScaleEnabled(Object o, boolean enabled) {
            ScaleGestureDetectorCompatKitKat.setQuickScaleEnabled(o, enabled);
        }

        @Override // android.support.v4.view.ScaleGestureDetectorCompat.ScaleGestureDetectorImpl
        public boolean isQuickScaleEnabled(Object o) {
            return ScaleGestureDetectorCompatKitKat.isQuickScaleEnabled(o);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 19) {
            IMPL = new ScaleGestureDetectorCompatKitKatImpl();
        } else {
            IMPL = new BaseScaleGestureDetectorImpl();
        }
    }

    private ScaleGestureDetectorCompat() {
    }

    public static void setQuickScaleEnabled(Object scaleGestureDetector, boolean enabled) {
        IMPL.setQuickScaleEnabled(scaleGestureDetector, enabled);
    }

    public static boolean isQuickScaleEnabled(Object scaleGestureDetector) {
        return IMPL.isQuickScaleEnabled(scaleGestureDetector);
    }
}
