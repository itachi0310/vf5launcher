package com.android.b.c;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class j extends a {
    private final boolean h;
    private boolean i;

    @Override // com.android.b.c.a
    public boolean a() {
        return this.i;
    }

    @Override // com.android.b.c.a
    protected boolean b(c cVar) {
        if (i()) {
            return true;
        }
        Log.w("RawTexture", "lost the content due to context change");
        return false;
    }

    @Override // com.android.b.c.a
    protected int h() {
        return 3553;
    }

    @Override // com.android.b.c.k
    public boolean l() {
        return this.h;
    }
}
