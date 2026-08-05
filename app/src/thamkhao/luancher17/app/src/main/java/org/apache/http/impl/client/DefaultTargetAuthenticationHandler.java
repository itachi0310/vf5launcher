package org.apache.http.impl.client;

import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/DefaultTargetAuthenticationHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DefaultTargetAuthenticationHandler extends AbstractAuthenticationHandler {
    public DefaultTargetAuthenticationHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.AuthenticationHandler
    public boolean isAuthenticationRequested(HttpResponse response, HttpContext context) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.AuthenticationHandler
    public Map<String, Header> getChallenges(HttpResponse response, HttpContext context) throws MalformedChallengeException {
        throw new RuntimeException("Stub!");
    }
}
