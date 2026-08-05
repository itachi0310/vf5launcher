package org.apache.http.client;

import java.io.IOException;
import org.apache.http.HttpResponse;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/ResponseHandler.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ResponseHandler<T> {
    T handleResponse(HttpResponse httpResponse) throws IOException;
}
