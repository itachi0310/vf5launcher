package org.apache.http.conn.params;

import java.util.Map;
import org.apache.http.conn.routing.HttpRoute;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/params/ConnPerRouteBean.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ConnPerRouteBean implements ConnPerRoute {
    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 2;

    public ConnPerRouteBean(int defaultMax) {
        throw new RuntimeException("Stub!");
    }

    public ConnPerRouteBean() {
        throw new RuntimeException("Stub!");
    }

    public int getDefaultMax() {
        throw new RuntimeException("Stub!");
    }

    public void setDefaultMaxPerRoute(int max) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxForRoute(HttpRoute route, int max) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.params.ConnPerRoute
    public int getMaxForRoute(HttpRoute route) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxForRoutes(Map<HttpRoute, Integer> map) {
        throw new RuntimeException("Stub!");
    }
}
