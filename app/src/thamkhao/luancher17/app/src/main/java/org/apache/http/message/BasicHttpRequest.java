package org.apache.http.message;

import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/BasicHttpRequest.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicHttpRequest extends AbstractHttpMessage implements HttpRequest {
    public BasicHttpRequest(String method, String uri) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpRequest(String method, String uri, ProtocolVersion ver) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpRequest(RequestLine requestline) {
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
