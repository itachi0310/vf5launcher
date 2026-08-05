package org.apache.http.impl.conn.tsccm;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ConnectionPoolTimeoutException;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/tsccm/PoolEntryRequest.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface PoolEntryRequest {
    void abortRequest();

    BasicPoolEntry getPoolEntry(long j, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException;
}
