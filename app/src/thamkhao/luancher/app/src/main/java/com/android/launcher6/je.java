package com.android.launcher6;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class je implements Comparator {
    je() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compare(d dVar, d dVar2) {
        if (dVar.c < dVar2.c) {
            return 1;
        }
        return dVar.c > dVar2.c ? -1 : 0;
    }
}
