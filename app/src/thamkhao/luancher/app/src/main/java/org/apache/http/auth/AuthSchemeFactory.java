package org.apache.http.auth;

import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/auth/AuthSchemeFactory.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface AuthSchemeFactory {
    AuthScheme newInstance(HttpParams httpParams);
}
