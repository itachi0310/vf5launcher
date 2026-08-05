package org.apache.http.impl.client;

import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/DefaultRedirectHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DefaultRedirectHandler implements RedirectHandler {
    public DefaultRedirectHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.RedirectHandler
    public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.RedirectHandler
    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }
}
