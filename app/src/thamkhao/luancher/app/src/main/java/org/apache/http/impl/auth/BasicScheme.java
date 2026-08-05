package org.apache.http.impl.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.Credentials;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/auth/BasicScheme.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicScheme extends RFC2617Scheme {
    public BasicScheme() {
        throw new RuntimeException("Stub!");
    }

    public static Header authenticate(Credentials credentials, String str, boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.auth.AuthScheme
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.auth.AuthScheme
    public String getSchemeName() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.auth.AuthScheme
    public boolean isComplete() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.auth.AuthScheme
    public boolean isConnectionBased() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.auth.AuthSchemeBase, org.apache.http.auth.AuthScheme
    public void processChallenge(Header header) {
        throw new RuntimeException("Stub!");
    }
}
