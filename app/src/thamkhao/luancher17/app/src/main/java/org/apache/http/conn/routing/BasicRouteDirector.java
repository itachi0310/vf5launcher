package org.apache.http.conn.routing;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/routing/BasicRouteDirector.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicRouteDirector implements HttpRouteDirector {
    public BasicRouteDirector() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.routing.HttpRouteDirector
    public int nextStep(RouteInfo plan, RouteInfo fact) {
        throw new RuntimeException("Stub!");
    }

    protected int firstStep(RouteInfo plan) {
        throw new RuntimeException("Stub!");
    }

    protected int directStep(RouteInfo plan, RouteInfo fact) {
        throw new RuntimeException("Stub!");
    }

    protected int proxiedStep(RouteInfo plan, RouteInfo fact) {
        throw new RuntimeException("Stub!");
    }
}
