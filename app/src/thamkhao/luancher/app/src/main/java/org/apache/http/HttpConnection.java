package org.apache.http;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/HttpConnection.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpConnection {
    void close();

    HttpConnectionMetrics getMetrics();

    int getSocketTimeout();

    boolean isOpen();

    boolean isStale();

    void setSocketTimeout(int i);

    void shutdown();
}
