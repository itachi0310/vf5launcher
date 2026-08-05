package org.apache.http;

import org.apache.http.util.CharArrayBuffer;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/FormattedHeader.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface FormattedHeader extends Header {
    CharArrayBuffer getBuffer();

    int getValuePos();
}
