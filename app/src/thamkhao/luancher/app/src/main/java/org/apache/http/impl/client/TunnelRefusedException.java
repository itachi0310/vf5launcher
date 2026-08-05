package org.apache.http.impl.client;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/TunnelRefusedException.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class TunnelRefusedException extends HttpException {
    public TunnelRefusedException(String str, HttpResponse httpResponse) {
        throw new RuntimeException("Stub!");
    }

    public HttpResponse getResponse() {
        throw new RuntimeException("Stub!");
    }
}
