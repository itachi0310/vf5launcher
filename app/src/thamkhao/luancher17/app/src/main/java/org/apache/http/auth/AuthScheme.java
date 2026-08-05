package org.apache.http.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/auth/AuthScheme.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface AuthScheme {
    Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException;

    String getParameter(String str);

    String getRealm();

    String getSchemeName();

    boolean isComplete();

    boolean isConnectionBased();

    void processChallenge(Header header) throws MalformedChallengeException;
}
