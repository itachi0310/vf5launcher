package org.apache.http.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.AbstractPoolEntry;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/tsccm/BasicPoolEntry.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicPoolEntry extends AbstractPoolEntry {
    public BasicPoolEntry(ClientConnectionOperator clientConnectionOperator, HttpRoute httpRoute, ReferenceQueue referenceQueue) {
        super((ClientConnectionOperator) null, (HttpRoute) null);
        throw new RuntimeException("Stub!");
    }

    protected final OperatedClientConnection getConnection() {
        throw new RuntimeException("Stub!");
    }

    protected final HttpRoute getPlannedRoute() {
        throw new RuntimeException("Stub!");
    }

    protected final BasicPoolEntryRef getWeakRef() {
        throw new RuntimeException("Stub!");
    }
}
