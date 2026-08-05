package com.android.launcher6;

import android.os.AsyncTask;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
class h extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    z f272a;
    int b;
    int c = 0;

    h(int i, z zVar) {
        this.b = i;
        this.f272a = zVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public y doInBackground(y... yVarArr) {
        if (yVarArr.length != 1) {
            return null;
        }
        yVarArr[0].f.a(this, yVarArr[0]);
        return yVarArr[0];
    }

    void a() {
        Process.setThreadPriority(this.c);
    }

    void a(int i) {
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(y yVar) {
        yVar.g.a(this, yVar);
    }
}
