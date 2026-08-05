package org.apache.http.message;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/BasicHttpEntityEnclosingRequest.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicHttpEntityEnclosingRequest extends BasicHttpRequest implements HttpEntityEnclosingRequest {
    public BasicHttpEntityEnclosingRequest(String method, String uri) {
        super((RequestLine) null);
        throw new RuntimeException("Stub!");
    }

    public BasicHttpEntityEnclosingRequest(String method, String uri, ProtocolVersion ver) {
        super((RequestLine) null);
        throw new RuntimeException("Stub!");
    }

    public BasicHttpEntityEnclosingRequest(RequestLine requestline) {
        super((RequestLine) null);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public HttpEntity getEntity() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity entity) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public boolean expectContinue() {
        throw new RuntimeException("Stub!");
    }
}
