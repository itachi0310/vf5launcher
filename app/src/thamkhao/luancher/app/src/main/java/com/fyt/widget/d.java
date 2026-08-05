package com.fyt.widget;

import android.content.Context;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class d extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f495a;
    private Context b;

    public static d getDay() {
        return f495a;
    }

    public void a() {
        setText(com.syu.widget.a.a.a.a(this.b, "dd"));
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
