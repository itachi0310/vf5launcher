package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class gj implements com.fyt.car.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f255a;

    gj(Launcher launcher) {
        this.f255a = launcher;
    }

    @Override // com.fyt.car.b
    public void a(int[] iArr, long[] jArr, float[] fArr, String[] strArr, byte[] bArr) {
        String str;
        String str2 = null;
        if (strArr == null || strArr.length <= 1) {
            str = null;
        } else {
            str = strArr[0];
            str2 = strArr[1];
        }
        if (str != null && !str.equals("") && !str.trim().equals("") && this.f255a.ax != null) {
            this.f255a.ax.setText(str);
        }
        if (str2 == null || str2.equals("") || this.f255a.ay == null) {
            return;
        }
        this.f255a.ay.setText(str2);
    }
}
