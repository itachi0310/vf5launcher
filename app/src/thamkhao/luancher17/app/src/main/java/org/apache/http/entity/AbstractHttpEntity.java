package org.apache.http.entity;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/entity/AbstractHttpEntity.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class AbstractHttpEntity implements HttpEntity {
    protected boolean chunked;
    protected Header contentEncoding;
    protected Header contentType;

    protected AbstractHttpEntity() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        throw new RuntimeException("Stub!");
    }

    public void setContentType(Header contentType) {
        throw new RuntimeException("Stub!");
    }

    public void setContentType(String ctString) {
        throw new RuntimeException("Stub!");
    }

    public void setContentEncoding(Header contentEncoding) {
        throw new RuntimeException("Stub!");
    }

    public void setContentEncoding(String ceString) {
        throw new RuntimeException("Stub!");
    }

    public void setChunked(boolean b) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() throws UnsupportedOperationException, IOException {
        throw new RuntimeException("Stub!");
    }
}
