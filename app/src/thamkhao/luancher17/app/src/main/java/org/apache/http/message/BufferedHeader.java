package org.apache.http.message;

import org.apache.http.FormattedHeader;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/BufferedHeader.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BufferedHeader implements FormattedHeader {
    public BufferedHeader(CharArrayBuffer buffer) throws ParseException {
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

    @Override // org.apache.http.Header
    public HeaderElement[] getElements() throws ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.FormattedHeader
    public int getValuePos() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.FormattedHeader
    public CharArrayBuffer getBuffer() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }
}
