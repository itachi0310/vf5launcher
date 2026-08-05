package com.android.launcher6;

/* JADX INFO: loaded from: classes.dex */
class ns implements nf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ nr f421a;
    private final /* synthetic */ WallpaperPickerActivity b;

    ns(nr nrVar, WallpaperPickerActivity wallpaperPickerActivity) {
        this.f421a = nrVar;
        this.b = wallpaperPickerActivity;
    }

    @Override // com.android.launcher6.nf
    public void a(byte[] bArr) {
        this.b.f().a(WallpaperPickerActivity.b(WallpaperPickerActivity.b(this.b.getResources()), null, null, bArr, null, 0, 0, true), bArr);
    }
}
