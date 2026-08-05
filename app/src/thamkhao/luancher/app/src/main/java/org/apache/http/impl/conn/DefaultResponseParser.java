package org.apache.http.impl.conn;

import org.apache.http.HttpMessage;
import org.apache.http.HttpResponseFactory;
import org.apache.http.impl.io.AbstractMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/conn/DefaultResponseParser.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DefaultResponseParser extends AbstractMessageParser {
    public DefaultResponseParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpResponseFactory httpResponseFactory, HttpParams httpParams) {
        super((SessionInputBuffer) null, (LineParser) null, (HttpParams) null);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.io.AbstractMessageParser
    protected HttpMessage parseHead(SessionInputBuffer sessionInputBuffer) {
        throw new RuntimeException("Stub!");
    }
}
