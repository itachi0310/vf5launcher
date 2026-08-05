package org.apache.http.cookie;

import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/cookie/CookieSpecFactory.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface CookieSpecFactory {
    CookieSpec newInstance(HttpParams httpParams);
}
