package android.support.v4.widget;

import android.widget.EdgeEffect;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/EdgeEffectCompatLollipop.class */
class EdgeEffectCompatLollipop {
    EdgeEffectCompatLollipop() {
    }

    public static boolean onPull(Object edgeEffect, float deltaDistance, float displacement) {
        ((EdgeEffect) edgeEffect).onPull(deltaDistance, displacement);
        return true;
    }
}
