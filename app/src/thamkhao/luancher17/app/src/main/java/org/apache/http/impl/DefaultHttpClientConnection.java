package org.apache.http.impl;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/DefaultHttpClientConnection.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DefaultHttpClientConnection extends SocketHttpClientConnection {
    public DefaultHttpClientConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.SocketHttpClientConnection
    public void bind(Socket socket, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
