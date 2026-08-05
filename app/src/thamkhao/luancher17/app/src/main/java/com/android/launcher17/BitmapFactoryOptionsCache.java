package com.android.launcher17;

import android.graphics.BitmapFactory;

/* JADX INFO: compiled from: WidgetPreviewLoader.java */
/* JADX INFO: loaded from: classes.dex */
class BitmapFactoryOptionsCache extends SoftReferenceThreadLocal<BitmapFactory.Options> {
    BitmapFactoryOptionsCache() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.launcher17.SoftReferenceThreadLocal
    public BitmapFactory.Options initialValue() {
        return new BitmapFactory.Options();
    }
}
