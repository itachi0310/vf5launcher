package com.android.launcher6;

import android.content.ContentUris;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
class km {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f357a;
    public final String b;
    public final String[] c;

    km(Uri uri) {
        if (uri.getPathSegments().size() != 1) {
            throw new IllegalArgumentException("Invalid URI: " + uri);
        }
        this.f357a = uri.getPathSegments().get(0);
        this.b = null;
        this.c = null;
    }

    km(Uri uri, String str, String[] strArr) {
        if (uri.getPathSegments().size() == 1) {
            this.f357a = uri.getPathSegments().get(0);
            this.b = str;
            this.c = strArr;
        } else {
            if (uri.getPathSegments().size() != 2) {
                throw new IllegalArgumentException("Invalid URI: " + uri);
            }
            if (!TextUtils.isEmpty(str)) {
                throw new UnsupportedOperationException("WHERE clause not supported: " + uri);
            }
            this.f357a = uri.getPathSegments().get(0);
            this.b = "_id=" + ContentUris.parseId(uri);
            this.c = null;
        }
    }
}
