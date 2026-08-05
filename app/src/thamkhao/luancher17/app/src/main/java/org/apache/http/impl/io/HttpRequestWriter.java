package org.apache.http.impl.io;

import java.io.IOException;
import org.apache.http.HttpMessage;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/io/HttpRequestWriter.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpRequestWriter extends AbstractMessageWriter {
    public HttpRequestWriter(SessionOutputBuffer buffer, LineFormatter formatter, HttpParams params) {
        super((SessionOutputBuffer) null, (LineFormatter) null, (HttpParams) null);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.io.AbstractMessageWriter
    protected void writeHeadLine(HttpMessage message) throws IOException {
        throw new RuntimeException("Stub!");
    }
}
