package com.android.launcher17;

import android.graphics.Canvas;

/* JADX INFO: compiled from: WidgetPreviewLoader.java */
/* JADX INFO: loaded from: classes.dex */
class CanvasCache extends SoftReferenceThreadLocal<Canvas> {
    CanvasCache() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.launcher17.SoftReferenceThreadLocal
    public Canvas initialValue() {
        return new Canvas();
    }
}
