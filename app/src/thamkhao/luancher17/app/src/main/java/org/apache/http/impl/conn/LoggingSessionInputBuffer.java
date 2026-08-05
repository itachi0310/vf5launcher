package org.apache.http.impl.conn;

import java.io.IOException;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/LoggingSessionInputBuffer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class LoggingSessionInputBuffer implements SessionInputBuffer {
    public LoggingSessionInputBuffer(SessionInputBuffer in, Wire wire) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int timeout) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read(byte[] b, int off, int len) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int read(byte[] b) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public String readLine() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public int readLine(CharArrayBuffer buffer) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }
}
