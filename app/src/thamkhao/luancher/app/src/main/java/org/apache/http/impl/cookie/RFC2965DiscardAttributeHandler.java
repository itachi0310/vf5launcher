package org.apache.http.impl.cookie;

import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.SetCookie;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/cookie/RFC2965DiscardAttributeHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RFC2965DiscardAttributeHandler implements CookieAttributeHandler {
    public RFC2965DiscardAttributeHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieAttributeHandler
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieAttributeHandler
    public void parse(SetCookie setCookie, String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieAttributeHandler
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }
}
