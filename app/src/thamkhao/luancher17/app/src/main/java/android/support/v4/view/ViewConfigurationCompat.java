package android.support.v4.view;

import android.os.Build;
import android.view.ViewConfiguration;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewConfigurationCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewConfigurationCompat {
    static final ViewConfigurationVersionImpl IMPL;

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewConfigurationCompat$ViewConfigurationVersionImpl.class
  classes.dex
 */
    interface ViewConfigurationVersionImpl {
        int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration);

        boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration);
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewConfigurationCompat$BaseViewConfigurationVersionImpl.class
  classes.dex
 */
    static class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        BaseViewConfigurationVersionImpl() {
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public int getScaledPagingTouchSlop(ViewConfiguration config) {
            return config.getScaledTouchSlop();
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public boolean hasPermanentMenuKey(ViewConfiguration config) {
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewConfigurationCompat$FroyoViewConfigurationVersionImpl.class
  classes.dex
 */
    static class FroyoViewConfigurationVersionImpl extends BaseViewConfigurationVersionImpl {
        FroyoViewConfigurationVersionImpl() {
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.BaseViewConfigurationVersionImpl, android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public int getScaledPagingTouchSlop(ViewConfiguration config) {
            return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(config);
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewConfigurationCompat$HoneycombViewConfigurationVersionImpl.class
  classes.dex
 */
    static class HoneycombViewConfigurationVersionImpl extends FroyoViewConfigurationVersionImpl {
        HoneycombViewConfigurationVersionImpl() {
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.BaseViewConfigurationVersionImpl, android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public boolean hasPermanentMenuKey(ViewConfiguration config) {
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/ViewConfigurationCompat$IcsViewConfigurationVersionImpl.class
  classes.dex
 */
    static class IcsViewConfigurationVersionImpl extends HoneycombViewConfigurationVersionImpl {
        IcsViewConfigurationVersionImpl() {
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.HoneycombViewConfigurationVersionImpl, android.support.v4.view.ViewConfigurationCompat.BaseViewConfigurationVersionImpl, android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public boolean hasPermanentMenuKey(ViewConfiguration config) {
            return ViewConfigurationCompatICS.hasPermanentMenuKey(config);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new IcsViewConfigurationVersionImpl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombViewConfigurationVersionImpl();
        } else if (Build.VERSION.SDK_INT >= 8) {
            IMPL = new FroyoViewConfigurationVersionImpl();
        } else {
            IMPL = new BaseViewConfigurationVersionImpl();
        }
    }

    public static int getScaledPagingTouchSlop(ViewConfiguration config) {
        return IMPL.getScaledPagingTouchSlop(config);
    }

    public static boolean hasPermanentMenuKey(ViewConfiguration config) {
        return IMPL.hasPermanentMenuKey(config);
    }

    private ViewConfigurationCompat() {
    }
}
