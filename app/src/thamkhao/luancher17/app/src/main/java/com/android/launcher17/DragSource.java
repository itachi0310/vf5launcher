package com.android.launcher17;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface DragSource {
    void onDropCompleted(View view, DropTarget.DragObject dragObject, boolean z, boolean z2);

    void onFlingToDeleteCompleted();

    boolean supportsFlingToDelete();
}
