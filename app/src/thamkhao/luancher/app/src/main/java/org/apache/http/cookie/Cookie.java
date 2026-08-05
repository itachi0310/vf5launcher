package org.apache.http.cookie;

import java.util.Date;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/cookie/Cookie.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface Cookie {
    String getComment();

    String getCommentURL();

    String getDomain();

    Date getExpiryDate();

    String getName();

    String getPath();

    int[] getPorts();

    String getValue();

    int getVersion();

    boolean isExpired(Date date);

    boolean isPersistent();

    boolean isSecure();
}
