package org.apache.http.impl.entity;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.SessionOutputBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/entity/EntitySerializer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class EntitySerializer {
    public EntitySerializer(ContentLengthStrategy lenStrategy) {
        throw new RuntimeException("Stub!");
    }

    protected OutputStream doSerialize(SessionOutputBuffer outbuffer, HttpMessage message) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }

    public void serialize(SessionOutputBuffer outbuffer, HttpMessage message, HttpEntity entity) throws HttpException, IOException {
        throw new RuntimeException("Stub!");
    }
}
