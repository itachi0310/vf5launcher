package org.apache.http;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/HttpConnection.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpConnection {
    void close() throws IOException;

    HttpConnectionMetrics getMetrics();

    int getSocketTimeout();

    boolean isOpen();

    boolean isStale();

    void setSocketTimeout(int i);

    void shutdown() throws IOException;
}
