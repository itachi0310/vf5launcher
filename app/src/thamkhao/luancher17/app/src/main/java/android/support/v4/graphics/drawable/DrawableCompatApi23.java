package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/graphics/drawable/DrawableCompatApi23.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class DrawableCompatApi23 {
    DrawableCompatApi23() {
    }

    public static void setLayoutDirection(Drawable drawable, int layoutDirection) {
        drawable.setLayoutDirection(layoutDirection);
    }

    public static int getLayoutDirection(Drawable drawable) {
        return drawable.getLayoutDirection();
    }
}
