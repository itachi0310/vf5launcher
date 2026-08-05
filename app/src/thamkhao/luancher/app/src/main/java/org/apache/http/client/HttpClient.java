package org.apache.http.client;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/HttpClient.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpClient {
    Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler);

    Object execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler responseHandler, HttpContext httpContext);

    Object execute(HttpUriRequest httpUriRequest, ResponseHandler responseHandler);

    Object execute(HttpUriRequest httpUriRequest, ResponseHandler responseHandler, HttpContext httpContext);

    HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest);

    HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext);

    HttpResponse execute(HttpUriRequest httpUriRequest);

    HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext);

    ClientConnectionManager getConnectionManager();

    HttpParams getParams();
}
