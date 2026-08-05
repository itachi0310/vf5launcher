package com.android.launcher6;

import android.graphics.PointF;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class bm implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bl f136a;
    private final /* synthetic */ PointF b;

    bm(bl blVar, PointF pointF) {
        this.f136a = blVar;
        this.b = pointF;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(bn bnVar, bn bnVar2) {
        return (int) (this.f136a.a(this.b, bnVar.d) - this.f136a.a(this.b, bnVar2.d));
    }
}
