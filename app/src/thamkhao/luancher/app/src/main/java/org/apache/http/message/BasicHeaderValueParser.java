package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/BasicHeaderValueParser.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicHeaderValueParser implements HeaderValueParser {
    public static final BasicHeaderValueParser DEFAULT = null;

    public BasicHeaderValueParser() {
        throw new RuntimeException("Stub!");
    }

    public static final HeaderElement[] parseElements(String str, HeaderValueParser headerValueParser) {
        throw new RuntimeException("Stub!");
    }

    public static final HeaderElement parseHeaderElement(String str, HeaderValueParser headerValueParser) {
        throw new RuntimeException("Stub!");
    }

    public static final NameValuePair parseNameValuePair(String str, HeaderValueParser headerValueParser) {
        throw new RuntimeException("Stub!");
    }

    public static final NameValuePair[] parseParameters(String str, HeaderValueParser headerValueParser) {
        throw new RuntimeException("Stub!");
    }

    protected HeaderElement createHeaderElement(String str, String str2, NameValuePair[] nameValuePairArr) {
        throw new RuntimeException("Stub!");
    }

    protected NameValuePair createNameValuePair(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        throw new RuntimeException("Stub!");
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, char[] cArr) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.HeaderValueParser
    public NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        throw new RuntimeException("Stub!");
    }
}
