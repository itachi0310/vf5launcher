package org.apache.http.auth;

import java.security.Principal;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/auth/Credentials.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface Credentials {
    String getPassword();

    Principal getUserPrincipal();
}
