package org.apache.http;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/HttpServerConnection.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpServerConnection extends HttpConnection {
    void flush() throws IOException;

    void receiveRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException;

    HttpRequest receiveRequestHeader() throws HttpException, IOException;

    void sendResponseEntity(HttpResponse httpResponse) throws HttpException, IOException;

    void sendResponseHeader(HttpResponse httpResponse) throws HttpException, IOException;
}
