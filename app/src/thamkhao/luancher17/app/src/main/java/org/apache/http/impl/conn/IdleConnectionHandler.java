package org.apache.http.impl.conn;

import java.util.concurrent.TimeUnit;
import org.apache.http.HttpConnection;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/IdleConnectionHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class IdleConnectionHandler {
    public IdleConnectionHandler() {
        throw new RuntimeException("Stub!");
    }

    public void add(HttpConnection connection, long validDuration, TimeUnit unit) {
        throw new RuntimeException("Stub!");
    }

    public boolean remove(HttpConnection connection) {
        throw new RuntimeException("Stub!");
    }

    public void removeAll() {
        throw new RuntimeException("Stub!");
    }

    public void closeIdleConnections(long idleTime) {
        throw new RuntimeException("Stub!");
    }

    public void closeExpiredConnections() {
        throw new RuntimeException("Stub!");
    }
}
