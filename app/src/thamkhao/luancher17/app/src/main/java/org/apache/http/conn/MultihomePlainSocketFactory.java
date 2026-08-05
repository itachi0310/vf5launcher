package org.apache.http.conn;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/MultihomePlainSocketFactory.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class MultihomePlainSocketFactory implements SocketFactory {
    MultihomePlainSocketFactory() {
        throw new RuntimeException("Stub!");
    }

    public static MultihomePlainSocketFactory getSocketFactory() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket sock, String host, int port, InetAddress localAddress, int localPort, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public final boolean isSecure(Socket sock) throws IllegalArgumentException {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object obj) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }
}
