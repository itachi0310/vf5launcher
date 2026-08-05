package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/message/BasicLineFormatter.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicLineFormatter implements LineFormatter {
    public static final BasicLineFormatter DEFAULT = null;

    public BasicLineFormatter() {
        throw new RuntimeException("Stub!");
    }

    protected CharArrayBuffer initBuffer(CharArrayBuffer buffer) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatProtocolVersion(ProtocolVersion version, LineFormatter formatter) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.LineFormatter
    public CharArrayBuffer appendProtocolVersion(CharArrayBuffer buffer, ProtocolVersion version) {
        throw new RuntimeException("Stub!");
    }

    protected int estimateProtocolVersionLen(ProtocolVersion version) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatRequestLine(RequestLine reqline, LineFormatter formatter) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatRequestLine(CharArrayBuffer buffer, RequestLine reqline) {
        throw new RuntimeException("Stub!");
    }

    protected void doFormatRequestLine(CharArrayBuffer buffer, RequestLine reqline) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatStatusLine(StatusLine statline, LineFormatter formatter) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatStatusLine(CharArrayBuffer buffer, StatusLine statline) {
        throw new RuntimeException("Stub!");
    }

    protected void doFormatStatusLine(CharArrayBuffer buffer, StatusLine statline) {
        throw new RuntimeException("Stub!");
    }

    public static final String formatHeader(Header header, LineFormatter formatter) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.message.LineFormatter
    public CharArrayBuffer formatHeader(CharArrayBuffer buffer, Header header) {
        throw new RuntimeException("Stub!");
    }

    protected void doFormatHeader(CharArrayBuffer buffer, Header header) {
        throw new RuntimeException("Stub!");
    }
}
