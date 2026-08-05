package com.android.launcher6;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class du implements View.OnKeyListener {
    du() {
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return cm.a(view, i, keyEvent, view.getResources().getConfiguration().orientation);
    }
}
