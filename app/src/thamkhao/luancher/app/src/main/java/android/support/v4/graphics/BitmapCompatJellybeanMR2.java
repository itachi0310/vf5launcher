package android.support.v4.graphics;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/graphics/BitmapCompatJellybeanMR2.class */
class BitmapCompatJellybeanMR2 {
    BitmapCompatJellybeanMR2() {
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    public static void setHasMipMap(Bitmap bitmap, boolean hasMipMap) {
        bitmap.setHasMipMap(hasMipMap);
    }
}
