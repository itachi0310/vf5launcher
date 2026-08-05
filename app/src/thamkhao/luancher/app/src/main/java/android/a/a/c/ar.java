package android.a.a.c;

import android.view.View;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class ar implements Comparator {
    ar() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(View view, View view2) {
        ak akVar = (ak) view.getLayoutParams();
        ak akVar2 = (ak) view2.getLayoutParams();
        if (akVar.f13a != akVar2.f13a) {
            return akVar.f13a ? 1 : -1;
        }
        return akVar.e - akVar2.e;
    }
}
