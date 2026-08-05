package com.android.launcher17;

import android.graphics.Paint;

/* JADX INFO: compiled from: WidgetPreviewLoader.java */
/* JADX INFO: loaded from: classes.dex */
class PaintCache extends SoftReferenceThreadLocal<Paint> {
    PaintCache() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.launcher17.SoftReferenceThreadLocal
    public Paint initialValue() {
        return null;
    }
}
