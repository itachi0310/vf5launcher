package com.android.launcher6;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class jv implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ jp f340a;
    private final /* synthetic */ bl b;

    jv(jp jpVar, bl blVar) {
        this.f340a = jpVar;
        this.b = blVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ec ecVar, ec ecVar2) {
        int i = (int) this.b.e;
        int i2 = ((int) this.b.d) * i;
        int i3 = i2 * 6;
        return (int) (((((ecVar.h * ((long) i3)) + (ecVar.i * ((long) i2))) + ((long) (ecVar.k * i))) + ((long) ecVar.j)) - ((((long) (i * ecVar2.k)) + ((((long) i3) * ecVar2.h) + (ecVar2.i * ((long) i2)))) + ((long) ecVar2.j)));
    }
}
