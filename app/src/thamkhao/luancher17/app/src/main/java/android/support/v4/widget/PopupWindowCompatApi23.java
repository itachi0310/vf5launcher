package android.support.v4.widget;

import android.widget.PopupWindow;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupWindowCompatApi23.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class PopupWindowCompatApi23 {
    PopupWindowCompatApi23() {
    }

    static void setOverlapAnchor(PopupWindow popupWindow, boolean overlapAnchor) {
        popupWindow.setOverlapAnchor(overlapAnchor);
    }

    static boolean getOverlapAnchor(PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }

    static void setWindowLayoutType(PopupWindow popupWindow, int layoutType) {
        popupWindow.setWindowLayoutType(layoutType);
    }

    static int getWindowLayoutType(PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }
}
