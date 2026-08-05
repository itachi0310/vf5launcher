package org.apache.http.protocol;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/protocol/HttpRequestHandlerResolver.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpRequestHandlerResolver {
    HttpRequestHandler lookup(String str);
}
