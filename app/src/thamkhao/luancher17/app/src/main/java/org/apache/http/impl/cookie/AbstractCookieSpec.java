package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieSpec;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/cookie/AbstractCookieSpec.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class AbstractCookieSpec implements CookieSpec {
    public AbstractCookieSpec() {
        throw new RuntimeException("Stub!");
    }

    public void registerAttribHandler(String name, CookieAttributeHandler handler) {
        throw new RuntimeException("Stub!");
    }

    protected CookieAttributeHandler findAttribHandler(String name) {
        throw new RuntimeException("Stub!");
    }

    protected CookieAttributeHandler getAttribHandler(String name) {
        throw new RuntimeException("Stub!");
    }

    protected Collection<CookieAttributeHandler> getAttribHandlers() {
        throw new RuntimeException("Stub!");
    }
}
