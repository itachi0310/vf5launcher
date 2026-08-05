package org.apache.http.impl;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.TokenIterator;
import org.apache.http.protocol.HttpContext;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/DefaultConnectionReuseStrategy.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public DefaultConnectionReuseStrategy() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.ConnectionReuseStrategy
    public boolean keepAlive(HttpResponse response, HttpContext context) {
        throw new RuntimeException("Stub!");
    }

    protected TokenIterator createTokenIterator(HeaderIterator hit) {
        throw new RuntimeException("Stub!");
    }
}
