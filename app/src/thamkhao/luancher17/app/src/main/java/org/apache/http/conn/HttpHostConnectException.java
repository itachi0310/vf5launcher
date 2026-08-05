package org.apache.http.conn;

import java.net.ConnectException;
import org.apache.http.HttpHost;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/HttpHostConnectException.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpHostConnectException extends ConnectException {
    public HttpHostConnectException(HttpHost host, ConnectException cause) {
        throw new RuntimeException("Stub!");
    }

    public HttpHost getHost() {
        throw new RuntimeException("Stub!");
    }
}
