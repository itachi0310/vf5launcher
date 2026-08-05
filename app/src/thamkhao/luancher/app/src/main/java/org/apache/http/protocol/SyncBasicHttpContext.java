package org.apache.http.protocol;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/protocol/SyncBasicHttpContext.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SyncBasicHttpContext extends BasicHttpContext {
    public SyncBasicHttpContext(HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized Object getAttribute(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized Object removeAttribute(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized void setAttribute(String str, Object obj) {
        throw new RuntimeException("Stub!");
    }
}
