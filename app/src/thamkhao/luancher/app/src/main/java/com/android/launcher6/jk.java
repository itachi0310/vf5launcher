package com.android.launcher6;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
class jk implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ContentResolver f331a;
    private final /* synthetic */ Uri b;
    private final /* synthetic */ ContentValues c;
    private final /* synthetic */ ec d;
    private final /* synthetic */ long e;
    private final /* synthetic */ StackTraceElement[] f;

    jk(ContentResolver contentResolver, Uri uri, ContentValues contentValues, ec ecVar, long j, StackTraceElement[] stackTraceElementArr) {
        this.f331a = contentResolver;
        this.b = uri;
        this.c = contentValues;
        this.d = ecVar;
        this.e = j;
        this.f = stackTraceElementArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f331a.update(this.b, this.c, null, null);
        iv.a(this.d, this.e, this.f);
    }
}
