package org.apache.http.conn.scheme;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/scheme/SocketFactory.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface SocketFactory {
    Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams);

    Socket createSocket();

    boolean isSecure(Socket socket);
}
