package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/graphics/drawable/DrawableCompatHoneycomb.class */
class DrawableCompatHoneycomb {
    DrawableCompatHoneycomb() {
    }

    public static void jumpToCurrentState(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable wrapForTinting(Drawable drawable) {
        if (!(drawable instanceof DrawableWrapperHoneycomb)) {
            return new DrawableWrapperHoneycomb(drawable);
        }
        return drawable;
    }
}
