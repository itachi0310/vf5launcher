package org.apache.http;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/StatusLine.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface StatusLine {
    ProtocolVersion getProtocolVersion();

    String getReasonPhrase();

    int getStatusCode();
}
