package com.android.launcher6;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class ix implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ContentResolver f318a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ ContentValues c;
    private final /* synthetic */ ec d;

    ix(ContentResolver contentResolver, boolean z, ContentValues contentValues, ec ecVar) {
        this.f318a = contentResolver;
        this.b = z;
        this.c = contentValues;
        this.d = ecVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f318a.insert(this.b ? kq.f358a : kq.c, this.c);
        synchronized (iv.c) {
            iv.a(this.d.f, this.d, (StackTraceElement[]) null);
            iv.d.put(Long.valueOf(this.d.f), this.d);
            switch (this.d.g) {
                case 2:
                    iv.g.put(Long.valueOf(this.d.f), (dg) this.d);
                case 0:
                case 1:
                    if (this.d.h == -100 || this.d.h == -101) {
                        iv.e.add(this.d);
                    } else if (!iv.g.containsKey(Long.valueOf(this.d.h))) {
                        Log.e("Launcher.Model", "adding item: " + this.d + " to a folder that  doesn't exist");
                    }
                    break;
                case 4:
                    iv.f.add((it) this.d);
                    break;
            }
        }
    }
}
