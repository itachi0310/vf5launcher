package com.android.launcher6;

import android.content.ComponentName;

/* JADX INFO: loaded from: classes.dex */
class jc implements jo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ iv f324a;
    private final /* synthetic */ ComponentName b;

    jc(iv ivVar, ComponentName componentName) {
        this.f324a = ivVar;
        this.b = componentName;
    }

    @Override // com.android.launcher6.jo
    public boolean a(ec ecVar, ec ecVar2, ComponentName componentName) {
        return componentName.equals(this.b);
    }
}
