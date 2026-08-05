package android.support.v4.view;

import android.os.Build;
import android.view.LayoutInflater;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/LayoutInflaterCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutInflaterCompat {
    static final LayoutInflaterCompatImpl IMPL;

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/LayoutInflaterCompat$LayoutInflaterCompatImpl.class
  classes.dex
 */
    interface LayoutInflaterCompatImpl {
        LayoutInflaterFactory getFactory(LayoutInflater layoutInflater);

        void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory);
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/LayoutInflaterCompat$LayoutInflaterCompatImplBase.class
  classes.dex
 */
    static class LayoutInflaterCompatImplBase implements LayoutInflaterCompatImpl {
        LayoutInflaterCompatImplBase() {
        }

        @Override // android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatImpl
        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory factory) {
            LayoutInflaterCompatBase.setFactory(layoutInflater, factory);
        }

        @Override // android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatImpl
        public LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
            return LayoutInflaterCompatBase.getFactory(layoutInflater);
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/LayoutInflaterCompat$LayoutInflaterCompatImplV11.class
  classes.dex
 */
    static class LayoutInflaterCompatImplV11 extends LayoutInflaterCompatImplBase {
        LayoutInflaterCompatImplV11() {
        }

        @Override // android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatImplBase, android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatImpl
        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory factory) {
            LayoutInflaterCompatHC.setFactory(layoutInflater, factory);
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/LayoutInflaterCompat$LayoutInflaterCompatImplV21.class
  classes.dex
 */
    static class LayoutInflaterCompatImplV21 extends LayoutInflaterCompatImplV11 {
        LayoutInflaterCompatImplV21() {
        }

        @Override // android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatImplV11, android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatImplBase, android.support.v4.view.LayoutInflaterCompat.LayoutInflaterCompatImpl
        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory factory) {
            LayoutInflaterCompatLollipop.setFactory(layoutInflater, factory);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 21) {
            IMPL = new LayoutInflaterCompatImplV21();
        } else if (version >= 11) {
            IMPL = new LayoutInflaterCompatImplV11();
        } else {
            IMPL = new LayoutInflaterCompatImplBase();
        }
    }

    private LayoutInflaterCompat() {
    }

    public static void setFactory(LayoutInflater inflater, LayoutInflaterFactory factory) {
        IMPL.setFactory(inflater, factory);
    }

    public static LayoutInflaterFactory getFactory(LayoutInflater inflater) {
        return IMPL.getFactory(inflater);
    }
}
