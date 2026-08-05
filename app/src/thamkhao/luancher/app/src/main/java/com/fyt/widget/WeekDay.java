package com.fyt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class WeekDay extends XTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeekDay f491a;
    private Context b;

    public WeekDay(Context context) {
        super(context);
        a();
        this.b = context;
    }

    public WeekDay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
        a();
    }

    public WeekDay(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
        this.b = context;
    }

    public static WeekDay getWeekDay() {
        return f491a;
    }

    void a() {
        f491a = this;
    }

    public void b() {
        TextView textView = (TextView) findViewById(a.b.a().aY);
        if (textView != null) {
            textView.setText(com.syu.widget.a.a.a.d(this.b));
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
