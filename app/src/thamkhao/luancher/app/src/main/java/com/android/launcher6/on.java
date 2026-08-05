package com.android.launcher6;

import android.content.ComponentName;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
class on implements jo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Workspace f441a;
    private final /* synthetic */ HashSet b;
    private final /* synthetic */ HashSet c;

    on(Workspace workspace, HashSet hashSet, HashSet hashSet2) {
        this.f441a = workspace;
        this.b = hashSet;
        this.c = hashSet2;
    }

    @Override // com.android.launcher6.jo
    public boolean a(ec ecVar, ec ecVar2, ComponentName componentName) {
        if (!this.b.contains(componentName.getPackageName())) {
            return false;
        }
        this.c.add(componentName);
        return true;
    }
}
