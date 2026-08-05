package org.apache.http.conn;

import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/BasicEofSensorWatcher.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicEofSensorWatcher implements EofSensorWatcher {
    protected boolean attemptReuse;
    protected ManagedClientConnection managedConn;

    public BasicEofSensorWatcher(ManagedClientConnection managedClientConnection, boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.EofSensorWatcher
    public boolean eofDetected(InputStream inputStream) {
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
}
