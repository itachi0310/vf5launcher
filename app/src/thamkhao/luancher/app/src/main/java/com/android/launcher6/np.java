package com.android.launcher6;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class np extends nt {
    @Override // com.android.launcher6.nt
    public void a(WallpaperPickerActivity wallpaperPickerActivity) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        my.a(wallpaperPickerActivity, intent, 5);
    }
}
