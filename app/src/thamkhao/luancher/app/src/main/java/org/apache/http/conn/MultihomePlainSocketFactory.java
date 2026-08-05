package org.apache.http.conn;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/MultihomePlainSocketFactory.class
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
    public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object obj) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public final boolean isSecure(Socket socket) {
        throw new RuntimeException("Stub!");
    }
}
