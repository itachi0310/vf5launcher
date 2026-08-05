package org.apache.http;

import java.util.Locale;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/HttpResponse.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpResponse extends HttpMessage {
    HttpEntity getEntity();

    Locale getLocale();

    StatusLine getStatusLine();

    void setEntity(HttpEntity httpEntity);

    void setLocale(Locale locale);

    void setReasonPhrase(String str);

    void setStatusCode(int i);

    void setStatusLine(ProtocolVersion protocolVersion, int i);

    void setStatusLine(ProtocolVersion protocolVersion, int i, String str);

    void setStatusLine(StatusLine statusLine);
}
