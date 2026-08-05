package org.apache.http.conn;

import java.net.ConnectException;
import org.apache.http.HttpHost;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/HttpHostConnectException.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpHostConnectException extends ConnectException {
    public HttpHostConnectException(HttpHost httpHost, ConnectException connectException) {
        throw new RuntimeException("Stub!");
    }

    public HttpHost getHost() {
        throw new RuntimeException("Stub!");
    }
}
