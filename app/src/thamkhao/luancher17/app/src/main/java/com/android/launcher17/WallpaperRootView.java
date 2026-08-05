package com.android.launcher17;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes.dex */
public class WallpaperRootView extends RelativeLayout {
    private final WallpaperPickerActivity a;

    public WallpaperRootView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.a = (WallpaperPickerActivity) context;
    }

    public WallpaperRootView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.a = (WallpaperPickerActivity) context;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect insets) {
        this.a.setWallpaperStripYOffset(insets.bottom);
        return true;
    }
}
