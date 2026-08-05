package org.apache.http.impl.conn.tsccm;

import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/tsccm/PoolEntryRequest.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface PoolEntryRequest {
    void abortRequest();

    BasicPoolEntry getPoolEntry(long j, TimeUnit timeUnit);
}
