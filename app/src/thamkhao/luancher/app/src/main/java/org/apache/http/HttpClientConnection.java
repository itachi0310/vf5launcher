package org.apache.http;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/HttpClientConnection.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpClientConnection extends HttpConnection {
    void flush();

    boolean isResponseAvailable(int i);

    void receiveResponseEntity(HttpResponse httpResponse);

    HttpResponse receiveResponseHeader();

    void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest);

    void sendRequestHeader(HttpRequest httpRequest);
}
