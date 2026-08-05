package org.apache.http.params;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/params/BasicHttpParams.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class BasicHttpParams extends AbstractHttpParams implements Serializable {
    public BasicHttpParams() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.params.HttpParams
    public Object getParameter(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setParameter(String name, Object value) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.params.HttpParams
    public boolean removeParameter(String name) {
        throw new RuntimeException("Stub!");
    }

    public void setParameters(String[] names, Object value) {
        throw new RuntimeException("Stub!");
    }

    public boolean isParameterSet(String name) {
        throw new RuntimeException("Stub!");
    }

    public boolean isParameterSetLocally(String name) {
        throw new RuntimeException("Stub!");
    }

    public void clear() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams copy() {
        throw new RuntimeException("Stub!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    protected void copyParams(HttpParams target) {
        throw new RuntimeException("Stub!");
    }
}
