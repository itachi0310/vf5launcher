package org.apache.http.impl.auth;

import org.apache.http.Header;
import org.apache.http.auth.AuthScheme;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/auth/AuthSchemeBase.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class AuthSchemeBase implements AuthScheme {
    public AuthSchemeBase() {
        throw new RuntimeException("Stub!");
    }

    public boolean isProxy() {
        throw new RuntimeException("Stub!");
    }

    protected abstract void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2);

    @Override // org.apache.http.auth.AuthScheme
    public void processChallenge(Header header) {
        throw new RuntimeException("Stub!");
    }
}
