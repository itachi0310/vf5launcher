package android.support.v4.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewGroupCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupCompat {
    static final ViewGroupCompatImpl IMPL;
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewGroupCompat$ViewGroupCompatImpl.class
  classes.dex
 */
    interface ViewGroupCompatImpl {
        int getLayoutMode(ViewGroup viewGroup);

        int getNestedScrollAxes(ViewGroup viewGroup);

        boolean isTransitionGroup(ViewGroup viewGroup);

        boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void setLayoutMode(ViewGroup viewGroup, int i);

        void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z);

        void setTransitionGroup(ViewGroup viewGroup, boolean z);
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewGroupCompat$ViewGroupCompatStubImpl.class
  classes.dex
 */
    static class ViewGroupCompatStubImpl implements ViewGroupCompatImpl {
        ViewGroupCompatStubImpl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public boolean onRequestSendAccessibilityEvent(ViewGroup group, View child, AccessibilityEvent event) {
            return true;
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public void setMotionEventSplittingEnabled(ViewGroup group, boolean split) {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public int getLayoutMode(ViewGroup group) {
            return 0;
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public void setLayoutMode(ViewGroup group, int mode) {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public void setTransitionGroup(ViewGroup group, boolean isTransitionGroup) {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public boolean isTransitionGroup(ViewGroup group) {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public int getNestedScrollAxes(ViewGroup viewGroup) {
            if (viewGroup instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewGroup).getNestedScrollAxes();
            }
            return 0;
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewGroupCompat$ViewGroupCompatHCImpl.class
  classes.dex
 */
    static class ViewGroupCompatHCImpl extends ViewGroupCompatStubImpl {
        ViewGroupCompatHCImpl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl, android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public void setMotionEventSplittingEnabled(ViewGroup group, boolean split) {
            ViewGroupCompatHC.setMotionEventSplittingEnabled(group, split);
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewGroupCompat$ViewGroupCompatIcsImpl.class
  classes.dex
 */
    static class ViewGroupCompatIcsImpl extends ViewGroupCompatHCImpl {
        ViewGroupCompatIcsImpl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl, android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public boolean onRequestSendAccessibilityEvent(ViewGroup group, View child, AccessibilityEvent event) {
            return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(group, child, event);
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewGroupCompat$ViewGroupCompatJellybeanMR2Impl.class
  classes.dex
 */
    static class ViewGroupCompatJellybeanMR2Impl extends ViewGroupCompatIcsImpl {
        ViewGroupCompatJellybeanMR2Impl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl, android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public int getLayoutMode(ViewGroup group) {
            return ViewGroupCompatJellybeanMR2.getLayoutMode(group);
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl, android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public void setLayoutMode(ViewGroup group, int mode) {
            ViewGroupCompatJellybeanMR2.setLayoutMode(group, mode);
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewGroupCompat$ViewGroupCompatLollipopImpl.class
  classes.dex
 */
    static class ViewGroupCompatLollipopImpl extends ViewGroupCompatJellybeanMR2Impl {
        ViewGroupCompatLollipopImpl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl, android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public void setTransitionGroup(ViewGroup group, boolean isTransitionGroup) {
            ViewGroupCompatLollipop.setTransitionGroup(group, isTransitionGroup);
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl, android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public boolean isTransitionGroup(ViewGroup group) {
            return ViewGroupCompatLollipop.isTransitionGroup(group);
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatStubImpl, android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
        public int getNestedScrollAxes(ViewGroup group) {
            return ViewGroupCompatLollipop.getNestedScrollAxes(group);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 21) {
            IMPL = new ViewGroupCompatLollipopImpl();
            return;
        }
        if (version >= 18) {
            IMPL = new ViewGroupCompatJellybeanMR2Impl();
            return;
        }
        if (version >= 14) {
            IMPL = new ViewGroupCompatIcsImpl();
        } else if (version >= 11) {
            IMPL = new ViewGroupCompatHCImpl();
        } else {
            IMPL = new ViewGroupCompatStubImpl();
        }
    }

    private ViewGroupCompat() {
    }

    public static boolean onRequestSendAccessibilityEvent(ViewGroup group, View child, AccessibilityEvent event) {
        return IMPL.onRequestSendAccessibilityEvent(group, child, event);
    }

    public static void setMotionEventSplittingEnabled(ViewGroup group, boolean split) {
        IMPL.setMotionEventSplittingEnabled(group, split);
    }

    public static int getLayoutMode(ViewGroup group) {
        return IMPL.getLayoutMode(group);
    }

    public static void setLayoutMode(ViewGroup group, int mode) {
        IMPL.setLayoutMode(group, mode);
    }

    public static void setTransitionGroup(ViewGroup group, boolean isTransitionGroup) {
        IMPL.setTransitionGroup(group, isTransitionGroup);
    }

    public static boolean isTransitionGroup(ViewGroup group) {
        return IMPL.isTransitionGroup(group);
    }

    public static int getNestedScrollAxes(ViewGroup group) {
        return IMPL.getNestedScrollAxes(group);
    }
}
