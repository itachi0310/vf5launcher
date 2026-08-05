package org.apache.http;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/HttpEntity.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpEntity {
    void consumeContent();

    InputStream getContent();

    Header getContentEncoding();

    long getContentLength();

    Header getContentType();

    boolean isChunked();

    boolean isRepeatable();

    boolean isStreaming();

    void writeTo(OutputStream outputStream);
}
