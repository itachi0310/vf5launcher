package org.apache.http.impl.conn.tsccm;

import java.util.LinkedList;
import java.util.Queue;
import org.apache.http.conn.routing.HttpRoute;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/tsccm/RouteSpecificPool.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RouteSpecificPool {
    protected final LinkedList freeEntries;
    protected final int maxEntries;
    protected int numEntries;
    protected final HttpRoute route;
    protected final Queue waitingThreads;

    public RouteSpecificPool(HttpRoute httpRoute, int i) {
        throw new RuntimeException("Stub!");
    }

    public BasicPoolEntry allocEntry(Object obj) {
        throw new RuntimeException("Stub!");
    }

    public void createdEntry(BasicPoolEntry basicPoolEntry) {
        throw new RuntimeException("Stub!");
    }

    public boolean deleteEntry(BasicPoolEntry basicPoolEntry) {
        throw new RuntimeException("Stub!");
    }

    public void dropEntry() {
        throw new RuntimeException("Stub!");
    }

    public void freeEntry(BasicPoolEntry basicPoolEntry) {
        throw new RuntimeException("Stub!");
    }

    public int getCapacity() {
        throw new RuntimeException("Stub!");
    }

    public final int getEntryCount() {
        throw new RuntimeException("Stub!");
    }

    public final int getMaxEntries() {
        throw new RuntimeException("Stub!");
    }

    public final HttpRoute getRoute() {
        throw new RuntimeException("Stub!");
    }

    public boolean hasThread() {
        throw new RuntimeException("Stub!");
    }

    public boolean isUnused() {
        throw new RuntimeException("Stub!");
    }

    public WaitingThread nextThread() {
        throw new RuntimeException("Stub!");
    }

    public void queueThread(WaitingThread waitingThread) {
        throw new RuntimeException("Stub!");
    }

    public void removeThread(WaitingThread waitingThread) {
        throw new RuntimeException("Stub!");
    }
}
