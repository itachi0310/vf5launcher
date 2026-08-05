package org.apache.http.protocol;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/protocol/HttpContext.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HttpContext {
    public static final String RESERVED_PREFIX = "http.";

    Object getAttribute(String str);

    Object removeAttribute(String str);

    void setAttribute(String str, Object obj);
}
