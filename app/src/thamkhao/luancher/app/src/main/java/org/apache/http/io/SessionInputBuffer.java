package org.apache.http.io;

import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/io/SessionInputBuffer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface SessionInputBuffer {
    HttpTransportMetrics getMetrics();

    boolean isDataAvailable(int i);

    int read();

    int read(byte[] bArr);

    int read(byte[] bArr, int i, int i2);

    int readLine(CharArrayBuffer charArrayBuffer);

    String readLine();
}
