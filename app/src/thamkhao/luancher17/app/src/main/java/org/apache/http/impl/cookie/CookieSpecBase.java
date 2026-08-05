package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/cookie/CookieSpecBase.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class CookieSpecBase extends AbstractCookieSpec {
    public CookieSpecBase() {
        throw new RuntimeException("Stub!");
    }

    protected static String getDefaultPath(CookieOrigin origin) {
        throw new RuntimeException("Stub!");
    }

    protected static String getDefaultDomain(CookieOrigin origin) {
        throw new RuntimeException("Stub!");
    }

    protected List<Cookie> parse(HeaderElement[] elems, CookieOrigin origin) throws MalformedCookieException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieSpec
    public void validate(Cookie cookie, CookieOrigin origin) throws MalformedCookieException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieSpec
    public boolean match(Cookie cookie, CookieOrigin origin) {
        throw new RuntimeException("Stub!");
    }
}
