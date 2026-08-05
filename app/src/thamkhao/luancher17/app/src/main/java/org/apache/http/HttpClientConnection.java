package org.apache.http;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/HttpClientConnection.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpClientConnection extends HttpConnection {
    void flush() throws IOException;

    boolean isResponseAvailable(int i) throws IOException;

    void receiveResponseEntity(HttpResponse httpResponse) throws HttpException, IOException;

    HttpResponse receiveResponseHeader() throws HttpException, IOException;

    void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException;

    void sendRequestHeader(HttpRequest httpRequest) throws HttpException, IOException;
}
