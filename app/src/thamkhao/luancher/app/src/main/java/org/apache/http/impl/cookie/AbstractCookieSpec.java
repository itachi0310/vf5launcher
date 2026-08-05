package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/cookie/AbstractCookieSpec.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class AbstractCookieSpec implements CookieSpec {
    public AbstractCookieSpec() {
        throw new RuntimeException("Stub!");
    }

    protected CookieAttributeHandler findAttribHandler(String str) {
        throw new RuntimeException("Stub!");
    }

    protected CookieAttributeHandler getAttribHandler(String str) {
        throw new RuntimeException("Stub!");
    }

    protected Collection getAttribHandlers() {
        throw new RuntimeException("Stub!");
    }

    public void registerAttribHandler(String str, CookieAttributeHandler cookieAttributeHandler) {
        throw new RuntimeException("Stub!");
    }
}
