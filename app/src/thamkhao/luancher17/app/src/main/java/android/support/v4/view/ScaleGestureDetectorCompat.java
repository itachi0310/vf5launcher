package android.support.v4.view;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ScaleGestureDetectorCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class ScaleGestureDetectorCompat {
    static final ScaleGestureDetectorImpl IMPL;

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ScaleGestureDetectorCompat$ScaleGestureDetectorImpl.class
  classes.dex
 */
    interface ScaleGestureDetectorImpl {
        boolean isQuickScaleEnabled(Object obj);

        void setQuickScaleEnabled(Object obj, boolean z);
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ScaleGestureDetectorCompat$BaseScaleGestureDetectorImpl.class
  classes.dex
 */
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

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ScaleGestureDetectorCompat$ScaleGestureDetectorCompatKitKatImpl.class
  classes.dex
 */
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
