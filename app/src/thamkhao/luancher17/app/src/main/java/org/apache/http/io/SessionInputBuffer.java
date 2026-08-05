package org.apache.http.io;

import java.io.IOException;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/io/SessionInputBuffer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface SessionInputBuffer {
    HttpTransportMetrics getMetrics();

    boolean isDataAvailable(int i) throws IOException;

    int read() throws IOException;

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int i, int i2) throws IOException;

    int readLine(CharArrayBuffer charArrayBuffer) throws IOException;

    String readLine() throws IOException;
}
