package org.apache.http.impl.io;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/io/SocketInputBuffer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SocketInputBuffer extends AbstractSessionInputBuffer {
    public SocketInputBuffer(Socket socket, int buffersize, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int timeout) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public boolean isStale() throws IOException {
        throw new RuntimeException("Stub!");
    }
}
