package org.apache.http.client.protocol;

import java.util.List;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/protocol/ClientContextConfigurer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ClientContextConfigurer implements ClientContext {
    public ClientContextConfigurer(HttpContext context) {
        throw new RuntimeException("Stub!");
    }

    public void setCookieSpecRegistry(CookieSpecRegistry registry) {
        throw new RuntimeException("Stub!");
    }

    public void setAuthSchemeRegistry(AuthSchemeRegistry registry) {
        throw new RuntimeException("Stub!");
    }

    public void setCookieStore(CookieStore store) {
        throw new RuntimeException("Stub!");
    }

    public void setCredentialsProvider(CredentialsProvider provider) {
        throw new RuntimeException("Stub!");
    }

    public void setAuthSchemePref(List<String> list) {
        throw new RuntimeException("Stub!");
    }
}
