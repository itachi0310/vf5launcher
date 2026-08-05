package org.apache.http.impl.entity;

import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.entity.ContentLengthStrategy;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/entity/StrictContentLengthStrategy.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class StrictContentLengthStrategy implements ContentLengthStrategy {
    public StrictContentLengthStrategy() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.entity.ContentLengthStrategy
    public long determineLength(HttpMessage message) throws HttpException {
        throw new RuntimeException("Stub!");
    }
}
