package android.support.v4.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/hardware/display/DisplayManagerJellybeanMr1.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
final class DisplayManagerJellybeanMr1 {
    DisplayManagerJellybeanMr1() {
    }

    public static Object getDisplayManager(Context context) {
        return context.getSystemService("display");
    }

    public static Display getDisplay(Object displayManagerObj, int displayId) {
        return ((DisplayManager) displayManagerObj).getDisplay(displayId);
    }

    public static Display[] getDisplays(Object displayManagerObj) {
        return ((DisplayManager) displayManagerObj).getDisplays();
    }

    public static Display[] getDisplays(Object displayManagerObj, String category) {
        return ((DisplayManager) displayManagerObj).getDisplays(category);
    }
}
