package org.apache.http.conn;

import java.io.InterruptedIOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/ConnectTimeoutException.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ConnectTimeoutException extends InterruptedIOException {
    public ConnectTimeoutException() {
        throw new RuntimeException("Stub!");
    }

    public ConnectTimeoutException(String str) {
        throw new RuntimeException("Stub!");
    }
}
