package com.syu.e;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class c implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f522a;

    c(a aVar) {
        this.f522a = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 4) {
            this.f522a.dismiss();
            return true;
        }
        this.f522a.f.start();
        return false;
    }
}
