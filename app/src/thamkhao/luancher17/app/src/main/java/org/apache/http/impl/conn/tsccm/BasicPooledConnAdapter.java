package org.apache.http.impl.conn.tsccm;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.conn.AbstractPoolEntry;
import org.apache.http.impl.conn.AbstractPooledConnAdapter;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/tsccm/BasicPooledConnAdapter.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicPooledConnAdapter extends AbstractPooledConnAdapter {
    protected BasicPooledConnAdapter(ThreadSafeClientConnManager tsccm, AbstractPoolEntry entry) {
        super((ClientConnectionManager) null, (AbstractPoolEntry) null);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.AbstractClientConnAdapter
    protected ClientConnectionManager getManager() {
        throw new RuntimeException("Stub!");
    }

    protected AbstractPoolEntry getPoolEntry() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.conn.AbstractPooledConnAdapter, org.apache.http.impl.conn.AbstractClientConnAdapter
    protected void detach() {
        throw new RuntimeException("Stub!");
    }
}
