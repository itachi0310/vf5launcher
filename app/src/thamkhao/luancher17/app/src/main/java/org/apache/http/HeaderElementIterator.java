package org.apache.http;

import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/HeaderElementIterator.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface HeaderElementIterator extends Iterator {
    @Override // java.util.Iterator
    boolean hasNext();

    HeaderElement nextElement();
}
