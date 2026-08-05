package org.apache.http.impl;

import java.util.Locale;
import org.apache.http.ReasonPhraseCatalog;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:org/apache/http/impl/EnglishReasonPhraseCatalog.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class EnglishReasonPhraseCatalog implements ReasonPhraseCatalog {
    public static final EnglishReasonPhraseCatalog INSTANCE = null;

    protected EnglishReasonPhraseCatalog() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.ReasonPhraseCatalog
    public String getReason(int status, Locale loc) {
        throw new RuntimeException("Stub!");
    }
}
