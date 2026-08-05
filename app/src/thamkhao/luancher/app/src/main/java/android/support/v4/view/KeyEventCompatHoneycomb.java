package android.support.v4.view;

import android.view.KeyEvent;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/KeyEventCompatHoneycomb.class */
class KeyEventCompatHoneycomb {
    KeyEventCompatHoneycomb() {
    }

    public static int normalizeMetaState(int metaState) {
        return KeyEvent.normalizeMetaState(metaState);
    }

    public static boolean metaStateHasModifiers(int metaState, int modifiers) {
        return KeyEvent.metaStateHasModifiers(metaState, modifiers);
    }

    public static boolean metaStateHasNoModifiers(int metaState) {
        return KeyEvent.metaStateHasNoModifiers(metaState);
    }
}
