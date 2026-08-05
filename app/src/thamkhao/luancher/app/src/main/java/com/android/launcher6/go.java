package com.android.launcher6;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class go implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f260a;

    go(Launcher launcher) {
        this.f260a = launcher;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) != 0) {
            return false;
        }
        view.performHapticFeedback(1);
        return false;
    }
}
