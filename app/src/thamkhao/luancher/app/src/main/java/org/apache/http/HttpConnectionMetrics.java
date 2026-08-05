package org.apache.http;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/HttpConnectionMetrics.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpConnectionMetrics {
    Object getMetric(String str);

    long getReceivedBytesCount();

    long getRequestCount();

    long getResponseCount();

    long getSentBytesCount();

    void reset();
}
