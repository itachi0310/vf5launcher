package org.apache.http.impl.io;

import org.apache.http.HttpMessage;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/io/AbstractMessageWriter.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class AbstractMessageWriter implements HttpMessageWriter {
    protected final CharArrayBuffer lineBuf;
    protected final LineFormatter lineFormatter;
    protected final SessionOutputBuffer sessionBuffer;

    public AbstractMessageWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.HttpMessageWriter
    public void write(HttpMessage httpMessage) {
        throw new RuntimeException("Stub!");
    }

    protected abstract void writeHeadLine(HttpMessage httpMessage);
}
