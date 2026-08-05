package org.apache.http.impl.client;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/TunnelRefusedException.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class TunnelRefusedException extends HttpException {
    public TunnelRefusedException(String message, HttpResponse response) {
        throw new RuntimeException("Stub!");
    }

    public HttpResponse getResponse() {
        throw new RuntimeException("Stub!");
    }
}
