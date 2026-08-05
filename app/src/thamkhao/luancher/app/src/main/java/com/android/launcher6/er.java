package com.android.launcher6;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes.dex */
class er extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f209a;

    er(Launcher launcher) {
        this.f209a = launcher;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ie doInBackground(Void... voidArr) throws Throwable {
        ie ieVar = new ie(null);
        Launcher.c(this.f209a, ieVar);
        return ieVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(ie ieVar) {
        Launcher.bV = ieVar;
        this.f209a.ap();
    }
}
