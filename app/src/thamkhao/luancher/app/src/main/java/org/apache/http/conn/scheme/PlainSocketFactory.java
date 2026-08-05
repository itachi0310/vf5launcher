package org.apache.http.conn.scheme;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/scheme/PlainSocketFactory.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class PlainSocketFactory implements SocketFactory {
    public PlainSocketFactory() {
        throw new RuntimeException("Stub!");
    }

    public PlainSocketFactory(HostNameResolver hostNameResolver) {
        throw new RuntimeException("Stub!");
    }

    public static PlainSocketFactory getSocketFactory() {
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
