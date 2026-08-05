package org.apache.http.impl.io;

import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.io.SessionInputBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/io/ChunkedInputStream.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ChunkedInputStream extends InputStream {
    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new RuntimeException("Stub!");
    }

    public Header[] getFooters() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream
    public int read() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        throw new RuntimeException("Stub!");
    }
}
