package org.apache.http.client.utils;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Scanner;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/utils/URLEncodedUtils.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class URLEncodedUtils {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    public URLEncodedUtils() {
        throw new RuntimeException("Stub!");
    }

    public static List<NameValuePair> parse(URI uri, String encoding) {
        throw new RuntimeException("Stub!");
    }

    public static List<NameValuePair> parse(HttpEntity entity) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public static boolean isEncoded(HttpEntity entity) {
        throw new RuntimeException("Stub!");
    }

    public static void parse(List<NameValuePair> parameters, Scanner scanner, String encoding) {
        throw new RuntimeException("Stub!");
    }

    public static String format(List<? extends NameValuePair> parameters, String encoding) {
        throw new RuntimeException("Stub!");
    }
}
