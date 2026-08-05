package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class eh implements com.syu.f.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f199a;

    eh(Launcher launcher) {
        this.f199a = launcher;
    }

    @Override // com.syu.f.e
    public void a(int i, int[] iArr, float[] fArr, String[] strArr) {
        if (i != 0 || iArr == null || iArr.length <= 0) {
            return;
        }
        int i2 = iArr[0];
        if (i2 == 65536 || i2 == 65537 || i2 == 65538) {
            this.f199a.eb = 0;
        } else if (i2 == 0 || i2 == 1) {
            this.f199a.eb = 1;
        }
    }
}
