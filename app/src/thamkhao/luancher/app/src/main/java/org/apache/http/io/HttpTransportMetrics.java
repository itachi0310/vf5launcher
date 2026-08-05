package org.apache.http.io;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/io/HttpTransportMetrics.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpTransportMetrics {
    long getBytesTransferred();

    void reset();
}
