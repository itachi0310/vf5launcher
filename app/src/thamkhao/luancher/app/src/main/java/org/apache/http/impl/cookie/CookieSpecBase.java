package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/cookie/CookieSpecBase.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class CookieSpecBase extends AbstractCookieSpec {
    public CookieSpecBase() {
        throw new RuntimeException("Stub!");
    }

    protected static String getDefaultDomain(CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }

    protected static String getDefaultPath(CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieSpec
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }

    protected List parse(HeaderElement[] headerElementArr, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieSpec
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }
}
