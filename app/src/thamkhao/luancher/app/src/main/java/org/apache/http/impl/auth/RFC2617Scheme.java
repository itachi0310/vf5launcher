package org.apache.http.impl.auth;

import java.util.Map;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/auth/RFC2617Scheme.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class RFC2617Scheme extends AuthSchemeBase {
    public RFC2617Scheme() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.auth.AuthScheme
    public String getParameter(String str) {
        throw new RuntimeException("Stub!");
    }

    protected Map getParameters() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.auth.AuthScheme
    public String getRealm() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.auth.AuthSchemeBase
    protected void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2) {
        throw new RuntimeException("Stub!");
    }
}
