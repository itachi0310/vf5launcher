package org.apache.http.conn;

import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/ClientConnectionRequest.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ClientConnectionRequest {
    void abortRequest();

    ManagedClientConnection getConnection(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException;
}
