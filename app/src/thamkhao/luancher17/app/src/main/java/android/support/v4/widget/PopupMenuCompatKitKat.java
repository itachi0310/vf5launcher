package android.support.v4.widget;

import android.view.View;
import android.widget.PopupMenu;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupMenuCompatKitKat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class PopupMenuCompatKitKat {
    PopupMenuCompatKitKat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object popupMenu) {
        return ((PopupMenu) popupMenu).getDragToOpenListener();
    }
}
