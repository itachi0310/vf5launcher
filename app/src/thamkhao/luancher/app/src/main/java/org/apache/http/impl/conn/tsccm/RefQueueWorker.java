package org.apache.http.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/tsccm/RefQueueWorker.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RefQueueWorker implements Runnable {
    protected final RefQueueHandler refHandler;
    protected final ReferenceQueue refQueue;
    protected volatile Thread workerThread;

    public RefQueueWorker(ReferenceQueue referenceQueue, RefQueueHandler refQueueHandler) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new RuntimeException("Stub!");
    }

    public void shutdown() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
