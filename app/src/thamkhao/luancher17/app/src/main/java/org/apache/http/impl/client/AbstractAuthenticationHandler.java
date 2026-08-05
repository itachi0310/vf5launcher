package org.apache.http.impl.client;

import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/AbstractAuthenticationHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class AbstractAuthenticationHandler implements AuthenticationHandler {
    public AbstractAuthenticationHandler() {
        throw new RuntimeException("Stub!");
    }

    protected Map<String, Header> parseChallenges(Header[] headers) throws MalformedChallengeException {
        throw new RuntimeException("Stub!");
    }

    protected List<String> getAuthPreferences() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.AuthenticationHandler
    public AuthScheme selectScheme(Map<String, Header> challenges, HttpResponse response, HttpContext context) throws AuthenticationException {
        throw new RuntimeException("Stub!");
    }
}
