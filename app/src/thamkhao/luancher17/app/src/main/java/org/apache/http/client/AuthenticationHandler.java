package org.apache.http.client;

import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/AuthenticationHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface AuthenticationHandler {
    Map<String, Header> getChallenges(HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException;

    boolean isAuthenticationRequested(HttpResponse httpResponse, HttpContext httpContext);

    AuthScheme selectScheme(Map<String, Header> map, HttpResponse httpResponse, HttpContext httpContext) throws AuthenticationException;
}
