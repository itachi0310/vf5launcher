package com.android.launcher6;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class eq implements com.syu.i.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f208a;

    eq(Launcher launcher) {
        this.f208a = launcher;
    }

    @Override // com.syu.i.m
    public void a(com.syu.i.d dVar) {
        if (dVar == null) {
            com.syu.d.a.b("manager == null");
            return;
        }
        com.syu.d.a.b("weatherCity:" + this.f208a.cz);
        Log.i("hy", "showWeatherInfoweatherImg" + this.f208a.cx);
        if (this.f208a.cx != null) {
            this.f208a.cx.setImageResource(com.syu.g.m.a(this.f208a.getApplicationContext(), dVar.b()));
        }
        String strReplaceAll = dVar.e().replaceAll("\\.\\d", "");
        String strReplaceAll2 = dVar.d().replaceAll("\\.\\d", "");
        if (this.f208a.cz != null) {
            this.f208a.cz.setText(new StringBuilder(String.valueOf(dVar.a())).toString());
        }
        if (this.f208a.cA != null) {
            this.f208a.cA.setText(new StringBuilder(String.valueOf(dVar.b())).toString());
        }
        if (this.f208a.cB != null) {
            this.f208a.cB.setText(new StringBuilder(String.valueOf(strReplaceAll2)).toString());
        }
        if (this.f208a.cD != null) {
            this.f208a.cD.setText(new StringBuilder(String.valueOf(strReplaceAll)).toString());
        }
        if (this.f208a.cy != null) {
            this.f208a.cy.setImageResource(com.syu.g.m.a(this.f208a.getApplicationContext(), dVar.b()));
        }
        if (this.f208a.cE != null) {
            this.f208a.cE.setText(new StringBuilder(String.valueOf(dVar.a())).toString());
        }
        if (this.f208a.cF != null) {
            this.f208a.cF.setText(new StringBuilder(String.valueOf(dVar.b())).toString());
        }
        if (this.f208a.cG != null) {
            this.f208a.cG.setText(new StringBuilder(String.valueOf(strReplaceAll2)).toString());
        }
        if (this.f208a.cH != null) {
            this.f208a.cH.setText(new StringBuilder(String.valueOf(strReplaceAll)).toString());
        }
        if (this.f208a.cC != null) {
            this.f208a.cC.setText(new StringBuilder(String.valueOf(dVar.c())).toString());
        }
    }
}
