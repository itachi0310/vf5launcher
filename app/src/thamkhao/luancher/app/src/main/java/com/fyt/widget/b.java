package com.fyt.widget;

import android.content.Context;
import android.text.format.DateFormat;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class b extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f493a;

    public static b getClock() {
        return f493a;
    }

    public CharSequence a(Context context) {
        return new SimpleDateFormat(DateFormat.is24HourFormat(getContext()) ? "H:mm" : "h:mm").format(Calendar.getInstance().getTime());
    }

    public void a() {
        setText(a(getContext()));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        a();
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
