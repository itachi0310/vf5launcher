package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/PopupWindowCompatGingerbread.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class PopupWindowCompatGingerbread {
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    PopupWindowCompatGingerbread() {
    }

    static void setWindowLayoutType(PopupWindow popupWindow, int layoutType) {
        if (!sSetWindowLayoutTypeMethodAttempted) {
            try {
                sSetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                sSetWindowLayoutTypeMethod.setAccessible(true);
            } catch (Exception e) {
            }
            sSetWindowLayoutTypeMethodAttempted = true;
        }
        if (sSetWindowLayoutTypeMethod != null) {
            try {
                sSetWindowLayoutTypeMethod.invoke(popupWindow, Integer.valueOf(layoutType));
            } catch (Exception e2) {
            }
        }
    }

    static int getWindowLayoutType(PopupWindow popupWindow) {
        if (!sGetWindowLayoutTypeMethodAttempted) {
            try {
                sGetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
                sGetWindowLayoutTypeMethod.setAccessible(true);
            } catch (Exception e) {
            }
            sGetWindowLayoutTypeMethodAttempted = true;
        }
        if (sGetWindowLayoutTypeMethod != null) {
            try {
                return ((Integer) sGetWindowLayoutTypeMethod.invoke(popupWindow, new Object[0])).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }
}
