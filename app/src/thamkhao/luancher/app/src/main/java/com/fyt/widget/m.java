package com.fyt.widget;

import android.content.Context;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class m extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static m f503a;
    private Context b;

    public static m getWeekDay() {
        return f503a;
    }

    public void a() {
        setText(com.syu.widget.a.a.a.d(this.b));
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
