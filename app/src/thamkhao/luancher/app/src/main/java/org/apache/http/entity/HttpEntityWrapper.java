package org.apache.http.entity;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/entity/HttpEntityWrapper.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpEntityWrapper implements HttpEntity {
    protected HttpEntity wrappedEntity;

    public HttpEntityWrapper(HttpEntity httpEntity) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) {
        throw new RuntimeException("Stub!");
    }
}
