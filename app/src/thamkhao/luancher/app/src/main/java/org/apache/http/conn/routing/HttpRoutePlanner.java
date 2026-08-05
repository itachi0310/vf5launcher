package org.apache.http.conn.routing;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/routing/HttpRoutePlanner.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpRoutePlanner {
    HttpRoute determineRoute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext);
}
