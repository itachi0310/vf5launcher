package org.apache.http.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/ManagedClientConnection.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ManagedClientConnection extends HttpClientConnection, HttpInetConnection, ConnectionReleaseTrigger {
    HttpRoute getRoute();

    SSLSession getSSLSession();

    Object getState();

    boolean isMarkedReusable();

    boolean isSecure();

    void layerProtocol(HttpContext httpContext, HttpParams httpParams) throws IOException;

    void markReusable();

    void open(HttpRoute httpRoute, HttpContext httpContext, HttpParams httpParams) throws IOException;

    void setIdleDuration(long j, TimeUnit timeUnit);

    void setState(Object obj);

    void tunnelProxy(HttpHost httpHost, boolean z, HttpParams httpParams) throws IOException;

    void tunnelTarget(boolean z, HttpParams httpParams) throws IOException;

    void unmarkReusable();
}
