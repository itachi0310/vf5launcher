package com.android.internal.http.multipart;

import java.io.InputStream;

/* JADX INFO: loaded from: Launcher3.apk:libs/org.apache.http.legacy.jar:com/android/internal/http/multipart/ByteArrayPartSource.class */
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
