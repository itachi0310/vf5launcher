package com.android.launcher6;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class di implements View.OnKeyListener {
    di() {
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return cm.d(view, i, keyEvent);
    }
}
