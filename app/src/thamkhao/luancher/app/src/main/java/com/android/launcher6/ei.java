package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class ei implements com.syu.f.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f200a;

    ei(Launcher launcher) {
        this.f200a = launcher;
    }

    @Override // com.syu.f.e
    public void a(int i, int[] iArr, float[] fArr, String[] strArr) {
        if (i == 1 && iArr != null && iArr.length > 0) {
            Launcher.U = iArr[0];
            if (iArr[0] > 5000) {
                int i2 = iArr[0];
                Launcher.S = this.f200a.g(i2);
                String strG = this.f200a.g(iArr[0]);
                String str = String.valueOf(strG.substring(0, strG.length() - 2)) + "." + strG.substring(strG.length() - 2, strG.length());
                Launcher.V = str;
                if (this.f200a.cQ != null) {
                    this.f200a.cQ.setText(str);
                }
                if (this.f200a.cZ != null) {
                    if (this.f200a.cZ.getBackground() != null) {
                        this.f200a.cZ.setBackgroundResource(a.b.a().be);
                    } else {
                        this.f200a.cZ.setText("FM");
                    }
                }
                if (this.f200a.da != null) {
                    this.f200a.da.setText("MHz");
                }
                if (this.f200a.dG != null) {
                    this.f200a.dG.a(i2, 8750, 10800);
                }
            } else if (iArr[0] < 5000 && iArr[0] > 500) {
                Launcher.S = this.f200a.g(iArr[0]);
                Launcher.V = Launcher.S;
                if (this.f200a.cQ != null) {
                    this.f200a.cQ.setText(Launcher.S);
                }
                if (this.f200a.cZ != null) {
                    if (this.f200a.cZ.getBackground() != null) {
                        this.f200a.cZ.setBackgroundResource(a.b.a().bf);
                    } else {
                        this.f200a.cZ.setText("AM");
                    }
                }
                if (this.f200a.da != null) {
                    this.f200a.da.setText("KHz");
                }
                if (this.f200a.dG != null) {
                    this.f200a.dG.a(iArr[0], 522, 1620);
                }
            }
        }
        com.syu.widget.a.l.a(LauncherApplication.f88a);
    }
}
