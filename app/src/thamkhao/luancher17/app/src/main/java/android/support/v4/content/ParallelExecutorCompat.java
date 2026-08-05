package android.support.v4.content;

import android.os.Build;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/ParallelExecutorCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class ParallelExecutorCompat {
    public static Executor getParallelExecutor() {
        return Build.VERSION.SDK_INT >= 11 ? ExecutorCompatHoneycomb.getParallelExecutor() : ModernAsyncTask.THREAD_POOL_EXECUTOR;
    }

    private ParallelExecutorCompat() {
    }
}
