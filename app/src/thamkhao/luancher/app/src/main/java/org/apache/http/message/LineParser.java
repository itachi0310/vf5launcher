package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/LineParser.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface LineParser {
    boolean hasProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    Header parseHeader(CharArrayBuffer charArrayBuffer);

    ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);
}
