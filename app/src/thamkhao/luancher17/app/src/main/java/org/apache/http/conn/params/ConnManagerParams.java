package org.apache.http.conn.params;

import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/params/ConnManagerParams.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ConnManagerParams implements ConnManagerPNames {
    public static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 20;

    public ConnManagerParams() {
        throw new RuntimeException("Stub!");
    }

    public static long getTimeout(HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    public static void setTimeout(HttpParams params, long timeout) {
        throw new RuntimeException("Stub!");
    }

    public static void setMaxConnectionsPerRoute(HttpParams params, ConnPerRoute connPerRoute) {
        throw new RuntimeException("Stub!");
    }

    public static ConnPerRoute getMaxConnectionsPerRoute(HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    public static void setMaxTotalConnections(HttpParams params, int maxTotalConnections) {
        throw new RuntimeException("Stub!");
    }

    public static int getMaxTotalConnections(HttpParams params) {
        throw new RuntimeException("Stub!");
    }
}
