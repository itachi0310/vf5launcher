package org.apache.http.protocol;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/protocol/HttpExpectationVerifier.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpExpectationVerifier {
    void verify(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException;
}
