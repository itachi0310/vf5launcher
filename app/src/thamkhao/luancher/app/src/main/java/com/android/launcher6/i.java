package com.android.launcher6;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class i extends CellLayout implements lg {
    public i(Context context) {
        super(context);
    }

    @Override // com.android.launcher6.lg
    public void a() {
        removeAllViews();
        setLayerType(0, null);
    }

    public void b() {
        mo shortcutsAndWidgets = getShortcutsAndWidgets();
        int childCount = shortcutsAndWidgets.getChildCount();
        for (int i = 0; i < childCount; i++) {
            shortcutsAndWidgets.getChildAt(i).setOnKeyListener(null);
        }
    }

    @Override // com.android.launcher6.lg
    public int getPageChildCount() {
        return getChildCount();
    }
}
