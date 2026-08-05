package org.apache.http.impl.client;

import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/DefaultRedirectHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DefaultRedirectHandler implements RedirectHandler {
    public DefaultRedirectHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.RedirectHandler
    public boolean isRedirectRequested(HttpResponse response, HttpContext context) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.RedirectHandler
    public URI getLocationURI(HttpResponse response, HttpContext context) throws ProtocolException {
        throw new RuntimeException("Stub!");
    }
}
