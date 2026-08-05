package org.apache.http.protocol;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/protocol/HttpRequestExecutor.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpRequestExecutor {
    public HttpRequestExecutor() {
        throw new RuntimeException("Stub!");
    }

    protected boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        throw new RuntimeException("Stub!");
    }

    protected HttpResponse doReceiveResponse(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }

    protected HttpResponse doSendRequest(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }

    public HttpResponse execute(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }

    public void postProcess(HttpResponse httpResponse, HttpProcessor httpProcessor, HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }

    public void preProcess(HttpRequest httpRequest, HttpProcessor httpProcessor, HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }
}
