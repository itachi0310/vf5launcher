package com.android.launcher17;

import android.os.AsyncTask;
import android.os.Process;

/* JADX INFO: compiled from: AppsCustomizePagedView.java */
/* JADX INFO: loaded from: classes.dex */
class AppsCustomizeAsyncTask extends AsyncTask<AsyncTaskPageData, Void, AsyncTaskPageData> {
    AsyncTaskPageData.Type dataType;
    int page;
    int threadPriority = 0;

    AppsCustomizeAsyncTask(int p, AsyncTaskPageData.Type ty) {
        this.page = p;
        this.dataType = ty;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public AsyncTaskPageData doInBackground(AsyncTaskPageData... params) {
        if (params.length != 1) {
            return null;
        }
        params[0].doInBackgroundCallback.run(this, params[0]);
        return params[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(AsyncTaskPageData result) {
        result.postExecuteCallback.run(this, result);
    }

    void setThreadPriority(int p) {
        this.threadPriority = p;
    }

    void syncThreadPriority() {
        Process.setThreadPriority(this.threadPriority);
    }
}
