package org.apache.http.client;

import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/RedirectHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface RedirectHandler {
    URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext);

    boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext);
}
