package org.litepal.crud.async;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncExecutor {
    private Runnable pendingTask;

    public void submit(Runnable task) {
        this.pendingTask = task;
    }

    void execute() {
        if (this.pendingTask != null) {
            new Thread(this.pendingTask).start();
        }
    }
}
