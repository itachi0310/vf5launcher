package com.android.launcher6;

import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
class bc extends Handler implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ba f126a;

    private bc(ba baVar) {
        this.f126a = baVar;
    }

    /* synthetic */ bc(ba baVar, bc bcVar) {
        this(baVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        synchronized (this.f126a.f124a) {
            if (this.f126a.f124a.size() == 0) {
                return;
            }
            ((Runnable) ((Pair) this.f126a.f124a.removeFirst()).first).run();
            synchronized (this.f126a.f124a) {
                this.f126a.b();
            }
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        handleMessage(null);
        return false;
    }
}
