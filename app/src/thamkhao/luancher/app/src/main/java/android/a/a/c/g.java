package android.a.a.c;

import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final j f16a;

    static {
        if (Build.VERSION.SDK_INT >= 5) {
            f16a = new i();
        } else {
            f16a = new h();
        }
    }

    public static int a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int a(MotionEvent motionEvent, int i) {
        return f16a.a(motionEvent, i);
    }

    public static int b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public static int b(MotionEvent motionEvent, int i) {
        return f16a.b(motionEvent, i);
    }

    public static float c(MotionEvent motionEvent, int i) {
        return f16a.c(motionEvent, i);
    }

    public static float d(MotionEvent motionEvent, int i) {
        return f16a.d(motionEvent, i);
    }
}
