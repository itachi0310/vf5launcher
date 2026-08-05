package android.support.v4.view;

import android.view.View;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/ViewCompatMarshmallow.class */
class ViewCompatMarshmallow {
    ViewCompatMarshmallow() {
    }

    public static void setScrollIndicators(View view, int indicators) {
        view.setScrollIndicators(indicators);
    }

    public static void setScrollIndicators(View view, int indicators, int mask) {
        view.setScrollIndicators(indicators, mask);
    }

    public static int getScrollIndicators(View view) {
        return view.getScrollIndicators();
    }

    static void offsetTopAndBottom(View view, int offset) {
        view.offsetTopAndBottom(offset);
    }

    static void offsetLeftAndRight(View view, int offset) {
        view.offsetLeftAndRight(offset);
    }
}
