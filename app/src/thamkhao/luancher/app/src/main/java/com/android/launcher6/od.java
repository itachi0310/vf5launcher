package com.android.launcher6;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes.dex */
class od extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ of f431a;
    private final /* synthetic */ String b;

    od(of ofVar, String str) {
        this.f431a = ofVar;
        this.b = str;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        this.f431a.getWritableDatabase().delete("shortcut_and_widget_previews", "name LIKE ? OR name LIKE ?", new String[]{"Widget:" + this.b + "/%", "Shortcut:" + this.b + "/%"});
        synchronized (ob.v) {
            ob.v.remove(this.b);
        }
        return null;
    }
}
