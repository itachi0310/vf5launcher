package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class dl implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ dk f180a;
    private final /* synthetic */ com.fyt.widget.a b;

    dl(dk dkVar, com.fyt.widget.a aVar) {
        this.f180a = dkVar;
        this.b = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            this.f180a.a(this.b.a());
        } catch (Exception e) {
        }
    }
}
