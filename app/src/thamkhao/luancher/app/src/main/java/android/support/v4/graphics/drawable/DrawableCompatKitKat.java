package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/graphics/drawable/DrawableCompatKitKat.class */
class DrawableCompatKitKat {
    DrawableCompatKitKat() {
    }

    public static void setAutoMirrored(Drawable drawable, boolean mirrored) {
        drawable.setAutoMirrored(mirrored);
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable wrapForTinting(Drawable drawable) {
        if (!(drawable instanceof DrawableWrapperKitKat)) {
            return new DrawableWrapperKitKat(drawable);
        }
        return drawable;
    }

    public static int getAlpha(Drawable drawable) {
        return drawable.getAlpha();
    }
}
