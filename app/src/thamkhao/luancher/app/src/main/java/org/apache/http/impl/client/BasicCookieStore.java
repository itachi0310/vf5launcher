package org.apache.http.impl.client;

import java.util.Date;
import java.util.List;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/BasicCookieStore.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicCookieStore implements CookieStore {
    public BasicCookieStore() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CookieStore
    public synchronized void addCookie(Cookie cookie) {
        throw new RuntimeException("Stub!");
    }

    public synchronized void addCookies(Cookie[] cookieArr) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CookieStore
    public synchronized void clear() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CookieStore
    public synchronized boolean clearExpired(Date date) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CookieStore
    public synchronized List getCookies() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
