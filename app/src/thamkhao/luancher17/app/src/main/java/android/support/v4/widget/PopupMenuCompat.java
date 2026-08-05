package android.support.v4.widget;

import android.os.Build;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupMenuCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class PopupMenuCompat {
    static final PopupMenuImpl IMPL;

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupMenuCompat$PopupMenuImpl.class
  classes.dex
 */
    interface PopupMenuImpl {
        View.OnTouchListener getDragToOpenListener(Object obj);
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupMenuCompat$BasePopupMenuImpl.class
  classes.dex
 */
    static class BasePopupMenuImpl implements PopupMenuImpl {
        BasePopupMenuImpl() {
        }

        @Override // android.support.v4.widget.PopupMenuCompat.PopupMenuImpl
        public View.OnTouchListener getDragToOpenListener(Object popupMenu) {
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupMenuCompat$KitKatPopupMenuImpl.class
  classes.dex
 */
    static class KitKatPopupMenuImpl extends BasePopupMenuImpl {
        KitKatPopupMenuImpl() {
        }

        @Override // android.support.v4.widget.PopupMenuCompat.BasePopupMenuImpl, android.support.v4.widget.PopupMenuCompat.PopupMenuImpl
        public View.OnTouchListener getDragToOpenListener(Object popupMenu) {
            return PopupMenuCompatKitKat.getDragToOpenListener(popupMenu);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 19) {
            IMPL = new KitKatPopupMenuImpl();
        } else {
            IMPL = new BasePopupMenuImpl();
        }
    }

    private PopupMenuCompat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object popupMenu) {
        return IMPL.getDragToOpenListener(popupMenu);
    }
}
