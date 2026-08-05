package com.syu.g;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap f535a;
    private static Hashtable b = new Hashtable();
    private static boolean c;

    static {
        b.put("ar", "ISO-8859-6");
        b.put("be", "ISO-8859-5");
        b.put("bg", "ISO-8859-5");
        b.put("ca", "ISO-8859-1");
        b.put("cs", "ISO-8859-2");
        b.put("da", "ISO-8859-1");
        b.put("de", "ISO-8859-1");
        b.put("el", "ISO-8859-7");
        b.put("es", "ISO-8859-1");
        b.put("et", "ISO-8859-1");
        b.put("fi", "ISO-8859-1");
        b.put("fr", "ISO-8859-1");
        b.put("hr", "ISO-8859-2");
        b.put("hu", "ISO-8859-2");
        b.put("is", "ISO-8859-1");
        b.put("it", "ISO-8859-1");
        b.put("iw", "ISO-8859-8");
        b.put("ja", "Shift_JIS");
        b.put("ko", "EUC-KR");
        b.put("lt", "ISO-8859-2");
        b.put("lv", "ISO-8859-2");
        b.put("mk", "ISO-8859-5");
        b.put("nl", "ISO-8859-1");
        b.put("no", "ISO-8859-1");
        b.put("pl", "ISO-8859-2");
        b.put("pt", "ISO-8859-1");
        b.put("ro", "ISO-8859-2");
        b.put("ru", "ISO-8859-5");
        b.put("sh", "ISO-8859-5");
        b.put("sk", "ISO-8859-2");
        b.put("sl", "ISO-8859-2");
        b.put("sq", "ISO-8859-2");
        b.put("sr", "ISO-8859-5");
        b.put("sv", "ISO-8859-1");
        b.put("tr", "ISO-8859-9");
        b.put("uk", "ISO-8859-5");
        c = true;
        f535a = new HashMap();
    }

    public static String a(Locale locale) {
        String str = (String) b.get(locale.toString());
        if (str != null) {
            return str;
        }
        String str2 = (String) b.get(locale.getLanguage());
        return str2 == null ? "GB18030" : str2;
    }
}
