package org.apache.http.impl.entity;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.SessionInputBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/entity/EntityDeserializer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class EntityDeserializer {
    public EntityDeserializer(ContentLengthStrategy lenStrategy) {
        throw new RuntimeException("Stub!");
    }

    protected BasicHttpEntity doDeserialize(SessionInputBuffer inbuffer, HttpMessage message) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    public HttpEntity deserialize(SessionInputBuffer inbuffer, HttpMessage message) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }
}
