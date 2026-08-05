package com.android.launcher17;

import android.graphics.Rect;

/* JADX INFO: compiled from: WidgetPreviewLoader.java */
/* JADX INFO: loaded from: classes.dex */
class RectCache extends SoftReferenceThreadLocal<Rect> {
    RectCache() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.launcher17.SoftReferenceThreadLocal
    public Rect initialValue() {
        return new Rect();
    }
}
