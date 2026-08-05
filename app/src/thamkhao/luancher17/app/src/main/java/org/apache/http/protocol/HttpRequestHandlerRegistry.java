package org.apache.http.protocol;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/protocol/HttpRequestHandlerRegistry.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpRequestHandlerRegistry implements HttpRequestHandlerResolver {
    public HttpRequestHandlerRegistry() {
        throw new RuntimeException("Stub!");
    }

    public void register(String pattern, HttpRequestHandler handler) {
        throw new RuntimeException("Stub!");
    }

    public void unregister(String pattern) {
        throw new RuntimeException("Stub!");
    }

    public void setHandlers(Map map) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpRequestHandlerResolver
    public HttpRequestHandler lookup(String requestURI) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected boolean matchUriRequestPattern(String pattern, String requestUri) {
        throw new RuntimeException("Stub!");
    }
}
