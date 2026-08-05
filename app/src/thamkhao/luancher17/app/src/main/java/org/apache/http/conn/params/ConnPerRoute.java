package org.apache.http.conn.params;

import org.apache.http.conn.routing.HttpRoute;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/params/ConnPerRoute.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ConnPerRoute {
    int getMaxForRoute(HttpRoute httpRoute);
}
