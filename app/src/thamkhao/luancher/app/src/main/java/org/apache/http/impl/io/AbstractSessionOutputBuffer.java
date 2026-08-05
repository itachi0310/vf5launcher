package org.apache.http.impl.io;

import java.io.OutputStream;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/io/AbstractSessionOutputBuffer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class AbstractSessionOutputBuffer implements SessionOutputBuffer {
    public AbstractSessionOutputBuffer() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void flush() {
        throw new RuntimeException("Stub!");
    }

    protected void flushBuffer() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        throw new RuntimeException("Stub!");
    }

    protected void init(OutputStream outputStream, int i, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] bArr) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] bArr, int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void writeLine(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer charArrayBuffer) {
        throw new RuntimeException("Stub!");
    }
}
