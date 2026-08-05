package org.apache.http.cookie;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/cookie/CookieAttributeHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface CookieAttributeHandler {
    boolean match(Cookie cookie, CookieOrigin cookieOrigin);

    void parse(SetCookie setCookie, String str);

    void validate(Cookie cookie, CookieOrigin cookieOrigin);
}
