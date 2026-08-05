package org.greenrobot.eventbus;

import java.util.logging.Level;

/* JADX INFO: loaded from: 190001025_com.android.launcher17.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/BackgroundPoster.class */
final class BackgroundPoster implements Runnable, Poster {
    private final PendingPostQueue queue = new PendingPostQueue();
    private final EventBus eventBus;
    private volatile boolean executorRunning;

    BackgroundPoster(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override // org.greenrobot.eventbus.Poster
    public void enqueue(Subscription subscription, Object event) {
        PendingPost pendingPost = PendingPost.obtainPendingPost(subscription, event);
        synchronized (this) {
            this.queue.enqueue(pendingPost);
            if (!this.executorRunning) {
                this.executorRunning = true;
                this.eventBus.getExecutorService().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                try {
                    PendingPost pendingPost = this.queue.poll(1000);
                    if (pendingPost == null) {
                        synchronized (this) {
                            pendingPost = this.queue.poll();
                            if (pendingPost == null) {
                                this.executorRunning = false;
                                this.executorRunning = false;
                                return;
                            }
                        }
                    }
                    this.eventBus.invokeSubscriber(pendingPost);
                } catch (InterruptedException e) {
                    this.eventBus.getLogger().log(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e);
                    this.executorRunning = false;
                    return;
                }
            } catch (Throwable th) {
                this.executorRunning = false;
                throw th;
            }
        }
    }
}
