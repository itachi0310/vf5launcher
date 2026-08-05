package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpResponseInterceptor;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/protocol/HttpResponseInterceptorList.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpResponseInterceptorList {
    void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor);

    void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i);

    void clearResponseInterceptors();

    HttpResponseInterceptor getResponseInterceptor(int i);

    int getResponseInterceptorCount();

    void removeResponseInterceptorByClass(Class cls);

    void setInterceptors(List list);
}
