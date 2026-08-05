package android.support.v4.widget;

import android.view.View;
import android.widget.ListPopupWindow;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/ListPopupWindowCompatKitKat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ListPopupWindowCompatKitKat {
    ListPopupWindowCompatKitKat() {
    }

    public static View.OnTouchListener createDragToOpenListener(Object listPopupWindow, View src) {
        return ((ListPopupWindow) listPopupWindow).createDragToOpenListener(src);
    }
}
