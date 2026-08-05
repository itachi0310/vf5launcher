package com.android.launcher6;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes.dex */
class oe extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ of f432a;
    private final /* synthetic */ String b;

    oe(of ofVar, String str) {
        this.f432a = ofVar;
        this.b = str;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        this.f432a.getWritableDatabase().delete("shortcut_and_widget_previews", "name = ? ", new String[]{this.b});
        return null;
    }
}
