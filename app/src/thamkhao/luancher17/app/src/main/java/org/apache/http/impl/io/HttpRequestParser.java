package org.apache.http.impl.io;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequestFactory;
import org.apache.http.ParseException;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/io/HttpRequestParser.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpRequestParser extends AbstractMessageParser {
    public HttpRequestParser(SessionInputBuffer buffer, LineParser parser, HttpRequestFactory requestFactory, HttpParams params) {
        super((SessionInputBuffer) null, (LineParser) null, (HttpParams) null);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.io.AbstractMessageParser
    protected HttpMessage parseHead(SessionInputBuffer sessionBuffer) throws HttpException, ParseException, IOException {
        throw new RuntimeException("Stub!");
    }
}
