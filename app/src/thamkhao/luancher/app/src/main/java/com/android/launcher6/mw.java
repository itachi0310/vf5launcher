package com.android.launcher6;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;

/* JADX INFO: loaded from: classes.dex */
public class mw extends nt {
    private ResolveInfo b;

    public mw(ResolveInfo resolveInfo) {
        this.b = resolveInfo;
    }

    @Override // com.android.launcher6.nt
    public void a(WallpaperPickerActivity wallpaperPickerActivity) {
        ComponentName componentName = new ComponentName(this.b.activityInfo.packageName, this.b.activityInfo.name);
        Intent intent = new Intent("android.intent.action.SET_WALLPAPER");
        intent.setComponent(componentName);
        my.a(wallpaperPickerActivity, intent, 6);
    }
}
