package org.apache.http.cookie;

import java.util.Date;

/* JADX WARN: Classes with same name are omitted, all sources:
  Launcher3.apk:libs/org.apache.http.legacy.jar:org/apache/http/cookie/SetCookie.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface SetCookie extends Cookie {
    void setComment(String str);

    void setDomain(String str);

    void setExpiryDate(Date date);

    void setPath(String str);

    void setSecure(boolean z);

    void setValue(String str);

    void setVersion(int i);
}
