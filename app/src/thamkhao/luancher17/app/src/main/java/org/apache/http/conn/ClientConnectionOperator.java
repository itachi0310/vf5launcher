package org.apache.http.conn;

import java.io.IOException;
import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/ClientConnectionOperator.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ClientConnectionOperator {
    OperatedClientConnection createConnection();

    void openConnection(OperatedClientConnection operatedClientConnection, HttpHost httpHost, InetAddress inetAddress, HttpContext httpContext, HttpParams httpParams) throws IOException;

    void updateSecureConnection(OperatedClientConnection operatedClientConnection, HttpHost httpHost, HttpContext httpContext, HttpParams httpParams) throws IOException;
}
