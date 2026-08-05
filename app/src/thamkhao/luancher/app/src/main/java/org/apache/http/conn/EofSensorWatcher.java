package org.apache.http.conn;

import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/EofSensorWatcher.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface EofSensorWatcher {
    boolean eofDetected(InputStream inputStream);

    boolean streamAbort(InputStream inputStream);

    boolean streamClosed(InputStream inputStream);
}
