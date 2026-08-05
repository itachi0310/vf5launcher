package com.fyt.widget;

import android.content.Context;
import android.widget.TextView;
import com.android.launcher6.R;

/* JADX INFO: loaded from: classes.dex */
public class j extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static j f501a;
    private Context b;

    public static j getMonth() {
        return f501a;
    }

    public void a() {
        setText(getResources().getStringArray(R.array.months)[Integer.valueOf(com.syu.widget.a.a.a.a(this.b, "MM")).intValue() - 1]);
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
