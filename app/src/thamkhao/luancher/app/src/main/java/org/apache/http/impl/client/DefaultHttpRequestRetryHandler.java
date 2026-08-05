package org.apache.http.impl.client;

import java.io.IOException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/DefaultHttpRequestRetryHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DefaultHttpRequestRetryHandler implements HttpRequestRetryHandler {
    public DefaultHttpRequestRetryHandler() {
        throw new RuntimeException("Stub!");
    }

    public DefaultHttpRequestRetryHandler(int i, boolean z) {
        throw new RuntimeException("Stub!");
    }

    public int getRetryCount() {
        throw new RuntimeException("Stub!");
    }

    public boolean isRequestSentRetryEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }
}
