package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/protocol/HttpRequestExecutor.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpRequestExecutor {
    public HttpRequestExecutor() {
        throw new RuntimeException("Stub!");
    }

    protected boolean canResponseHaveBody(HttpRequest request, HttpResponse response) {
        throw new RuntimeException("Stub!");
    }

    public HttpResponse execute(HttpRequest request, HttpClientConnection conn, HttpContext context) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    public void preProcess(HttpRequest request, HttpProcessor processor, HttpContext context) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    protected HttpResponse doSendRequest(HttpRequest request, HttpClientConnection conn, HttpContext context) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    protected HttpResponse doReceiveResponse(HttpRequest request, HttpClientConnection conn, HttpContext context) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    public void postProcess(HttpResponse response, HttpProcessor processor, HttpContext context) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }
}
