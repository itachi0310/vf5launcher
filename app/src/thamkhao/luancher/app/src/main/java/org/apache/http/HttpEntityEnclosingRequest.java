package org.apache.http;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/HttpEntityEnclosingRequest.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpEntityEnclosingRequest extends HttpRequest {
    boolean expectContinue();

    HttpEntity getEntity();

    void setEntity(HttpEntity httpEntity);
}
