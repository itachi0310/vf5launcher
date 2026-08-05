package org.apache.http.client;

import java.util.Date;
import java.util.List;
import org.apache.http.cookie.Cookie;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/CookieStore.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface CookieStore {
    void addCookie(Cookie cookie);

    void clear();

    boolean clearExpired(Date date);

    List<Cookie> getCookies();
}
