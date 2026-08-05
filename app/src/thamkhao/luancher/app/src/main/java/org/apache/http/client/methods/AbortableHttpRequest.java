package org.apache.http.client.methods;

import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/client/methods/AbortableHttpRequest.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface AbortableHttpRequest {
    void abort();

    void setConnectionRequest(ClientConnectionRequest clientConnectionRequest);

    void setReleaseTrigger(ConnectionReleaseTrigger connectionReleaseTrigger);
}
