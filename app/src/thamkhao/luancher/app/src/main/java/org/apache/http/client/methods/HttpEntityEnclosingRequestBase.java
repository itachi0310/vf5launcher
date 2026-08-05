package org.apache.http.client.methods;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/methods/HttpEntityEnclosingRequestBase.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class HttpEntityEnclosingRequestBase extends HttpRequestBase implements HttpEntityEnclosingRequest {
    public HttpEntityEnclosingRequestBase() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpRequestBase
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public boolean expectContinue() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public HttpEntity getEntity() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity httpEntity) {
        throw new RuntimeException("Stub!");
    }
}
