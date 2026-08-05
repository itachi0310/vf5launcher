package com.android.internal.http.multipart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:com/android/internal/http/multipart/FilePartSource.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class FilePartSource implements PartSource {
    public FilePartSource(File file) throws FileNotFoundException {
        throw new RuntimeException("Stub!");
    }

    public FilePartSource(String fileName, File file) throws FileNotFoundException {
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
    public InputStream createInputStream() throws IOException {
        throw new RuntimeException("Stub!");
    }
}
