package org.apache.http.protocol;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/protocol/DefaultedHttpContext.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class DefaultedHttpContext implements HttpContext {
    public DefaultedHttpContext(HttpContext httpContext, HttpContext httpContext2) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object getAttribute(String str) {
        throw new RuntimeException("Stub!");
    }

    public HttpContext getDefaults() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpContext
    public Object removeAttribute(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpContext
    public void setAttribute(String str, Object obj) {
        throw new RuntimeException("Stub!");
    }
}
