package org.apache.http.impl.cookie;

import java.util.Date;
import java.util.TimeZone;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/cookie/DateUtils.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class DateUtils {
    public static final TimeZone GMT = null;
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    DateUtils() {
        throw new RuntimeException("Stub!");
    }

    public static Date parseDate(String dateValue) throws DateParseException {
        throw new RuntimeException("Stub!");
    }

    public static Date parseDate(String dateValue, String[] dateFormats) throws DateParseException {
        throw new RuntimeException("Stub!");
    }

    public static Date parseDate(String dateValue, String[] dateFormats, Date startDate) throws DateParseException {
        throw new RuntimeException("Stub!");
    }

    public static String formatDate(Date date) {
        throw new RuntimeException("Stub!");
    }

    public static String formatDate(Date date, String pattern) {
        throw new RuntimeException("Stub!");
    }
}
