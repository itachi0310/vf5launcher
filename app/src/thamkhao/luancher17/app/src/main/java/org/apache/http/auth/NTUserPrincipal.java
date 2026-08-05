package org.apache.http.auth;

import java.security.Principal;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/auth/NTUserPrincipal.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class NTUserPrincipal implements Principal {
    public NTUserPrincipal(String domain, String username) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.security.Principal
    public String getName() {
        throw new RuntimeException("Stub!");
    }

    public String getDomain() {
        throw new RuntimeException("Stub!");
    }

    public String getUsername() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.security.Principal
    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.security.Principal
    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.security.Principal
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
