package org.apache.http.conn;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/BasicManagedEntity.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicManagedEntity extends HttpEntityWrapper implements ConnectionReleaseTrigger, EofSensorWatcher {
    protected final boolean attemptReuse;
    protected ManagedClientConnection managedConn;

    public BasicManagedEntity(HttpEntity httpEntity, ManagedClientConnection managedClientConnection, boolean z) {
        super((HttpEntity) null);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public void consumeContent() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.EofSensorWatcher
    public boolean eofDetected(InputStream inputStream) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public boolean isRepeatable() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        throw new RuntimeException("Stub!");
    }

    protected void releaseManagedConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.EofSensorWatcher
    public boolean streamAbort(InputStream inputStream) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.EofSensorWatcher
    public boolean streamClosed(InputStream inputStream) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) {
        throw new RuntimeException("Stub!");
    }
}
