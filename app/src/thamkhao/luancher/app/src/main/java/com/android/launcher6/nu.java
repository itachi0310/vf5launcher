package com.android.launcher6;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;

/* JADX INFO: loaded from: classes.dex */
class nu extends LevelListDrawable {
    public nu(Drawable drawable) {
        addLevel(0, 0, drawable);
        setLevel(0);
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        rect.set(0, 0, 0, 0);
        return true;
    }
}
