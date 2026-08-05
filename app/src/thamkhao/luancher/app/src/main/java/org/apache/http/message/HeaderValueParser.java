package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/HeaderValueParser.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HeaderValueParser {
    HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);
}
