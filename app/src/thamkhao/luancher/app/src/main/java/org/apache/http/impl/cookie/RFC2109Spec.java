package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/cookie/RFC2109Spec.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RFC2109Spec extends CookieSpecBase {
    public RFC2109Spec() {
        throw new RuntimeException("Stub!");
    }

    public RFC2109Spec(String[] strArr, boolean z) {
        throw new RuntimeException("Stub!");
    }

    protected void formatCookieAsVer(CharArrayBuffer charArrayBuffer, Cookie cookie, int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.cookie.CookieSpec
    public List formatCookies(List list) {
        throw new RuntimeException("Stub!");
    }

    protected void formatParamAsVer(CharArrayBuffer charArrayBuffer, String str, String str2, int i) {
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
    public List parse(Header header, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.cookie.CookieSpecBase, org.apache.http.cookie.CookieSpec
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }
}
