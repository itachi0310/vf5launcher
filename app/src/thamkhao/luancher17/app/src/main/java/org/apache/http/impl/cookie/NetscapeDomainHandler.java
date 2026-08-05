package org.apache.http.impl.cookie;

import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/cookie/NetscapeDomainHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class NetscapeDomainHandler extends BasicDomainHandler {
    public NetscapeDomainHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.BasicDomainHandler, org.apache.http.cookie.CookieAttributeHandler
    public void validate(Cookie cookie, CookieOrigin origin) throws MalformedCookieException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.BasicDomainHandler, org.apache.http.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie, CookieOrigin origin) {
        throw new RuntimeException("Stub!");
    }
}
