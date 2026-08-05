package org.apache.http.conn;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/ConnectionReleaseTrigger.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ConnectionReleaseTrigger {
    void abortConnection() throws IOException;

    void releaseConnection() throws IOException;
}
