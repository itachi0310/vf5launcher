package org.apache.http.impl.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/EntityEnclosingRequestWrapper.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class EntityEnclosingRequestWrapper extends RequestWrapper implements HttpEntityEnclosingRequest {
    public EntityEnclosingRequestWrapper(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        super((HttpRequest) null);
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

    @Override // org.apache.http.impl.client.RequestWrapper
    public boolean isRepeatable() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity httpEntity) {
        throw new RuntimeException("Stub!");
    }
}
