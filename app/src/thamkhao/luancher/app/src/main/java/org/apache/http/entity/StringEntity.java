package org.apache.http.entity;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/entity/StringEntity.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class StringEntity extends AbstractHttpEntity {
    protected final byte[] content = null;

    public StringEntity(String str) {
        throw new RuntimeException("Stub!");
    }

    public StringEntity(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
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
