package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/graphics/drawable/DrawableCompatHoneycomb.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
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
