package org.apache.http.io;

import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/io/SessionOutputBuffer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface SessionOutputBuffer {
    void flush();

    HttpTransportMetrics getMetrics();

    void write(int i);

    void write(byte[] bArr);

    void write(byte[] bArr, int i, int i2);

    void writeLine(String str);

    void writeLine(CharArrayBuffer charArrayBuffer);
}
