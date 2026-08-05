package org.apache.http.impl.entity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.SessionInputBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/entity/EntityDeserializer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class EntityDeserializer {
    public EntityDeserializer(ContentLengthStrategy contentLengthStrategy) {
        throw new RuntimeException("Stub!");
    }

    public HttpEntity deserialize(SessionInputBuffer sessionInputBuffer, HttpMessage httpMessage) {
        throw new RuntimeException("Stub!");
    }

    protected BasicHttpEntity doDeserialize(SessionInputBuffer sessionInputBuffer, HttpMessage httpMessage) {
        throw new RuntimeException("Stub!");
    }
}
