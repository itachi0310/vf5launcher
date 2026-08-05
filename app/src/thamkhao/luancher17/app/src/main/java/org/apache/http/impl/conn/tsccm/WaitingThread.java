package org.apache.http.impl.conn.tsccm;

import java.util.Date;
import java.util.concurrent.locks.Condition;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/tsccm/WaitingThread.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class WaitingThread {
    public WaitingThread(Condition cond, RouteSpecificPool pool) {
        throw new RuntimeException("Stub!");
    }

    public final Condition getCondition() {
        throw new RuntimeException("Stub!");
    }

    public final RouteSpecificPool getPool() {
        throw new RuntimeException("Stub!");
    }

    public final Thread getThread() {
        throw new RuntimeException("Stub!");
    }

    public boolean await(Date deadline) throws InterruptedException {
        throw new RuntimeException("Stub!");
    }

    public void wakeup() {
        throw new RuntimeException("Stub!");
    }

    public void interrupt() {
        throw new RuntimeException("Stub!");
    }
}
