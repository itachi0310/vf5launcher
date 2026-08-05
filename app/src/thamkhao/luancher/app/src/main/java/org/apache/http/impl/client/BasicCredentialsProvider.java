package org.apache.http.impl.client;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/BasicCredentialsProvider.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class BasicCredentialsProvider implements CredentialsProvider {
    public BasicCredentialsProvider() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CredentialsProvider
    public synchronized void clear() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CredentialsProvider
    public synchronized Credentials getCredentials(AuthScope authScope) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.CredentialsProvider
    public synchronized void setCredentials(AuthScope authScope, Credentials credentials) {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
