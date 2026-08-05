package com.android.launcher6;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class w implements View.OnKeyListener {
    w() {
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return cm.a(view, i, keyEvent);
    }
}
