package com.fyt.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.android.launcher6.LauncherApplication;
import com.android.launcher6.R;

/* JADX INFO: loaded from: classes.dex */
public class Date extends XTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Date f487a;
    private Context b;

    public Date(Context context) {
        super(context);
        a();
        this.b = context;
    }

    public Date(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = context;
        a();
    }

    public Date(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
        this.b = context;
    }

    private String a(int i) {
        switch (i) {
            case 0:
                return "yyyy-MM-dd";
            case 1:
                return "yyyy/MM/dd";
            case 2:
                return "yyyy.MM.dd";
            case 3:
                return "yyyy - MM - dd";
            case 4:
                return "MM月dd日";
            case 5:
                return "yyyy年MM月dd日";
            default:
                return "yyyy/MM/dd";
        }
    }

    public static Date getDate() {
        return f487a;
    }

    void a() {
        f487a = this;
    }

    public void b() {
        setText(com.syu.widget.a.a.a.a(this.b, a(LauncherApplication.f88a.getResources().getInteger(R.integer.apps_timewidget_show))));
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
