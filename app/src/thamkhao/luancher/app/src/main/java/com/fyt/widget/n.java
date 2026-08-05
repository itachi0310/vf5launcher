package com.fyt.widget;

import android.content.Context;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class n extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static n f504a;
    private Context b;

    public static n getYear() {
        return f504a;
    }

    public void a() {
        setText(com.syu.widget.a.a.a.a(this.b, "yyyy"));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
