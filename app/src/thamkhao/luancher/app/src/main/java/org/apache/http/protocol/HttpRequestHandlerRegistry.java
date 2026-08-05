package org.apache.http.protocol;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/protocol/HttpRequestHandlerRegistry.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpRequestHandlerRegistry implements HttpRequestHandlerResolver {
    public HttpRequestHandlerRegistry() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpRequestHandlerResolver
    public HttpRequestHandler lookup(String str) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected boolean matchUriRequestPattern(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    public void register(String str, HttpRequestHandler httpRequestHandler) {
        throw new RuntimeException("Stub!");
    }

    public void setHandlers(Map map) {
        throw new RuntimeException("Stub!");
    }

    public void unregister(String str) {
        throw new RuntimeException("Stub!");
    }
}
