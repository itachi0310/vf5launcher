package org.apache.http.client;

import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/AuthenticationHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface AuthenticationHandler {
    Map getChallenges(HttpResponse httpResponse, HttpContext httpContext);

    boolean isAuthenticationRequested(HttpResponse httpResponse, HttpContext httpContext);

    AuthScheme selectScheme(Map map, HttpResponse httpResponse, HttpContext httpContext);
}
