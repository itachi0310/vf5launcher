package org.apache.http.impl.conn;

import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/LoggingSessionInputBuffer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class LoggingSessionInputBuffer implements SessionInputBuffer {
    public LoggingSessionInputBuffer(SessionInputBuffer sessionInputBuffer, Wire wire) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read(byte[] bArr) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read(byte[] bArr, int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int readLine(CharArrayBuffer charArrayBuffer) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public String readLine() {
        throw new RuntimeException("Stub!");
    }
}
