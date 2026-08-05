package org.apache.http.conn;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/ClientConnectionOperator.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ClientConnectionOperator {
    OperatedClientConnection createConnection();

    void openConnection(OperatedClientConnection operatedClientConnection, HttpHost httpHost, InetAddress inetAddress, HttpContext httpContext, HttpParams httpParams);

    void updateSecureConnection(OperatedClientConnection operatedClientConnection, HttpHost httpHost, HttpContext httpContext, HttpParams httpParams);
}
