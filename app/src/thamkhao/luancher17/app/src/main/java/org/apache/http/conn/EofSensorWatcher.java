package org.apache.http.conn;

import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/EofSensorWatcher.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface EofSensorWatcher {
    boolean eofDetected(InputStream inputStream) throws IOException;

    boolean streamAbort(InputStream inputStream) throws IOException;

    boolean streamClosed(InputStream inputStream) throws IOException;
}
