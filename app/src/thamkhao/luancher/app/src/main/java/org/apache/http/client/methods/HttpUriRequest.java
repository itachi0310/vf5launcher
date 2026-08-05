package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.HttpRequest;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/methods/HttpUriRequest.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpUriRequest extends HttpRequest {
    void abort();

    String getMethod();

    URI getURI();

    boolean isAborted();
}
