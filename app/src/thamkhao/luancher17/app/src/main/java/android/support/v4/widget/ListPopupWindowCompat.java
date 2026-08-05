package android.support.v4.widget;

import android.os.Build;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/ListPopupWindowCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class ListPopupWindowCompat {
    static final ListPopupWindowImpl IMPL;

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/ListPopupWindowCompat$ListPopupWindowImpl.class
  classes.dex
 */
    interface ListPopupWindowImpl {
        View.OnTouchListener createDragToOpenListener(Object obj, View view);
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/ListPopupWindowCompat$BaseListPopupWindowImpl.class
  classes.dex
 */
    static class BaseListPopupWindowImpl implements ListPopupWindowImpl {
        BaseListPopupWindowImpl() {
        }

        @Override // android.support.v4.widget.ListPopupWindowCompat.ListPopupWindowImpl
        public View.OnTouchListener createDragToOpenListener(Object listPopupWindow, View src) {
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/ListPopupWindowCompat$KitKatListPopupWindowImpl.class
  classes.dex
 */
    static class KitKatListPopupWindowImpl extends BaseListPopupWindowImpl {
        KitKatListPopupWindowImpl() {
        }

        @Override // android.support.v4.widget.ListPopupWindowCompat.BaseListPopupWindowImpl, android.support.v4.widget.ListPopupWindowCompat.ListPopupWindowImpl
        public View.OnTouchListener createDragToOpenListener(Object listPopupWindow, View src) {
            return ListPopupWindowCompatKitKat.createDragToOpenListener(listPopupWindow, src);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 19) {
            IMPL = new KitKatListPopupWindowImpl();
        } else {
            IMPL = new BaseListPopupWindowImpl();
        }
    }

    private ListPopupWindowCompat() {
    }

    public static View.OnTouchListener createDragToOpenListener(Object listPopupWindow, View src) {
        return IMPL.createDragToOpenListener(listPopupWindow, src);
    }
}
