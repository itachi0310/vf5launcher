package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/BasicEofSensorWatcher.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicEofSensorWatcher implements EofSensorWatcher {
    protected boolean attemptReuse;
    protected ManagedClientConnection managedConn;

    public BasicEofSensorWatcher(ManagedClientConnection conn, boolean reuse) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.EofSensorWatcher
    public boolean eofDetected(InputStream wrapped) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.EofSensorWatcher
    public boolean streamClosed(InputStream wrapped) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.EofSensorWatcher
    public boolean streamAbort(InputStream wrapped) throws IOException {
        throw new RuntimeException("Stub!");
    }
}
