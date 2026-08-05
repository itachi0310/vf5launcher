package com.android.launcher6;

import android.graphics.Bitmap;
import android.os.AsyncTask;

/* JADX INFO: loaded from: classes.dex */
class oc extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ob f430a;
    private final /* synthetic */ Object b;
    private final /* synthetic */ Bitmap c;

    oc(ob obVar, Object obj, Bitmap bitmap) {
        this.f430a = obVar;
        this.b = obj;
        this.c = bitmap;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        this.f430a.c(this.b, this.c);
        return null;
    }
}
