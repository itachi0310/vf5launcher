package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpRequestInterceptor;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/protocol/HttpRequestInterceptorList.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpRequestInterceptorList {
    void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor);

    void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i);

    void clearRequestInterceptors();

    HttpRequestInterceptor getRequestInterceptor(int i);

    int getRequestInterceptorCount();

    void removeRequestInterceptorByClass(Class cls);

    void setInterceptors(List list);
}
