package org.apache.http.impl;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.TokenIterator;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/DefaultConnectionReuseStrategy.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public DefaultConnectionReuseStrategy() {
        throw new RuntimeException("Stub!");
    }

    protected TokenIterator createTokenIterator(HeaderIterator headerIterator) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.ConnectionReuseStrategy
    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }
}
