package org.apache.http.io;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/io/HttpTransportMetrics.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpTransportMetrics {
    long getBytesTransferred();

    void reset();
}
