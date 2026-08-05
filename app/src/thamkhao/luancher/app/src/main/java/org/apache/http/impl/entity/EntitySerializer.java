package org.apache.http.impl.entity;

import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.SessionOutputBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/entity/EntitySerializer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class EntitySerializer {
    public EntitySerializer(ContentLengthStrategy contentLengthStrategy) {
        throw new RuntimeException("Stub!");
    }

    protected OutputStream doSerialize(SessionOutputBuffer sessionOutputBuffer, HttpMessage httpMessage) {
        throw new RuntimeException("Stub!");
    }

    public void serialize(SessionOutputBuffer sessionOutputBuffer, HttpMessage httpMessage, HttpEntity httpEntity) {
        throw new RuntimeException("Stub!");
    }
}
