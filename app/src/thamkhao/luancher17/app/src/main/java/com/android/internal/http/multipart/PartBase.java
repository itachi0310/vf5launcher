package com.android.internal.http.multipart;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/org.apache.http.legacy.jar:com/android/internal/http/multipart/PartBase.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PartBase extends Part {
    public PartBase(String name, String contentType, String charSet, String transferEncoding) {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.Part
    public String getName() {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.Part
    public String getContentType() {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.Part
    public String getCharSet() {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.Part
    public String getTransferEncoding() {
        throw new RuntimeException("Stub!");
    }

    public void setCharSet(String charSet) {
        throw new RuntimeException("Stub!");
    }

    public void setContentType(String contentType) {
        throw new RuntimeException("Stub!");
    }

    public void setName(String name) {
        throw new RuntimeException("Stub!");
    }

    public void setTransferEncoding(String transferEncoding) {
        throw new RuntimeException("Stub!");
    }
}
