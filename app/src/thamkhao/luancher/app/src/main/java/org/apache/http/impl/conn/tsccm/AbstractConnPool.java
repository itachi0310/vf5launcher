package org.apache.http.impl.conn.tsccm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.IdleConnectionHandler;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/tsccm/AbstractConnPool.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class AbstractConnPool implements RefQueueHandler {
    protected IdleConnectionHandler idleConnHandler;
    protected volatile boolean isShutDown;
    protected Set issuedConnections;
    protected int numConnections;
    protected final Lock poolLock;
    protected ReferenceQueue refQueue;

    protected AbstractConnPool() {
        throw new RuntimeException("Stub!");
    }

    protected void closeConnection(OperatedClientConnection operatedClientConnection) {
        throw new RuntimeException("Stub!");
    }

    public void closeExpiredConnections() {
        throw new RuntimeException("Stub!");
    }

    public void closeIdleConnections(long j, TimeUnit timeUnit) {
        throw new RuntimeException("Stub!");
    }

    public abstract void deleteClosedConnections();

    public void enableConnectionGC() {
        throw new RuntimeException("Stub!");
    }

    public abstract void freeEntry(BasicPoolEntry basicPoolEntry, boolean z, long j, TimeUnit timeUnit);

    public final BasicPoolEntry getEntry(HttpRoute httpRoute, Object obj, long j, TimeUnit timeUnit) {
        throw new RuntimeException("Stub!");
    }

    protected abstract void handleLostEntry(HttpRoute httpRoute);

    @Override // org.apache.http.impl.conn.tsccm.RefQueueHandler
    public void handleReference(Reference reference) {
        throw new RuntimeException("Stub!");
    }

    public abstract PoolEntryRequest requestPoolEntry(HttpRoute httpRoute, Object obj);

    public void shutdown() {
        throw new RuntimeException("Stub!");
    }
}
