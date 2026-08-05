package org.apache.http.conn.params;

import org.apache.http.conn.routing.HttpRoute;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/params/ConnPerRoute.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ConnPerRoute {
    int getMaxForRoute(HttpRoute httpRoute);
}
