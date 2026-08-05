package org.apache.http.conn.params;

import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/params/ConnManagerParamBean.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ConnManagerParamBean extends HttpAbstractParamBean {
    public ConnManagerParamBean(HttpParams params) {
        super((HttpParams) null);
        throw new RuntimeException("Stub!");
    }

    public void setTimeout(long timeout) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxTotalConnections(int maxConnections) {
        throw new RuntimeException("Stub!");
    }

    public void setConnectionsPerRoute(ConnPerRouteBean connPerRoute) {
        throw new RuntimeException("Stub!");
    }
}
