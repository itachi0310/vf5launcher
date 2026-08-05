package org.apache.http.client.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/protocol/ResponseProcessCookies.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ResponseProcessCookies implements HttpResponseInterceptor {
    public ResponseProcessCookies() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }
}
