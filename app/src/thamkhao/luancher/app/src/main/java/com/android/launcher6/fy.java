package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class fy implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ fw f243a;

    fy(fw fwVar) {
        this.f243a = fwVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f243a.f241a.aO != null && this.f243a.f241a.aP != null) {
            this.f243a.f241a.aO.setVisibility(0);
            this.f243a.f241a.aP.setVisibility(8);
        }
        if (this.f243a.f241a.aQ != null) {
            this.f243a.f241a.aQ.setImageResource(a.b.a().d);
        }
        if (this.f243a.f241a.bb != null) {
            this.f243a.f241a.bb.setText("");
        }
        if (this.f243a.f241a.aW != null) {
            this.f243a.f241a.aW.setText(com.syu.g.l.b("car_distance"));
        }
        if (this.f243a.f241a.aX != null) {
            this.f243a.f241a.aX.setText("0");
        }
        if (this.f243a.f241a.be != null) {
            this.f243a.f241a.be.setText(com.syu.g.l.b("surplus_distance"));
        }
        if (this.f243a.f241a.aY != null) {
            this.f243a.f241a.aY.setText("");
        }
        if (this.f243a.f241a.aR != null) {
            this.f243a.f241a.aR.setVisibility(8);
        }
        if (this.f243a.f241a.bc != null) {
            this.f243a.f241a.bc.setText(com.syu.g.l.b("remaintime"));
        }
        if (this.f243a.f241a.ba != null) {
            this.f243a.f241a.ba.setText(com.syu.g.l.b("car_realnavi"));
        }
        if (this.f243a.f241a.aV != null) {
            this.f243a.f241a.aV.setVisibility(0);
        }
        if (this.f243a.f241a.bf != null) {
            this.f243a.f241a.bf.setText("0");
        }
    }
}
