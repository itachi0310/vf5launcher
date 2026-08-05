package org.apache.http.client.methods;

import java.net.URI;
import java.util.Set;
import org.apache.http.HttpResponse;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/methods/HttpOptions.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpOptions extends HttpRequestBase {
    public static final String METHOD_NAME = "OPTIONS";

    public HttpOptions() {
        throw new RuntimeException("Stub!");
    }

    public HttpOptions(String str) {
        throw new RuntimeException("Stub!");
    }

    public HttpOptions(URI uri) {
        throw new RuntimeException("Stub!");
    }

    public Set getAllowedMethods(HttpResponse httpResponse) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
    public String getMethod() {
        throw new RuntimeException("Stub!");
    }
}
