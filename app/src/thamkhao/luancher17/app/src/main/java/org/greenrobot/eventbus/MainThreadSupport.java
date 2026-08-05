package org.greenrobot.eventbus;

import android.os.Looper;

/* JADX INFO: loaded from: 190001025_com.android.launcher17.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/MainThreadSupport.class */
public interface MainThreadSupport {
    boolean isMainThread();

    Poster createPoster(EventBus eventBus);

    /* JADX INFO: loaded from: 190001025_com.android.launcher17.apk:libs/eventbus-3.1.1.jar:org/greenrobot/eventbus/MainThreadSupport$AndroidHandlerMainThreadSupport.class */
    public static class AndroidHandlerMainThreadSupport implements MainThreadSupport {
        private final Looper looper;

        public AndroidHandlerMainThreadSupport(Looper looper) {
            this.looper = looper;
        }

        @Override // org.greenrobot.eventbus.MainThreadSupport
        public boolean isMainThread() {
            return this.looper == Looper.myLooper();
        }

        @Override // org.greenrobot.eventbus.MainThreadSupport
        public Poster createPoster(EventBus eventBus) {
            return new HandlerPoster(eventBus, this.looper, 10);
        }
    }
}
