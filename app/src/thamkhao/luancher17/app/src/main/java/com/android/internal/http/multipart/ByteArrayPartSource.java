package com.android.internal.http.multipart;

import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:com/android/internal/http/multipart/ByteArrayPartSource.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class ByteArrayPartSource implements PartSource {
    public ByteArrayPartSource(String fileName, byte[] bytes) {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.PartSource
    public long getLength() {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.PartSource
    public String getFileName() {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.PartSource
    public InputStream createInputStream() {
        throw new RuntimeException("Stub!");
    }
}
