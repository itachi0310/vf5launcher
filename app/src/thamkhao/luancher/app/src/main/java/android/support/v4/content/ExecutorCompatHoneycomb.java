package android.support.v4.content;

import android.os.AsyncTask;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/content/ExecutorCompatHoneycomb.class */
class ExecutorCompatHoneycomb {
    ExecutorCompatHoneycomb() {
    }

    public static Executor getParallelExecutor() {
        return AsyncTask.THREAD_POOL_EXECUTOR;
    }
}
