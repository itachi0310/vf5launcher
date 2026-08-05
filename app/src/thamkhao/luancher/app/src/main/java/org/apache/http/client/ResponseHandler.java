package org.apache.http.client;

import org.apache.http.HttpResponse;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/ResponseHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ResponseHandler {
    Object handleResponse(HttpResponse httpResponse);
}
