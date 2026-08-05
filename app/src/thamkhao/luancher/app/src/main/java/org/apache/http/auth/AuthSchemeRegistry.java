package org.apache.http.auth;

import java.util.List;
import java.util.Map;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/auth/AuthSchemeRegistry.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class AuthSchemeRegistry {
    public AuthSchemeRegistry() {
        throw new RuntimeException("Stub!");
    }

    public synchronized AuthScheme getAuthScheme(String str, HttpParams httpParams) {
        throw new RuntimeException("Stub!");
    }

    public synchronized List getSchemeNames() {
        throw new RuntimeException("Stub!");
    }

    public synchronized void register(String str, AuthSchemeFactory authSchemeFactory) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void setItems(Map map) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void unregister(String str) {
        throw new RuntimeException("Stub!");
    }
}
