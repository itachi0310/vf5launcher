package org.apache.http.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import org.apache.http.conn.routing.HttpRoute;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/tsccm/BasicPoolEntryRef.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicPoolEntryRef extends WeakReference {
    public BasicPoolEntryRef(BasicPoolEntry basicPoolEntry, ReferenceQueue referenceQueue) {
        super(null, (ReferenceQueue) null);
        throw new RuntimeException("Stub!");
    }

    public final HttpRoute getRoute() {
        throw new RuntimeException("Stub!");
    }
}
