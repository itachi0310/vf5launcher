package org.apache.http.conn;

import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/ClientConnectionManagerFactory.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ClientConnectionManagerFactory {
    ClientConnectionManager newInstance(HttpParams httpParams, SchemeRegistry schemeRegistry);
}
