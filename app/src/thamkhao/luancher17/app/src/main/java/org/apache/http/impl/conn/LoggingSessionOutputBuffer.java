package org.apache.http.impl.conn;

import java.io.IOException;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/LoggingSessionOutputBuffer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class LoggingSessionOutputBuffer implements SessionOutputBuffer {
    public LoggingSessionOutputBuffer(SessionOutputBuffer out, Wire wire) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] b, int off, int len) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(int b) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] b) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void flush() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer buffer) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void writeLine(String s) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }
}
