package org.apache.http.client.methods;

import java.net.URI;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/methods/HttpPost.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpPost extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "POST";

    public HttpPost() {
        throw new RuntimeException("Stub!");
    }

    public HttpPost(URI uri) {
        throw new RuntimeException("Stub!");
    }

    public HttpPost(String uri) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        throw new RuntimeException("Stub!");
    }
}
