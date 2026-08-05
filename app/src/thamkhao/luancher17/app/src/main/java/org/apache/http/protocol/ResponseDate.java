package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/protocol/ResponseDate.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ResponseDate implements HttpResponseInterceptor {
    public ResponseDate() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponseInterceptor
    public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }
}
