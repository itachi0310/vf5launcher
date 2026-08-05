package org.apache.http;

import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/HttpMessage.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpMessage {
    void addHeader(String str, String str2);

    void addHeader(Header header);

    boolean containsHeader(String str);

    Header[] getAllHeaders();

    Header getFirstHeader(String str);

    Header[] getHeaders(String str);

    Header getLastHeader(String str);

    HttpParams getParams();

    ProtocolVersion getProtocolVersion();

    HeaderIterator headerIterator();

    HeaderIterator headerIterator(String str);

    void removeHeader(Header header);

    void removeHeaders(String str);

    void setHeader(String str, String str2);

    void setHeader(Header header);

    void setHeaders(Header[] headerArr);

    void setParams(HttpParams httpParams);
}
