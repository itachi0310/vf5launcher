package org.apache.http.impl.client;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/DefaultConnectionKeepAliveStrategy.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DefaultConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {
    public DefaultConnectionKeepAliveStrategy() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ConnectionKeepAliveStrategy
    public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
        throw new RuntimeException("Stub!");
    }
}
