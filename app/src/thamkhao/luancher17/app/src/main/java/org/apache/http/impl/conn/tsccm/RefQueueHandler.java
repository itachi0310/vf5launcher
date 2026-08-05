package org.apache.http.impl.conn.tsccm;

import java.lang.ref.Reference;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/tsccm/RefQueueHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface RefQueueHandler {
    void handleReference(Reference<?> reference);
}
