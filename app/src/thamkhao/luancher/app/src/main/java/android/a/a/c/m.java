package android.a.a.c;

import android.os.Build;
import android.view.VelocityTracker;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final p f18a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f18a = new o();
        } else {
            f18a = new n();
        }
    }

    public static float a(VelocityTracker velocityTracker, int i) {
        return f18a.a(velocityTracker, i);
    }
}
