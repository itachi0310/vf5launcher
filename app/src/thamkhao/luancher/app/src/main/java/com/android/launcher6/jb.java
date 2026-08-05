package com.android.launcher6;

import android.content.ComponentName;

/* JADX INFO: loaded from: classes.dex */
class jb implements jo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ iv f323a;
    private final /* synthetic */ String b;

    jb(iv ivVar, String str) {
        this.f323a = ivVar;
        this.b = str;
    }

    @Override // com.android.launcher6.jo
    public boolean a(ec ecVar, ec ecVar2, ComponentName componentName) {
        return componentName.getPackageName().equals(this.b);
    }
}
