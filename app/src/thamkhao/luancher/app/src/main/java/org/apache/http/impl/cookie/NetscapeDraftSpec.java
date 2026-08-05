package org.apache.http.impl.cookie;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.cookie.CookieOrigin;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/cookie/NetscapeDraftSpec.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class NetscapeDraftSpec extends CookieSpecBase {
    protected static final String EXPIRES_PATTERN = "EEE, dd-MMM-yyyy HH:mm:ss z";

    public NetscapeDraftSpec() {
        throw new RuntimeException("Stub!");
    }

    public NetscapeDraftSpec(String[] strArr) {
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
    public List parse(Header header, CookieOrigin cookieOrigin) {
        throw new RuntimeException("Stub!");
    }
}
