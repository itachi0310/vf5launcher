package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.HttpRequest;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/methods/HttpUriRequest.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpUriRequest extends HttpRequest {
    void abort() throws UnsupportedOperationException;

    String getMethod();

    URI getURI();

    boolean isAborted();
}
