package com.android.launcher6;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class ju implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jp f339a;

    ju(jp jpVar) {
        this.f339a = jpVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ec ecVar, ec ecVar2) {
        return (int) (ecVar.h - ecVar2.h);
    }
}
