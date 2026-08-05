package com.android.launcher6;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class ee implements com.syu.f.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f196a;

    ee(Launcher launcher) {
        this.f196a = launcher;
    }

    @Override // com.syu.f.e
    public void a(int i, int[] iArr, float[] fArr, String[] strArr) {
        if (i == 0) {
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            if (this.f196a.aB != null) {
                if (iArr[0] == 1) {
                    this.f196a.aB.setBackgroundResource(R.drawable.radio_playpause_icon);
                } else {
                    this.f196a.aB.setBackgroundResource(R.drawable.radio_pause_icon);
                }
            }
            if (com.syu.g.l.b().getBoolean(R.bool.worksapce_switch_widget)) {
                switch (iArr[0]) {
                    case 1:
                        if (this.f196a.dR != null && this.f196a.dR.getVisibility() != 0) {
                            this.f196a.dR.setVisibility(0);
                        }
                        if (this.f196a.dQ != null) {
                            this.f196a.dQ.setVisibility(8);
                        }
                        break;
                    case 8:
                        if (this.f196a.dQ != null && this.f196a.dQ.getVisibility() != 0) {
                            this.f196a.dQ.setVisibility(0);
                        }
                        if (this.f196a.dR != null) {
                            this.f196a.dR.setVisibility(8);
                        }
                        break;
                    default:
                        if (this.f196a.dQ != null && this.f196a.dQ.getVisibility() != 0) {
                            this.f196a.dQ.setVisibility(0);
                        }
                        if (this.f196a.dR != null) {
                            this.f196a.dR.setVisibility(8);
                        }
                        break;
                }
                return;
            }
            return;
        }
        if (i == 50) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                return;
            }
            if (this.f196a.aO != null && this.f196a.aP != null) {
                this.f196a.aO.setVisibility(0);
                this.f196a.aP.setVisibility(8);
            }
            if (this.f196a.aQ != null) {
                this.f196a.aQ.setImageResource(a.b.a().d);
            }
            if (this.f196a.bb != null) {
                this.f196a.bb.setText("");
            }
            if (this.f196a.aW != null) {
                this.f196a.aW.setText(com.syu.g.l.b("car_distance"));
            }
            if (this.f196a.aX != null) {
                this.f196a.aX.setText("0");
            }
            if (this.f196a.be != null) {
                this.f196a.be.setText(com.syu.g.l.b("surplus_distance"));
            }
            if (this.f196a.aY != null) {
                this.f196a.aY.setText("");
            }
            if (this.f196a.bc != null) {
                this.f196a.bc.setText(com.syu.g.l.b("remaintime"));
            }
            if (this.f196a.ba != null) {
                this.f196a.ba.setText(com.syu.g.l.b("car_realnavi"));
            }
            if (this.f196a.aV != null) {
                this.f196a.aV.setVisibility(0);
            }
            if (this.f196a.bf != null) {
                this.f196a.bf.setText("0");
                return;
            }
            return;
        }
        if (i == 4) {
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            Launcher.L = iArr[0] == 1;
            if (Launcher.L) {
                com.fyt.b.g.a(com.syu.g.l.a().a());
            } else {
                com.fyt.b.g.e();
            }
            this.f196a.i();
            return;
        }
        if (i == 101) {
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            this.f196a.J = iArr[0];
            Log.i("hy", "carSpeed:" + this.f196a.J);
            if (this.f196a.J == 1) {
                this.f196a.J = 0;
            }
            if (this.f196a.bd != null) {
                this.f196a.bd.setText(String.valueOf(LauncherApplication.f88a.getResources().getString(R.string.car_speed)) + this.f196a.J);
                return;
            }
            return;
        }
        if (i == 1000) {
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            int i2 = iArr[0];
            return;
        }
        if (i != 31 || iArr == null || iArr.length <= 0) {
            return;
        }
        this.f196a.cO = iArr[0];
    }
}
