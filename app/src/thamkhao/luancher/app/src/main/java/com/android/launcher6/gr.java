package com.android.launcher6;

import android.content.Intent;
import android.view.View;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
class gr implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f263a;
    private final /* synthetic */ Intent b;
    private final /* synthetic */ View c;
    private final /* synthetic */ Object d;

    gr(Launcher launcher, Intent intent, View view, Object obj) {
        this.f263a = launcher;
        this.b = intent;
        this.c = view;
        this.d = obj;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f263a.a((Cling) this.f263a.findViewById(a.b.a().ec), (Runnable) new gs(this), this.b, HttpStatus.SC_OK, true);
        this.f263a.af = this.f263a.c(this.c, this.b, this.d);
        this.f263a.B();
    }
}
