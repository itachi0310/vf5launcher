package org.apache.http;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/HttpRequestFactory.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpRequestFactory {
    HttpRequest newHttpRequest(String str, String str2);

    HttpRequest newHttpRequest(RequestLine requestLine);
}
