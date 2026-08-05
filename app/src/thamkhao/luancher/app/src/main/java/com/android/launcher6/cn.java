package com.android.launcher6;

import android.view.View;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class cn implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f157a;

    cn(int i) {
        this.f157a = i;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(View view, View view2) {
        al alVar = (al) view.getLayoutParams();
        al alVar2 = (al) view2.getLayoutParams();
        return (alVar.f109a + (alVar.b * this.f157a)) - (alVar2.f109a + (alVar2.b * this.f157a));
    }
}
