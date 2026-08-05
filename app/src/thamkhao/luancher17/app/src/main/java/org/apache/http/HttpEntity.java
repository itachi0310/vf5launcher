package org.apache.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/HttpEntity.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpEntity {
    void consumeContent() throws IOException;

    InputStream getContent() throws IllegalStateException, IOException;

    Header getContentEncoding();

    long getContentLength();

    Header getContentType();

    boolean isChunked();

    boolean isRepeatable();

    boolean isStreaming();

    void writeTo(OutputStream outputStream) throws IOException;
}
