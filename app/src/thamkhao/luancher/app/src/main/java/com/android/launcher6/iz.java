package com.android.launcher6;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class iz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ iv f320a;
    private final /* synthetic */ ContentResolver b;
    private final /* synthetic */ Uri c;
    private final /* synthetic */ ArrayList d;

    iz(iv ivVar, ContentResolver contentResolver, Uri uri, ArrayList arrayList) {
        this.f320a = ivVar;
        this.b = contentResolver;
        this.c = uri;
        this.d = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.delete(this.c, null, null);
        int size = this.d.size();
        ContentValues[] contentValuesArr = new ContentValues[size];
        for (int i = 0; i < size; i++) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Long.valueOf(((Long) this.d.get(i)).longValue()));
            contentValues.put("screenRank", Integer.valueOf(i));
            contentValuesArr[i] = contentValues;
        }
        this.b.bulkInsert(this.c, contentValuesArr);
        synchronized (iv.c) {
            iv.i.clear();
            iv.i.addAll(this.d);
        }
    }
}
