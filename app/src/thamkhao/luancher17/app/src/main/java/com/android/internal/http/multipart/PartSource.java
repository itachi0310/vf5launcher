package com.android.internal.http.multipart;

import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:com/android/internal/http/multipart/PartSource.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public interface PartSource {
    InputStream createInputStream() throws IOException;

    String getFileName();

    long getLength();
}
