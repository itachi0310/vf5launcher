package org.apache.http.client;

import java.io.IOException;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/HttpRequestRetryHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpRequestRetryHandler {
    boolean retryRequest(IOException iOException, int i, HttpContext httpContext);
}
