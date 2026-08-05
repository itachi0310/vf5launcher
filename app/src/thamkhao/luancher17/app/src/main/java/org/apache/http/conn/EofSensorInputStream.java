package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/EofSensorInputStream.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class EofSensorInputStream extends InputStream implements ConnectionReleaseTrigger {
    protected InputStream wrappedStream;

    public EofSensorInputStream(InputStream in, EofSensorWatcher watcher) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isReadAllowed() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected void checkEOF(int eof) throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected void checkClose() throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected void checkAbort() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void releaseConnection() throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void abortConnection() throws IOException {
        throw new RuntimeException("Stub!");
    }
}
