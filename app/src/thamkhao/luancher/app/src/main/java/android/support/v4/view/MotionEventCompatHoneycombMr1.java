package android.support.v4.view;

import android.view.MotionEvent;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/MotionEventCompatHoneycombMr1.class */
class MotionEventCompatHoneycombMr1 {
    MotionEventCompatHoneycombMr1() {
    }

    static float getAxisValue(MotionEvent event, int axis) {
        return event.getAxisValue(axis);
    }

    static float getAxisValue(MotionEvent event, int axis, int pointerIndex) {
        return event.getAxisValue(axis, pointerIndex);
    }
}
