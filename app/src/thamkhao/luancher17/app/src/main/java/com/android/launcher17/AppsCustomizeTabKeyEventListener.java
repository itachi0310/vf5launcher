package com.android.launcher17;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: compiled from: FocusHelper.java */
/* JADX INFO: loaded from: classes.dex */
class AppsCustomizeTabKeyEventListener implements View.OnKeyListener {
    AppsCustomizeTabKeyEventListener() {
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return FocusHelper.handleAppsCustomizeTabKeyEvent(v, keyCode, event);
    }
}
