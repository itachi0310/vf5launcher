package com.android.b.b;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f54a;
    private final long b;

    public m(long j, long j2) {
        this.f54a = j;
        this.b = j2;
    }

    public long a() {
        return this.f54a;
    }

    public long b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f54a == mVar.f54a && this.b == mVar.b;
    }

    public String toString() {
        return String.valueOf(this.f54a) + "/" + this.b;
    }
}
