package org.apache.http.cookie;

import java.util.List;
import org.apache.http.Header;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/cookie/CookieSpec.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface CookieSpec {
    List formatCookies(List list);

    int getVersion();

    Header getVersionHeader();

    boolean match(Cookie cookie, CookieOrigin cookieOrigin);

    List parse(Header header, CookieOrigin cookieOrigin);

    void validate(Cookie cookie, CookieOrigin cookieOrigin);
}
