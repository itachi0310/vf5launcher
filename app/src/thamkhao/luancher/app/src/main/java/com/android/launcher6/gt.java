package com.android.launcher6;

import android.content.Intent;
import android.view.View;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
class gt implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f265a;
    private final /* synthetic */ Intent b;

    gt(Launcher launcher, Intent intent) {
        this.f265a = launcher;
        this.b = intent;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f265a.a((Cling) this.f265a.findViewById(a.b.a().ec), (Runnable) new gu(this), this.b, HttpStatus.SC_OK, true);
        this.f265a.B();
        if (this.f265a.cr != null) {
            this.f265a.cr.setStayPressed(false);
        }
        if (this.f265a.bA != null) {
            this.f265a.bA.k();
        }
    }
}
