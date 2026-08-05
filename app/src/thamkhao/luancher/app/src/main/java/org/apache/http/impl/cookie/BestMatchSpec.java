package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/cookie/BestMatchSpec.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BestMatchSpec implements CookieSpec {
    public BestMatchSpec() {
        throw new RuntimeException("Stub!");
    }

    public BestMatchSpec(String[] strArr, boolean z) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieSpec
    public List formatCookies(List list) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieSpec
    public int getVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieSpec
    public Header getVersionHeader() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieSpec
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieSpec
    public List parse(Header header, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieSpec
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }
}
