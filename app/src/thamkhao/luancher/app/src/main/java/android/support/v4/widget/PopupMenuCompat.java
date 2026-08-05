package android.support.v4.widget;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupMenuCompat.class */
public final class PopupMenuCompat {
    static final PopupMenuImpl IMPL;

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupMenuCompat$PopupMenuImpl.class */
    interface PopupMenuImpl {
        View.OnTouchListener getDragToOpenListener(Object obj);
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupMenuCompat$BasePopupMenuImpl.class */
    static class BasePopupMenuImpl implements PopupMenuImpl {
        BasePopupMenuImpl() {
        }

        @Override // android.support.v4.widget.PopupMenuCompat.PopupMenuImpl
        public View.OnTouchListener getDragToOpenListener(Object popupMenu) {
            return null;
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupMenuCompat$KitKatPopupMenuImpl.class */
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
