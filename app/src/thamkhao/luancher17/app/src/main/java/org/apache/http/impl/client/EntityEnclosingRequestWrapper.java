package org.apache.http.impl.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/EntityEnclosingRequestWrapper.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class EntityEnclosingRequestWrapper extends RequestWrapper implements HttpEntityEnclosingRequest {
    public EntityEnclosingRequestWrapper(HttpEntityEnclosingRequest request) throws ProtocolException {
        super((HttpRequest) null);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public HttpEntity getEntity() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity entity) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public boolean expectContinue() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.client.RequestWrapper
    public boolean isRepeatable() {
        throw new RuntimeException("Stub!");
    }
}
