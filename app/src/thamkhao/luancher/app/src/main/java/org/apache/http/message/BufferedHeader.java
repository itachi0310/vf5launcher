package org.apache.http.message;

import org.apache.http.FormattedHeader;
import org.apache.http.HeaderElement;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/BufferedHeader.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BufferedHeader implements FormattedHeader {
    public BufferedHeader(CharArrayBuffer charArrayBuffer) {
        throw new RuntimeException("Stub!");
    }

    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.FormattedHeader
    public CharArrayBuffer getBuffer() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.Header
    public HeaderElement[] getElements() {
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

    @Override // org.apache.http.FormattedHeader
    public int getValuePos() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
