package org.apache.http;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/HttpVersion.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class HttpVersion extends ProtocolVersion implements Serializable {
    public static final String HTTP = "HTTP";
    public static final HttpVersion HTTP_0_9 = null;
    public static final HttpVersion HTTP_1_0 = null;
    public static final HttpVersion HTTP_1_1 = null;

    public HttpVersion(int major, int minor) {
        super((String) null, 0, 0);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.ProtocolVersion
    public ProtocolVersion forVersion(int major, int minor) {
        throw new RuntimeException("Stub!");
    }
}
