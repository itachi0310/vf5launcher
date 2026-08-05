package com.fyt.widget;

import android.content.Context;
import android.widget.TextView;
import com.android.launcher6.LauncherApplication;
import com.android.launcher6.R;

/* JADX INFO: loaded from: classes.dex */
public class c extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f494a;
    private Context b;

    private String a(int i) {
        switch (i) {
            case 0:
                return "yyyy-MM-dd";
            case 1:
                return "yyyy/MM/dd";
            case 2:
                return "yyyy.MM.dd";
            case 3:
                return "yyyy年MM月dd日";
            default:
                return "yyyy/MM/dd";
        }
    }

    public static c getDate() {
        return f494a;
    }

    public void a() {
        com.syu.d.a.b("setDate");
        setText(com.syu.widget.a.a.a.a(this.b, a(LauncherApplication.f88a.getResources().getInteger(R.integer.apps_timewidget_show))));
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
