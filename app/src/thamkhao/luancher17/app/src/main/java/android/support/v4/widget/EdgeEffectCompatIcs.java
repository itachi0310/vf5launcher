package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/EdgeEffectCompatIcs.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class EdgeEffectCompatIcs {
    EdgeEffectCompatIcs() {
    }

    public static Object newEdgeEffect(Context context) {
        return new EdgeEffect(context);
    }

    public static void setSize(Object edgeEffect, int width, int height) {
        ((EdgeEffect) edgeEffect).setSize(width, height);
    }

    public static boolean isFinished(Object edgeEffect) {
        return ((EdgeEffect) edgeEffect).isFinished();
    }

    public static void finish(Object edgeEffect) {
        ((EdgeEffect) edgeEffect).finish();
    }

    public static boolean onPull(Object edgeEffect, float deltaDistance) {
        ((EdgeEffect) edgeEffect).onPull(deltaDistance);
        return true;
    }

    public static boolean onRelease(Object edgeEffect) {
        EdgeEffect eff = (EdgeEffect) edgeEffect;
        eff.onRelease();
        return eff.isFinished();
    }

    public static boolean onAbsorb(Object edgeEffect, int velocity) {
        ((EdgeEffect) edgeEffect).onAbsorb(velocity);
        return true;
    }

    public static boolean draw(Object edgeEffect, Canvas canvas) {
        return ((EdgeEffect) edgeEffect).draw(canvas);
    }
}
