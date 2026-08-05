package com.android.internal.http.multipart;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: Launcher3.apk:libs/org.apache.http.legacy.jar:com/android/internal/http/multipart/PartSource.class */
public interface PartSource {
    long getLength();

    String getFileName();

    InputStream createInputStream() throws IOException;
}
