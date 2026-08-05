package org.apache.http.message;

import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/BasicStatusLine.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicStatusLine implements StatusLine {
    public BasicStatusLine(ProtocolVersion protocolVersion, int i, String str) {
        throw new RuntimeException("Stub!");
    }

    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.StatusLine
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.StatusLine
    public String getReasonPhrase() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.StatusLine
    public int getStatusCode() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
