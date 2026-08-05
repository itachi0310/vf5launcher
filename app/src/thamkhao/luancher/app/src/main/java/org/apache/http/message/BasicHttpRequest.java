package org.apache.http.message;

import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/BasicHttpRequest.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicHttpRequest extends AbstractHttpMessage implements HttpRequest {
    public BasicHttpRequest(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpRequest(String str, String str2, ProtocolVersion protocolVersion) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpRequest(RequestLine requestLine) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpRequest
    public RequestLine getRequestLine() {
        throw new RuntimeException("Stub!");
    }
}
