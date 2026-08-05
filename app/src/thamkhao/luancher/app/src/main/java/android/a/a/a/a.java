package android.a.a.a;

import android.os.Build;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static Parcelable.Creator a(c cVar) {
        if (Build.VERSION.SDK_INT >= 13) {
            e.a(cVar);
        }
        return new b(cVar);
    }
}
