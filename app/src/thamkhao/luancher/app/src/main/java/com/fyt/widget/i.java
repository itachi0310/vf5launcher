package com.fyt.widget;

import android.content.Context;
import android.text.format.DateFormat;
import android.widget.TextView;
import com.android.launcher6.LauncherApplication;
import com.android.launcher6.R;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class i extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i f500a;

    public static i getModulation() {
        return f500a;
    }

    public CharSequence a(Context context) {
        boolean zIs24HourFormat = DateFormat.is24HourFormat(getContext());
        int i = Calendar.getInstance().get(9);
        if (zIs24HourFormat) {
            return "";
        }
        return i == 0 ? context.getString(R.string.am) : context.getString(R.string.pm);
    }

    public void a() {
        if (LauncherApplication.f88a.getResources().getBoolean(R.bool.app_ampm_show)) {
            setText(a(getContext()));
            return;
        }
        if (getResources().getString(R.string.am).equals(a(getContext()))) {
            setBackgroundResource(a.b.a().fO);
        } else if (getResources().getString(R.string.pm).equals(a(getContext()))) {
            setBackgroundResource(a.b.a().fP);
        } else {
            setBackgroundResource(0);
        }
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
