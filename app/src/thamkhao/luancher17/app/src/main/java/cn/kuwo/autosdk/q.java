package cn.kuwo.autosdk;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class q extends Date {
    public q() {
    }

    public q(String str) {
        b(str);
    }

    public final String a() {
        return a("yyyy-MM-dd HH:mm:ss");
    }

    public final String a(String str) {
        return new SimpleDateFormat(str, Locale.CHINA).format((Date) this);
    }

    public final boolean a(String str, String str2) {
        try {
            setTime(new SimpleDateFormat(str2, Locale.CHINA).parse(str).getTime());
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println(str);
            return false;
        }
    }

    public final boolean b(String str) {
        return a(str, str.length() > 10 ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd");
    }
}
