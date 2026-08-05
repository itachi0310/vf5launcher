package org.apache.http.entity;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/entity/BufferedHttpEntity.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BufferedHttpEntity extends HttpEntityWrapper {
    public BufferedHttpEntity(HttpEntity httpEntity) {
        super((HttpEntity) null);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public long getContentLength() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public boolean isChunked() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public boolean isRepeatable() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public boolean isStreaming() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) {
        throw new RuntimeException("Stub!");
    }
}
