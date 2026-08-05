package android.support.v4.widget;

import android.view.View;
import android.widget.PopupWindow;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupWindowCompatKitKat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class PopupWindowCompatKitKat {
    PopupWindowCompatKitKat() {
    }

    public static void showAsDropDown(PopupWindow popup, View anchor, int xoff, int yoff, int gravity) {
        popup.showAsDropDown(anchor, xoff, yoff, gravity);
    }
}
