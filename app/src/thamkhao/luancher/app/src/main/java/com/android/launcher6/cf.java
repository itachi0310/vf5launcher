package com.android.launcher6;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class cf implements bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f150a = 0;

    public cf(Context context) {
        ((Launcher) context).t().a(this);
    }

    void a() {
        this.f150a++;
        if (this.f150a != 1) {
            Log.e("DropTarget", "onDragEnter: Drag contract violated: " + this.f150a);
        }
    }

    @Override // com.android.launcher6.bp
    public void a(bz bzVar, Object obj, int i) {
        if (this.f150a != 0) {
            Log.e("DropTarget", "onDragEnter: Drag contract violated: " + this.f150a);
        }
    }

    @Override // com.android.launcher6.bp
    public void b() {
        if (this.f150a != 0) {
            Log.e("DropTarget", "onDragExit: Drag contract violated: " + this.f150a);
        }
    }

    void c() {
        this.f150a--;
        if (this.f150a != 0) {
            Log.e("DropTarget", "onDragExit: Drag contract violated: " + this.f150a);
        }
    }
}
