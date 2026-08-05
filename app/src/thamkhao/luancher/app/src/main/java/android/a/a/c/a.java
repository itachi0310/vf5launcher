package android.a.a.c;

import android.os.Build;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final e f10a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f10a = new d();
        } else {
            f10a = new b();
        }
    }

    public static boolean a(KeyEvent keyEvent) {
        return f10a.b(keyEvent.getMetaState());
    }

    public static boolean a(KeyEvent keyEvent, int i) {
        return f10a.a(keyEvent.getMetaState(), i);
    }
}
