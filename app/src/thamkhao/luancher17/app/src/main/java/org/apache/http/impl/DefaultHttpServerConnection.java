package org.apache.http.impl;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/DefaultHttpServerConnection.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DefaultHttpServerConnection extends SocketHttpServerConnection {
    public DefaultHttpServerConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.SocketHttpServerConnection
    public void bind(Socket socket, HttpParams params) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
