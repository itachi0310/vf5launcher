package org.apache.http.impl.io;

import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/io/ChunkedOutputStream.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ChunkedOutputStream extends OutputStream {
    public ChunkedOutputStream(SessionOutputBuffer sessionOutputBuffer) {
        throw new RuntimeException("Stub!");
    }

    public ChunkedOutputStream(SessionOutputBuffer sessionOutputBuffer, int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new RuntimeException("Stub!");
    }

    public void finish() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        throw new RuntimeException("Stub!");
    }

    protected void flushCache() {
        throw new RuntimeException("Stub!");
    }

    protected void flushCacheWithAppend(byte[] bArr, int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        throw new RuntimeException("Stub!");
    }

    protected void writeClosingChunk() {
        throw new RuntimeException("Stub!");
    }
}
