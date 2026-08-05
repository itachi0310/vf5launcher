package android.support.v4.os;

import android.os.AsyncTask;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/os/AsyncTaskCompatHoneycomb.class */
class AsyncTaskCompatHoneycomb {
    AsyncTaskCompatHoneycomb() {
    }

    static <Params, Progress, Result> void executeParallel(AsyncTask<Params, Progress, Result> task, Params... params) {
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
    }
}
