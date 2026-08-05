package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/LineParser.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface LineParser {
    boolean hasProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    Header parseHeader(CharArrayBuffer charArrayBuffer) throws ParseException;

    ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;

    RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;

    StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;
}
