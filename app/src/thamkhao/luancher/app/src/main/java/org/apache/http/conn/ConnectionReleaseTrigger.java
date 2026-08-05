package org.apache.http.conn;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/ConnectionReleaseTrigger.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ConnectionReleaseTrigger {
    void abortConnection();

    void releaseConnection();
}
