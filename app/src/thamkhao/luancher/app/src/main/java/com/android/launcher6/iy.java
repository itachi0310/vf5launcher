package com.android.launcher6;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class iy implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ContentResolver f319a;
    private final /* synthetic */ Uri b;
    private final /* synthetic */ ec c;

    iy(ContentResolver contentResolver, Uri uri, ec ecVar) {
        this.f319a = contentResolver;
        this.b = uri;
        this.c = ecVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f319a.delete(this.b, null, null);
        synchronized (iv.c) {
            switch (this.c.g) {
                case 0:
                case 1:
                    iv.e.remove(this.c);
                    break;
                case 2:
                    iv.g.remove(Long.valueOf(this.c.f));
                    for (ec ecVar : iv.d.values()) {
                        if (ecVar.h == this.c.f) {
                            Log.e("Launcher.Model", "deleting a folder (" + this.c + ") which still contains items (" + ecVar + ")");
                        }
                    }
                    iv.e.remove(this.c);
                    break;
                case 4:
                    iv.f.remove((it) this.c);
                    break;
            }
            iv.d.remove(Long.valueOf(this.c.f));
            iv.h.remove(this.c);
        }
    }
}
