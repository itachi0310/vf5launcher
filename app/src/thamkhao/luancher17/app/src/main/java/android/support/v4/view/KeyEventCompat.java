package android.support.v4.view;

import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import com.syu.ipc.data.FinalCanbus;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/KeyEventCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class KeyEventCompat {
    static final KeyEventVersionImpl IMPL;

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/KeyEventCompat$KeyEventVersionImpl.class
  classes.dex
 */
    interface KeyEventVersionImpl {
        boolean dispatch(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2);

        Object getKeyDispatcherState(View view);

        boolean isTracking(KeyEvent keyEvent);

        boolean metaStateHasModifiers(int i, int i2);

        boolean metaStateHasNoModifiers(int i);

        int normalizeMetaState(int i);

        void startTracking(KeyEvent keyEvent);
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/KeyEventCompat$BaseKeyEventVersionImpl.class
  classes.dex
 */
    static class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        private static final int META_ALL_MASK = 247;
        private static final int META_MODIFIER_MASK = 247;

        BaseKeyEventVersionImpl() {
        }

        private static int metaStateFilterDirectionalModifiers(int metaState, int modifiers, int basic, int left, int right) {
            boolean wantBasic = (modifiers & basic) != 0;
            int directional = left | right;
            boolean wantLeftOrRight = (modifiers & directional) != 0;
            if (wantBasic) {
                if (wantLeftOrRight) {
                    throw new IllegalArgumentException("bad arguments");
                }
                return metaState & (directional ^ (-1));
            }
            if (wantLeftOrRight) {
                return metaState & (basic ^ (-1));
            }
            return metaState;
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public int normalizeMetaState(int metaState) {
            if ((metaState & FinalCanbus.CAR_WC2_15_BinZhi) != 0) {
                metaState |= 1;
            }
            if ((metaState & 48) != 0) {
                metaState |= 2;
            }
            return metaState & FinalCanbus.CAR_WC2_XueTieLongC3XR;
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasModifiers(int metaState, int modifiers) {
            return metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(normalizeMetaState(metaState) & FinalCanbus.CAR_WC2_XueTieLongC3XR, modifiers, 1, 64, 128), modifiers, 2, 16, 32) == modifiers;
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasNoModifiers(int metaState) {
            return (normalizeMetaState(metaState) & FinalCanbus.CAR_WC2_XueTieLongC3XR) == 0;
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public void startTracking(KeyEvent event) {
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean isTracking(KeyEvent event) {
            return false;
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public Object getKeyDispatcherState(View view) {
            return null;
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean dispatch(KeyEvent event, KeyEvent.Callback receiver, Object state, Object target) {
            return event.dispatch(receiver);
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/KeyEventCompat$EclairKeyEventVersionImpl.class
  classes.dex
 */
    static class EclairKeyEventVersionImpl extends BaseKeyEventVersionImpl {
        EclairKeyEventVersionImpl() {
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public void startTracking(KeyEvent event) {
            KeyEventCompatEclair.startTracking(event);
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean isTracking(KeyEvent event) {
            return KeyEventCompatEclair.isTracking(event);
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public Object getKeyDispatcherState(View view) {
            return KeyEventCompatEclair.getKeyDispatcherState(view);
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean dispatch(KeyEvent event, KeyEvent.Callback receiver, Object state, Object target) {
            return KeyEventCompatEclair.dispatch(event, receiver, state, target);
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/KeyEventCompat$HoneycombKeyEventVersionImpl.class
  classes.dex
 */
    static class HoneycombKeyEventVersionImpl extends EclairKeyEventVersionImpl {
        HoneycombKeyEventVersionImpl() {
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public int normalizeMetaState(int metaState) {
            return KeyEventCompatHoneycomb.normalizeMetaState(metaState);
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasModifiers(int metaState, int modifiers) {
            return KeyEventCompatHoneycomb.metaStateHasModifiers(metaState, modifiers);
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasNoModifiers(int metaState) {
            return KeyEventCompatHoneycomb.metaStateHasNoModifiers(metaState);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombKeyEventVersionImpl();
        } else {
            IMPL = new BaseKeyEventVersionImpl();
        }
    }

    public static int normalizeMetaState(int metaState) {
        return IMPL.normalizeMetaState(metaState);
    }

    public static boolean metaStateHasModifiers(int metaState, int modifiers) {
        return IMPL.metaStateHasModifiers(metaState, modifiers);
    }

    public static boolean metaStateHasNoModifiers(int metaState) {
        return IMPL.metaStateHasNoModifiers(metaState);
    }

    public static boolean hasModifiers(KeyEvent event, int modifiers) {
        return IMPL.metaStateHasModifiers(event.getMetaState(), modifiers);
    }

    public static boolean hasNoModifiers(KeyEvent event) {
        return IMPL.metaStateHasNoModifiers(event.getMetaState());
    }

    public static void startTracking(KeyEvent event) {
        IMPL.startTracking(event);
    }

    public static boolean isTracking(KeyEvent event) {
        return IMPL.isTracking(event);
    }

    public static Object getKeyDispatcherState(View view) {
        return IMPL.getKeyDispatcherState(view);
    }

    public static boolean dispatch(KeyEvent event, KeyEvent.Callback receiver, Object state, Object target) {
        return IMPL.dispatch(event, receiver, state, target);
    }

    private KeyEventCompat() {
    }
}
