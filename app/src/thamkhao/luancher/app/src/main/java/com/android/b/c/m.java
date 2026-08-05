package com.android.b.c;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
class m implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f59a;
    public Bitmap.Config b;
    public int c;

    private m() {
    }

    /* synthetic */ m(m mVar) {
        this();
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public m clone() {
        try {
            return (m) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f59a == mVar.f59a && this.b == mVar.b && this.c == mVar.c;
    }

    public int hashCode() {
        int iHashCode = this.b.hashCode() ^ this.c;
        return this.f59a ? iHashCode : -iHashCode;
    }
}
