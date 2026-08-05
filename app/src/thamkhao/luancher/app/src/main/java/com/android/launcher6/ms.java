package com.android.launcher6;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes.dex */
abstract class ms {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadLocal f399a = new ThreadLocal();

    public void a(Object obj) {
        this.f399a.set(new SoftReference(obj));
    }

    abstract Object b();

    public Object c() {
        SoftReference softReference = (SoftReference) this.f399a.get();
        if (softReference == null) {
            Object objB = b();
            this.f399a.set(new SoftReference(objB));
            return objB;
        }
        Object obj = softReference.get();
        if (obj != null) {
            return obj;
        }
        Object objB2 = b();
        this.f399a.set(new SoftReference(objB2));
        return objB2;
    }
}
