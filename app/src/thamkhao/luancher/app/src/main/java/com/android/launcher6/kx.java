package com.android.launcher6;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.text.Collator;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class kx implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Collator f364a = Collator.getInstance();
    final /* synthetic */ kw b;
    private final /* synthetic */ PackageManager c;

    kx(kw kwVar, PackageManager packageManager) {
        this.b = kwVar;
        this.c = packageManager;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
        return this.f364a.compare(resolveInfo.loadLabel(this.c), resolveInfo2.loadLabel(this.c));
    }
}
