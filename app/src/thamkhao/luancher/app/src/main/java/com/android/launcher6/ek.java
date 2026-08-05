package com.android.launcher6;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class ek implements com.syu.f.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f202a;

    ek(Launcher launcher) {
        this.f202a = launcher;
    }

    @Override // com.syu.f.e
    public void a(int i, int[] iArr, float[] fArr, String[] strArr) {
        if (i == 0) {
            if (strArr != null && strArr.length > 0) {
                Log.i("hy", "U_BTAV_ID3_TITLE:" + strArr[0]);
                Launcher.aa = strArr[0];
                if (this.f202a.ax != null) {
                    if (Launcher.aa == null || Launcher.aa.equals("")) {
                        this.f202a.ax.setText(R.string.car_bt_music);
                    } else {
                        this.f202a.ax.setText(Launcher.aa);
                    }
                }
            }
        } else if (i == 1) {
            if (strArr != null && strArr.length > 0) {
                Launcher.ab = strArr[0];
                if (this.f202a.ay != null) {
                    if (Launcher.ab == null || Launcher.ab.equals("")) {
                        this.f202a.ay.setText(R.string.music_author);
                    } else {
                        this.f202a.ay.setText(Launcher.ab);
                    }
                }
            }
        } else if (i == 26) {
            if (strArr != null && strArr.length > 0) {
                String str = strArr[0];
                if (this.f202a.az != null) {
                    if (str == null || str.equals("")) {
                        this.f202a.az.setText(R.string.music_album);
                    } else {
                        this.f202a.az.setText(str);
                    }
                }
            }
        } else if (i == 2) {
            if (iArr != null && iArr.length > 0) {
                Launcher.X = iArr[0];
                String strB = this.f202a.b(Launcher.X);
                if (this.f202a.cV != null) {
                    if (strB == null || strB.equals("")) {
                        this.f202a.cV.setText("00:00:00");
                    } else {
                        this.f202a.cV.setText(strB);
                    }
                }
            }
        } else if (i == 28) {
            if (iArr != null && iArr.length > 0) {
                Launcher.Y = iArr[0];
                String strB2 = this.f202a.b(Launcher.Y);
                if (this.f202a.cU != null) {
                    if (strB2 == null || strB2.equals("")) {
                        this.f202a.cU.setText("00:00:00");
                    } else {
                        this.f202a.cU.setText(strB2);
                    }
                }
                if (Launcher.X > 0) {
                    if (Launcher.Y < 0) {
                        Launcher.Y = 0;
                    }
                    int i2 = (Launcher.Y * 1000) / Launcher.X;
                    if (i2 < 5) {
                        if (this.f202a.dJ != null) {
                            this.f202a.dJ.setProgress(5);
                        }
                    } else if (this.f202a.dJ != null) {
                        this.f202a.dJ.setProgress(i2);
                    }
                } else if (this.f202a.dJ != null) {
                    this.f202a.dJ.setProgress(0);
                }
            }
        } else if (i == 13) {
            if (iArr != null && iArr.length > 0) {
                Launcher.ac = iArr[0];
                if (Launcher.ac == 1) {
                    if (this.f202a.aJ != null) {
                        this.f202a.aJ.setBackgroundResource(a.b.a().bI);
                    }
                } else if (this.f202a.aJ != null) {
                    this.f202a.aJ.setBackgroundResource(a.b.a().bH);
                }
            }
        } else if (i == 9) {
            if (iArr != null && iArr.length > 0) {
                Launcher.ad = iArr[0];
                if (iArr[0] == 0) {
                    this.f202a.Z = true;
                    if (this.f202a.dJ != null) {
                        this.f202a.dJ.setProgress(0);
                    }
                    if (this.f202a.cU != null) {
                        this.f202a.cU.setText("00:00:00");
                    }
                    if (this.f202a.cV != null) {
                        this.f202a.cV.setText("00:00:00");
                    }
                } else if (this.f202a.Z) {
                    this.f202a.H.a(2, 2, 28);
                    this.f202a.Z = false;
                }
            }
        } else if (i == 7 && strArr != null && strArr.length > 0) {
            String str2 = strArr[0];
            if (this.f202a.dh != null) {
                if (str2 == null || str2.equals("")) {
                    this.f202a.dh.setText(R.string.car_bt_notconnect);
                } else {
                    this.f202a.dh.setText(String.valueOf(this.f202a.getResources().getString(R.string.car_bt_connected)) + "\n" + str2);
                }
            }
        }
        com.syu.widget.a.l.a(LauncherApplication.f88a);
    }
}
