package org.apache.http.impl;

import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/DefaultHttpResponseFactory.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DefaultHttpResponseFactory implements HttpResponseFactory {
    protected final ReasonPhraseCatalog reasonCatalog;

    public DefaultHttpResponseFactory(ReasonPhraseCatalog catalog) {
        throw new RuntimeException("Stub!");
    }

    public DefaultHttpResponseFactory() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponseFactory
    public HttpResponse newHttpResponse(ProtocolVersion ver, int status, HttpContext context) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpResponseFactory
    public HttpResponse newHttpResponse(StatusLine statusline, HttpContext context) {
        throw new RuntimeException("Stub!");
    }

    protected Locale determineLocale(HttpContext context) {
        throw new RuntimeException("Stub!");
    }
}
