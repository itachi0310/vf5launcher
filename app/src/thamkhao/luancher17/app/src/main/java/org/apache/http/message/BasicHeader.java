package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/BasicHeader.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicHeader implements Header {
    public BasicHeader(String name, String value) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.Header
    public String getName() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.Header
    public String getValue() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.Header
    public HeaderElement[] getElements() throws ParseException {
        throw new RuntimeException("Stub!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }
}
