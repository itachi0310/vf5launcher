package org.apache.http.impl.auth;

import org.apache.http.Header;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/auth/AuthSchemeBase.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class AuthSchemeBase implements AuthScheme {
    protected abstract void parseChallenge(CharArrayBuffer charArrayBuffer, int i, int i2) throws MalformedChallengeException;

    public AuthSchemeBase() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.auth.AuthScheme
    public void processChallenge(Header header) throws MalformedChallengeException {
        throw new RuntimeException("Stub!");
    }

    public boolean isProxy() {
        throw new RuntimeException("Stub!");
    }
}
