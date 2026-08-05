package com.android.launcher6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: loaded from: classes.dex */
class eg implements com.fyt.car.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f198a;

    eg(Launcher launcher) {
        this.f198a = launcher;
    }

    @Override // com.fyt.car.b
    public void a(int[] iArr, long[] jArr, float[] fArr, String[] strArr, byte[] bArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (strArr == null || strArr.length <= 4) {
            str = "";
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
        } else {
            String str6 = strArr[0];
            String str7 = strArr[1];
            str = str6;
            str2 = strArr[2];
            str3 = str7;
            str4 = strArr[3];
            str5 = strArr[4];
        }
        String strSubstring = (str5 == null || str5.lastIndexOf("/") < 0) ? null : str5.substring(str5.lastIndexOf("/") + 1);
        if (!str.equals(this.f198a.R) && this.f198a.N != null) {
            this.f198a.R = str;
            byte[] bArr2 = new com.syu.g.k().a(str5).d;
            if (bArr2 == null || bArr2.length <= 0) {
                this.f198a.Q = null;
                this.f198a.N.setImageResource(a.b.a().ag);
            } else {
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
                if (bitmapDecodeByteArray != null) {
                    if (LauncherApplication.f88a.getResources().getBoolean(R.bool.music_bitmap_circular)) {
                        bitmapDecodeByteArray = com.syu.g.l.a("isRoundedCorner") ? Launcher.b(bitmapDecodeByteArray) : Launcher.a(bitmapDecodeByteArray);
                    }
                    this.f198a.N.setImageDrawable(new BitmapDrawable(bitmapDecodeByteArray));
                }
            }
        }
        if (!"true".equals(str2)) {
            if (com.syu.a.a.g != 8) {
                com.syu.g.l.a(this.f198a.cR, R.string.music_name);
                com.syu.g.l.a(this.f198a.cX, R.string.music_author);
                com.syu.g.l.a(this.f198a.cW, R.string.music_name);
                com.syu.g.l.a(this.f198a.cS, "00:00");
                com.syu.g.l.a(this.f198a.cT, "00:00");
                if (this.f198a.dH != null) {
                    this.f198a.dH.setProgress(0);
                }
                if (this.f198a.dI != null) {
                    this.f198a.dI.setProgress(0);
                }
                if (this.f198a.dx != null) {
                    this.f198a.dx.setBackground(com.fyt.b.g.a(a.b.a().ad));
                    return;
                }
                return;
            }
            if (this.f198a.O != null) {
                ((AnimationDrawable) this.f198a.O.getDrawable()).selectDrawable(0);
                ((AnimationDrawable) this.f198a.O.getDrawable()).stop();
            }
            if (this.f198a.P != null) {
                ((AnimationDrawable) this.f198a.P.getDrawable()).selectDrawable(0);
                ((AnimationDrawable) this.f198a.P.getDrawable()).stop();
            }
            if (this.f198a.dx != null) {
                this.f198a.dx.setBackground(com.fyt.b.g.a(a.b.a().ad));
            }
            if (this.f198a.dy != null) {
                this.f198a.dy.setBackgroundResource(a.b.a().ad);
            }
            if (strSubstring != null && !strSubstring.equals("") && !strSubstring.trim().equals("")) {
                if (this.f198a.cR != null) {
                    this.f198a.cR.setText(strSubstring);
                }
                if (this.f198a.cW != null) {
                    this.f198a.cW.setText(strSubstring);
                }
            }
            if (str3 == null || str3.equals("") || str3.trim().equals("") || this.f198a.cX == null) {
                return;
            }
            this.f198a.cX.setText(str3);
            return;
        }
        if (this.f198a.O != null) {
            ((AnimationDrawable) this.f198a.O.getDrawable()).start();
        }
        if (this.f198a.P != null) {
            ((AnimationDrawable) this.f198a.P.getDrawable()).start();
        }
        if (this.f198a.dx != null) {
            this.f198a.dx.setBackground(com.fyt.b.g.a(a.b.a().ae));
        }
        if (this.f198a.dy != null) {
            this.f198a.dy.setBackgroundResource(a.b.a().ae);
        }
        if (strSubstring != null && !strSubstring.equals("") && !strSubstring.trim().equals("")) {
            if (this.f198a.cR != null) {
                this.f198a.cR.setText(strSubstring);
            }
            if (this.f198a.cW != null) {
                this.f198a.cW.setText(strSubstring);
            }
        }
        if (str3 != null && !str3.equals("") && !str3.trim().equals("") && this.f198a.cX != null) {
            this.f198a.cX.setText(str3);
        }
        if (str4 != null && !str4.equals("") && !str4.trim().equals("") && this.f198a.cY != null) {
            this.f198a.cY.setText(str4);
        }
        if (jArr == null || jArr.length <= 1) {
            return;
        }
        long j = jArr[1];
        long j2 = jArr[0];
        if (j2 > 0) {
            if (j < 0) {
                j = 0;
            }
            int i = (int) ((1000 * j) / j2);
            if (i < 5) {
                if (this.f198a.dH != null) {
                    this.f198a.dH.setProgress(5);
                }
                if (this.f198a.dI != null) {
                    this.f198a.dI.setProgress(i);
                }
            } else {
                if (this.f198a.dH != null) {
                    this.f198a.dH.setProgress(i);
                }
                if (this.f198a.dI != null) {
                    this.f198a.dI.setProgress(i);
                }
            }
        }
        String strA = this.f198a.a(j);
        String strA2 = this.f198a.a(j2);
        if (this.f198a.cS != null && strA != null) {
            this.f198a.cS.setText(strA);
        }
        if (this.f198a.cT == null || strA2 == null) {
            return;
        }
        this.f198a.cT.setText(strA2);
    }
}
