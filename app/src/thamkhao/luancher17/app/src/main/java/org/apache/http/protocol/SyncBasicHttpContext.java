package org.apache.http.protocol;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/protocol/SyncBasicHttpContext.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SyncBasicHttpContext extends BasicHttpContext {
    public SyncBasicHttpContext(HttpContext parentContext) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized Object getAttribute(String id) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized void setAttribute(String id, Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.BasicHttpContext, org.apache.http.protocol.HttpContext
    public synchronized Object removeAttribute(String id) {
        throw new RuntimeException("Stub!");
    }
}
