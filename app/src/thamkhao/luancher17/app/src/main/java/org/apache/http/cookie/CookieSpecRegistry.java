package org.apache.http.cookie;

import java.util.List;
import java.util.Map;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/cookie/CookieSpecRegistry.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class CookieSpecRegistry {
    public CookieSpecRegistry() {
        throw new RuntimeException("Stub!");
    }

    public synchronized void register(String name, CookieSpecFactory factory) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void unregister(String id) {
        throw new RuntimeException("Stub!");
    }

    public synchronized CookieSpec getCookieSpec(String name, HttpParams params) throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    public synchronized CookieSpec getCookieSpec(String name) throws IllegalStateException {
        throw new RuntimeException("Stub!");
    }

    public synchronized List<String> getSpecNames() {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setItems(Map<String, CookieSpecFactory> map) {
        throw new RuntimeException("Stub!");
    }
}
