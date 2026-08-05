package org.apache.http.impl.io;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/io/AbstractMessageWriter.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class AbstractMessageWriter implements HttpMessageWriter {
    protected final CharArrayBuffer lineBuf;
    protected final LineFormatter lineFormatter;
    protected final SessionOutputBuffer sessionBuffer;

    protected abstract void writeHeadLine(HttpMessage httpMessage) throws IOException;

    public AbstractMessageWriter(SessionOutputBuffer buffer, LineFormatter formatter, HttpParams params) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.HttpMessageWriter
    public void write(HttpMessage message) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }
}
