package com.android.launcher6;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class dx implements View.OnKeyListener {
    dx() {
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return cm.c(view, i, keyEvent);
    }
}
