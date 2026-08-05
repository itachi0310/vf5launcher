package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class ej implements com.fyt.car.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f201a;

    ej(Launcher launcher) {
        this.f201a = launcher;
    }

    @Override // com.fyt.car.b
    public void a(int[] iArr, long[] jArr, float[] fArr, String[] strArr, byte[] bArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.f201a.dF = strArr[0];
        if (this.f201a.dC == null || this.f201a.dF == null) {
            return;
        }
        if ("true".equals(this.f201a.dF)) {
            this.f201a.dC.setBackgroundResource(a.b.a().ae);
        } else if ("false".equals(this.f201a.dF)) {
            this.f201a.dC.setBackgroundResource(a.b.a().ad);
        }
    }
}
