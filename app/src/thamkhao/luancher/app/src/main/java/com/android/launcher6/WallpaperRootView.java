package com.android.launcher6;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes.dex */
public class WallpaperRootView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WallpaperPickerActivity f99a;

    public WallpaperRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f99a = (WallpaperPickerActivity) context;
    }

    public WallpaperRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f99a = (WallpaperPickerActivity) context;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        this.f99a.a(rect.bottom);
        return true;
    }
}
