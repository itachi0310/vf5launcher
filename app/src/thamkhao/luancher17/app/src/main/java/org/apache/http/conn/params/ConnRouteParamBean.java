package org.apache.http.conn.params;

import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/params/ConnRouteParamBean.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ConnRouteParamBean extends HttpAbstractParamBean {
    public ConnRouteParamBean(HttpParams params) {
        super((HttpParams) null);
        throw new RuntimeException("Stub!");
    }

    public void setDefaultProxy(HttpHost defaultProxy) {
        throw new RuntimeException("Stub!");
    }

    public void setLocalAddress(InetAddress address) {
        throw new RuntimeException("Stub!");
    }

    public void setForcedRoute(HttpRoute route) {
        throw new RuntimeException("Stub!");
    }
}
