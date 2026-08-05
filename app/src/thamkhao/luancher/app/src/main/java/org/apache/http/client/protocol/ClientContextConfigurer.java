package org.apache.http.client.protocol;

import java.util.List;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/protocol/ClientContextConfigurer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ClientContextConfigurer implements ClientContext {
    public ClientContextConfigurer(HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }

    public void setAuthSchemePref(List list) {
        throw new RuntimeException("Stub!");
    }

    public void setAuthSchemeRegistry(AuthSchemeRegistry authSchemeRegistry) {
        throw new RuntimeException("Stub!");
    }

    public void setCookieSpecRegistry(CookieSpecRegistry cookieSpecRegistry) {
        throw new RuntimeException("Stub!");
    }

    public void setCookieStore(CookieStore cookieStore) {
        throw new RuntimeException("Stub!");
    }

    public void setCredentialsProvider(CredentialsProvider credentialsProvider) {
        throw new RuntimeException("Stub!");
    }
}
