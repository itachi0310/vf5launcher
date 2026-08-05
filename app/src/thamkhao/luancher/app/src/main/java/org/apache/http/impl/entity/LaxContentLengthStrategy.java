package org.apache.http.impl.entity;

import org.apache.http.HttpMessage;
import org.apache.http.entity.ContentLengthStrategy;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/entity/LaxContentLengthStrategy.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class LaxContentLengthStrategy implements ContentLengthStrategy {
    public LaxContentLengthStrategy() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage) {
        throw new RuntimeException("Stub!");
    }
}
