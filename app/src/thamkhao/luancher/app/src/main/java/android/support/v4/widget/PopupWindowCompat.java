package android.support.v4.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupWindowCompat.class */
public final class PopupWindowCompat {
    static final PopupWindowImpl IMPL;

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupWindowCompat$PopupWindowImpl.class */
    interface PopupWindowImpl {
        void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3);

        void setOverlapAnchor(PopupWindow popupWindow, boolean z);

        boolean getOverlapAnchor(PopupWindow popupWindow);

        void setWindowLayoutType(PopupWindow popupWindow, int i);

        int getWindowLayoutType(PopupWindow popupWindow);
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupWindowCompat$BasePopupWindowImpl.class */
    static class BasePopupWindowImpl implements PopupWindowImpl {
        BasePopupWindowImpl() {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public void showAsDropDown(PopupWindow popup, View anchor, int xoff, int yoff, int gravity) {
            popup.showAsDropDown(anchor, xoff, yoff);
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public void setOverlapAnchor(PopupWindow popupWindow, boolean overlapAnchor) {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            return false;
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public void setWindowLayoutType(PopupWindow popupWindow, int layoutType) {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public int getWindowLayoutType(PopupWindow popupWindow) {
            return 0;
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupWindowCompat$GingerbreadPopupWindowImpl.class */
    static class GingerbreadPopupWindowImpl extends BasePopupWindowImpl {
        GingerbreadPopupWindowImpl() {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.BasePopupWindowImpl, android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public void setWindowLayoutType(PopupWindow popupWindow, int layoutType) {
            PopupWindowCompatGingerbread.setWindowLayoutType(popupWindow, layoutType);
        }

        @Override // android.support.v4.widget.PopupWindowCompat.BasePopupWindowImpl, android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public int getWindowLayoutType(PopupWindow popupWindow) {
            return PopupWindowCompatGingerbread.getWindowLayoutType(popupWindow);
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupWindowCompat$KitKatPopupWindowImpl.class */
    static class KitKatPopupWindowImpl extends GingerbreadPopupWindowImpl {
        KitKatPopupWindowImpl() {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.BasePopupWindowImpl, android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public void showAsDropDown(PopupWindow popup, View anchor, int xoff, int yoff, int gravity) {
            PopupWindowCompatKitKat.showAsDropDown(popup, anchor, xoff, yoff, gravity);
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupWindowCompat$Api21PopupWindowImpl.class */
    static class Api21PopupWindowImpl extends KitKatPopupWindowImpl {
        Api21PopupWindowImpl() {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.BasePopupWindowImpl, android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public void setOverlapAnchor(PopupWindow popupWindow, boolean overlapAnchor) {
            PopupWindowCompatApi21.setOverlapAnchor(popupWindow, overlapAnchor);
        }

        @Override // android.support.v4.widget.PopupWindowCompat.BasePopupWindowImpl, android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            return PopupWindowCompatApi21.getOverlapAnchor(popupWindow);
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupWindowCompat$Api23PopupWindowImpl.class */
    static class Api23PopupWindowImpl extends Api21PopupWindowImpl {
        Api23PopupWindowImpl() {
        }

        @Override // android.support.v4.widget.PopupWindowCompat.Api21PopupWindowImpl, android.support.v4.widget.PopupWindowCompat.BasePopupWindowImpl, android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public void setOverlapAnchor(PopupWindow popupWindow, boolean overlapAnchor) {
            PopupWindowCompatApi23.setOverlapAnchor(popupWindow, overlapAnchor);
        }

        @Override // android.support.v4.widget.PopupWindowCompat.Api21PopupWindowImpl, android.support.v4.widget.PopupWindowCompat.BasePopupWindowImpl, android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            return PopupWindowCompatApi23.getOverlapAnchor(popupWindow);
        }

        @Override // android.support.v4.widget.PopupWindowCompat.GingerbreadPopupWindowImpl, android.support.v4.widget.PopupWindowCompat.BasePopupWindowImpl, android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public void setWindowLayoutType(PopupWindow popupWindow, int layoutType) {
            PopupWindowCompatApi23.setWindowLayoutType(popupWindow, layoutType);
        }

        @Override // android.support.v4.widget.PopupWindowCompat.GingerbreadPopupWindowImpl, android.support.v4.widget.PopupWindowCompat.BasePopupWindowImpl, android.support.v4.widget.PopupWindowCompat.PopupWindowImpl
        public int getWindowLayoutType(PopupWindow popupWindow) {
            return PopupWindowCompatApi23.getWindowLayoutType(popupWindow);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            IMPL = new Api23PopupWindowImpl();
            return;
        }
        if (version >= 21) {
            IMPL = new Api21PopupWindowImpl();
            return;
        }
        if (version >= 19) {
            IMPL = new KitKatPopupWindowImpl();
        } else if (version >= 9) {
            IMPL = new GingerbreadPopupWindowImpl();
        } else {
            IMPL = new BasePopupWindowImpl();
        }
    }

    private PopupWindowCompat() {
    }

    public static void showAsDropDown(PopupWindow popup, View anchor, int xoff, int yoff, int gravity) {
        IMPL.showAsDropDown(popup, anchor, xoff, yoff, gravity);
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean overlapAnchor) {
        IMPL.setOverlapAnchor(popupWindow, overlapAnchor);
    }

    public static boolean getOverlapAnchor(PopupWindow popupWindow) {
        return IMPL.getOverlapAnchor(popupWindow);
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int layoutType) {
        IMPL.setWindowLayoutType(popupWindow, layoutType);
    }

    public static int getWindowLayoutType(PopupWindow popupWindow) {
        return IMPL.getWindowLayoutType(popupWindow);
    }
}
