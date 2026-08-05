package org.apache.http.impl.client;

import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.HttpParams;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/client/ClientParamsStack.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ClientParamsStack extends AbstractHttpParams {
    protected final HttpParams applicationParams;
    protected final HttpParams clientParams;
    protected final HttpParams overrideParams;
    protected final HttpParams requestParams;

    public ClientParamsStack(HttpParams aparams, HttpParams cparams, HttpParams rparams, HttpParams oparams) {
        throw new RuntimeException("Stub!");
    }

    public ClientParamsStack(ClientParamsStack stack) {
        throw new RuntimeException("Stub!");
    }

    public ClientParamsStack(ClientParamsStack stack, HttpParams aparams, HttpParams cparams, HttpParams rparams, HttpParams oparams) {
        throw new RuntimeException("Stub!");
    }

    public final HttpParams getApplicationParams() {
        throw new RuntimeException("Stub!");
    }

    public final HttpParams getClientParams() {
        throw new RuntimeException("Stub!");
    }

    public final HttpParams getRequestParams() {
        throw new RuntimeException("Stub!");
    }

    public final HttpParams getOverrideParams() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.params.HttpParams
    public Object getParameter(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setParameter(String name, Object value) throws UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.params.HttpParams
    public boolean removeParameter(String name) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams copy() {
        throw new RuntimeException("Stub!");
    }
}
