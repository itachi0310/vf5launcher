package com.android.launcher6;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
final class kq implements ko {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Uri f358a = Uri.parse("content://com.android.launcher6.settings/favorites?notify=true");
    static final Uri b = Uri.parse("content://com.android.launcher6.settings/favorites?notify=true");
    static final Uri c = Uri.parse("content://com.android.launcher6.settings/favorites?notify=false");

    static Uri a(long j, boolean z) {
        return Uri.parse("content://com.android.launcher6.settings/favorites/" + j + "?notify=" + z);
    }
}
