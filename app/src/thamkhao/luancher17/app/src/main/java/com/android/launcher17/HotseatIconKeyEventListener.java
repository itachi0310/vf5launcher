package com.android.launcher17;

import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: compiled from: FocusHelper.java */
/* JADX INFO: loaded from: classes.dex */
class HotseatIconKeyEventListener implements View.OnKeyListener {
    HotseatIconKeyEventListener() {
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        Configuration configuration = v.getResources().getConfiguration();
        return FocusHelper.handleHotseatButtonKeyEvent(v, keyCode, event, configuration.orientation);
    }
}
