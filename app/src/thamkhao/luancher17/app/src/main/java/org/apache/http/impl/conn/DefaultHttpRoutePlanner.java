package org.apache.http.impl.conn;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/DefaultHttpRoutePlanner.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DefaultHttpRoutePlanner implements HttpRoutePlanner {
    protected SchemeRegistry schemeRegistry;

    public DefaultHttpRoutePlanner(SchemeRegistry schreg) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.routing.HttpRoutePlanner
    public HttpRoute determineRoute(HttpHost target, HttpRequest request, HttpContext context) throws HttpException {
        throw new RuntimeException("Stub!");
    }
}
