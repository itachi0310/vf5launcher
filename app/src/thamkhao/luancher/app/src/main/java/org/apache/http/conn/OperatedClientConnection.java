package org.apache.http.conn;

import java.net.Socket;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/OperatedClientConnection.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface OperatedClientConnection extends HttpClientConnection, HttpInetConnection {
    Socket getSocket();

    HttpHost getTargetHost();

    boolean isSecure();

    void openCompleted(boolean z, HttpParams httpParams);

    void opening(Socket socket, HttpHost httpHost);

    void update(Socket socket, HttpHost httpHost, boolean z, HttpParams httpParams);
}
