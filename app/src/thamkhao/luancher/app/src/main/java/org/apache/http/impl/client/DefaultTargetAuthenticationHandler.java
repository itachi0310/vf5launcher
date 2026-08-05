package org.apache.http.impl.client;

import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/DefaultTargetAuthenticationHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DefaultTargetAuthenticationHandler extends AbstractAuthenticationHandler {
    public DefaultTargetAuthenticationHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.AuthenticationHandler
    public Map getChallenges(HttpResponse httpResponse, HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.AuthenticationHandler
    public boolean isAuthenticationRequested(HttpResponse httpResponse, HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }
}
