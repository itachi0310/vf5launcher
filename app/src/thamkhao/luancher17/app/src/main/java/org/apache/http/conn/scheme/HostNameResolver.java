package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/conn/scheme/HostNameResolver.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HostNameResolver {
    InetAddress resolve(String str) throws IOException;
}
