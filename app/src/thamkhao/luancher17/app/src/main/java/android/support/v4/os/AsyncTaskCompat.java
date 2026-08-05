package android.support.v4.os;

import android.os.AsyncTask;
import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/os/AsyncTaskCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncTaskCompat {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> executeParallel(AsyncTask<Params, Progress, Result> task, Params... params) {
        if (task == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (Build.VERSION.SDK_INT >= 11) {
            AsyncTaskCompatHoneycomb.executeParallel(task, params);
        } else {
            task.execute(params);
        }
        return task;
    }

    private AsyncTaskCompat() {
    }
}
