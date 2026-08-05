package org.apache.http.client.methods;

import java.net.URI;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/methods/HttpDelete.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpDelete extends HttpRequestBase {
    public static final String METHOD_NAME = "DELETE";

    public HttpDelete() {
        throw new RuntimeException("Stub!");
    }

    public HttpDelete(URI uri) {
        throw new RuntimeException("Stub!");
    }

    public HttpDelete(String uri) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        throw new RuntimeException("Stub!");
    }
}
