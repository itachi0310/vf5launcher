package org.apache.http.client;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/CredentialsProvider.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface CredentialsProvider {
    void clear();

    Credentials getCredentials(AuthScope authScope);

    void setCredentials(AuthScope authScope, Credentials credentials);
}
