package org.apache.http.auth;

import java.security.Principal;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/auth/UsernamePasswordCredentials.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class UsernamePasswordCredentials implements Credentials {
    public UsernamePasswordCredentials(String usernamePassword) {
        throw new RuntimeException("Stub!");
    }

    public UsernamePasswordCredentials(String userName, String password) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.auth.Credentials
    public Principal getUserPrincipal() {
        throw new RuntimeException("Stub!");
    }

    public String getUserName() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.auth.Credentials
    public String getPassword() {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object o) {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
