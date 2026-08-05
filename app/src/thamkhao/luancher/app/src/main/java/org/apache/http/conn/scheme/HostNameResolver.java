package org.apache.http.conn.scheme;

import java.net.InetAddress;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/scheme/HostNameResolver.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HostNameResolver {
    InetAddress resolve(String str);
}
