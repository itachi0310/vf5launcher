package com.android.launcher6;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class cv implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f165a;
    final /* synthetic */ Folder b;

    public cv(Folder folder, int i) {
        this.b = folder;
        this.f165a = i;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(mp mpVar, mp mpVar2) {
        return ((mpVar.k * this.f165a) + mpVar.j) - ((mpVar2.k * this.f165a) + mpVar2.j);
    }
}
