package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.message.AbstractHttpMessage;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/methods/HttpRequestBase.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class HttpRequestBase extends AbstractHttpMessage implements AbortableHttpRequest, HttpUriRequest {
    public HttpRequestBase() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.AbortableHttpRequest, org.apache.http.client.methods.HttpUriRequest
    public void abort() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    public abstract String getMethod();

    @Override // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpRequest
    public RequestLine getRequestLine() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public URI getURI() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpUriRequest
    public boolean isAborted() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.AbortableHttpRequest
    public void setConnectionRequest(ClientConnectionRequest clientConnectionRequest) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.AbortableHttpRequest
    public void setReleaseTrigger(ConnectionReleaseTrigger connectionReleaseTrigger) {
        throw new RuntimeException("Stub!");
    }

    public void setURI(URI uri) {
        throw new RuntimeException("Stub!");
    }
}
