package android.a.a.c;

import android.database.DataSetObserver;

/* JADX INFO: loaded from: classes.dex */
class ao extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ af f14a;

    private ao(af afVar) {
        this.f14a = afVar;
    }

    /* synthetic */ ao(af afVar, ag agVar) {
        this(afVar);
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f14a.a();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f14a.a();
    }
}
