package com.android.launcher6;

import java.text.Collator;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class jd implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Collator f325a;

    jd(Collator collator) {
        this.f325a = collator;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compare(d dVar, d dVar2) {
        int iCompare = this.f325a.compare(dVar.q.toString().trim(), dVar2.q.toString().trim());
        return iCompare == 0 ? dVar.d.compareTo(dVar2.d) : iCompare;
    }
}
