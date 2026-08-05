package org.apache.http.impl.conn;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.OperatedClientConnection;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/AbstractClientConnAdapter.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class AbstractClientConnAdapter implements ManagedClientConnection {
    protected AbstractClientConnAdapter(ClientConnectionManager clientConnectionManager, OperatedClientConnection operatedClientConnection) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void abortConnection() {
        throw new RuntimeException("Stub!");
    }

    protected final void assertNotAborted() {
        throw new RuntimeException("Stub!");
    }

    protected final void assertValid(OperatedClientConnection operatedClientConnection) {
        throw new RuntimeException("Stub!");
    }

    protected void detach() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpClientConnection
    public void flush() {
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

    protected ClientConnectionManager getManager() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public HttpConnectionMetrics getMetrics() {
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

    @Override // org.apache.http.conn.ManagedClientConnection
    public SSLSession getSSLSession() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        throw new RuntimeException("Stub!");
    }

    protected OperatedClientConnection getWrappedConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public boolean isMarkedReusable() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public boolean isOpen() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpClientConnection
    public boolean isResponseAvailable(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public boolean isSecure() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public boolean isStale() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void markReusable() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpClientConnection
    public void receiveResponseEntity(HttpResponse httpResponse) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpClientConnection
    public HttpResponse receiveResponseHeader() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ConnectionReleaseTrigger
    public void releaseConnection() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpClientConnection
    public void sendRequestHeader(HttpRequest httpRequest) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void setIdleDuration(long j, TimeUnit timeUnit) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void setSocketTimeout(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.ManagedClientConnection
    public void unmarkReusable() {
        throw new RuntimeException("Stub!");
    }
}
