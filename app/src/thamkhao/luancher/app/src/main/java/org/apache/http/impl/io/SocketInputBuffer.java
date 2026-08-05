package org.apache.http.impl.io;

import java.net.Socket;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/io/SocketInputBuffer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SocketInputBuffer extends AbstractSessionInputBuffer {
    public SocketInputBuffer(Socket socket, int i, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int i) {
        throw new RuntimeException("Stub!");
    }

    public boolean isStale() {
        throw new RuntimeException("Stub!");
    }
}
