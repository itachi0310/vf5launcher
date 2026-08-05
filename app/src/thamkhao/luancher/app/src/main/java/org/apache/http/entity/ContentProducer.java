package org.apache.http.entity;

import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/entity/ContentProducer.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ContentProducer {
    void writeTo(OutputStream outputStream);
}
