package com.android.launcher6;

import android.view.View;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class aq implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114a = 0;
    final /* synthetic */ ap b;

    aq(ap apVar) {
        this.b = apVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(View view, View view2) {
        ai aiVar = (ai) this.b.b.f108a.get(view);
        ai aiVar2 = (ai) this.b.b.f108a.get(view2);
        switch (this.f114a) {
            case 0:
                return (aiVar2.c + aiVar2.f106a) - (aiVar.c + aiVar.f106a);
            case 1:
                return (aiVar2.d + aiVar2.b) - (aiVar.d + aiVar.b);
            case 2:
                return aiVar.f106a - aiVar2.f106a;
            default:
                return aiVar.b - aiVar2.b;
        }
    }
}
