package org.apache.http.impl;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.HttpInetConnection;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/SocketHttpClientConnection.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SocketHttpClientConnection extends AbstractHttpClientConnection implements HttpInetConnection {
    public SocketHttpClientConnection() {
        throw new RuntimeException("Stub!");
    }

    protected void assertNotOpen() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.AbstractHttpClientConnection
    protected void assertOpen() {
        throw new RuntimeException("Stub!");
    }

    protected void bind(Socket socket, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void close() {
        throw new RuntimeException("Stub!");
    }

    protected SessionInputBuffer createSessionInputBuffer(Socket socket, int i, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    protected SessionOutputBuffer createSessionOutputBuffer(Socket socket, int i, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        throw new RuntimeException("Stub!");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Socket getSocket() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public boolean isOpen() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void setSocketTimeout(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void shutdown() {
        throw new RuntimeException("Stub!");
    }
}
