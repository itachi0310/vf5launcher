package com.android.launcher6;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class jl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ArrayList f332a;
    private final /* synthetic */ ArrayList b;
    private final /* synthetic */ StackTraceElement[] c;
    private final /* synthetic */ ContentResolver d;

    jl(ArrayList arrayList, ArrayList arrayList2, StackTraceElement[] stackTraceElementArr, ContentResolver contentResolver) {
        this.f332a = arrayList;
        this.b = arrayList2;
        this.c = stackTraceElementArr;
        this.d = contentResolver;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        int size = this.f332a.size();
        for (int i = 0; i < size; i++) {
            ec ecVar = (ec) this.f332a.get(i);
            long j = ecVar.f;
            arrayList.add(ContentProviderOperation.newUpdate(kq.a(j, false)).withValues((ContentValues) this.b.get(i)).build());
            iv.a(ecVar, j, this.c);
        }
        try {
            this.d.applyBatch("com.android.launcher6.settings", arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
