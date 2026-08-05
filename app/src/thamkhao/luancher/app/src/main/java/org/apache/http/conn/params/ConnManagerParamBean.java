package org.apache.http.conn.params;

import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/params/ConnManagerParamBean.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ConnManagerParamBean extends HttpAbstractParamBean {
    public ConnManagerParamBean(HttpParams httpParams) {
        super((HttpParams) null);
        throw new RuntimeException("Stub!");
    }

    public void setConnectionsPerRoute(ConnPerRouteBean connPerRouteBean) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxTotalConnections(int i) {
        throw new RuntimeException("Stub!");
    }

    public void setTimeout(long j) {
        throw new RuntimeException("Stub!");
    }
}
