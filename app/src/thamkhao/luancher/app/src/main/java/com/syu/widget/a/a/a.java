package com.syu.widget.a.a;

import a.b;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.format.DateFormat;
import com.android.launcher6.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"SimpleDateFormat"})
public class a {
    public static String a(Context context) {
        return new SimpleDateFormat(DateFormat.is24HourFormat(context) ? "HHmm" : "hhmm").format(Calendar.getInstance().getTime());
    }

    public static String a(Context context, String str) {
        return new SimpleDateFormat(str).format(Calendar.getInstance().getTime());
    }

    public static boolean b(Context context) {
        return DateFormat.is24HourFormat(context);
    }

    public static String c(Context context) {
        DateFormat.is24HourFormat(context);
        return Calendar.getInstance().get(9) == 0 ? context.getString(b.a().a("am", "string")) : context.getString(R.string.pm);
    }

    public static String d(Context context) {
        String[] stringArray = context.getResources().getStringArray(R.array.weekday);
        return stringArray[Math.max(0, Math.min(Calendar.getInstance().get(7) - 1, stringArray.length))];
    }
}
