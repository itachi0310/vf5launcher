package android.support.v4.content;

import android.os.AsyncTask;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/ExecutorCompatHoneycomb.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ExecutorCompatHoneycomb {
    ExecutorCompatHoneycomb() {
    }

    public static Executor getParallelExecutor() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }
}
