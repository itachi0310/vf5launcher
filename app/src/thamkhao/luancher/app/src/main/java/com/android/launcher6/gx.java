package com.android.launcher6;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class gx implements com.fyt.car.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f269a;

    gx(Launcher launcher) {
        this.f269a = launcher;
    }

    @Override // com.fyt.car.b
    public void a(int[] iArr, long[] jArr, float[] fArr, String[] strArr, byte[] bArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        int i = iArr[0];
        if (i == 1) {
            if (this.f269a.bx.get("WS_Dvr_Rec") != null) {
                ((View) this.f269a.bx.get("WS_Dvr_Rec")).setBackgroundResource(a.b.a().dK);
            }
        } else {
            if (i != 0 || this.f269a.bx.get("WS_Dvr_Rec") == null) {
                return;
            }
            ((View) this.f269a.bx.get("WS_Dvr_Rec")).setBackgroundResource(a.b.a().dL);
        }
    }
}
