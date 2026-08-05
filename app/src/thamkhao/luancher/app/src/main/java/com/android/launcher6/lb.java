package com.android.launcher6;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
class lb extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MemoryTracker f368a;

    lb(MemoryTracker memoryTracker) {
        this.f368a = memoryTracker;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f368a.d.removeMessages(3);
                this.f368a.d.sendEmptyMessage(3);
                break;
            case 2:
                this.f368a.d.removeMessages(3);
                break;
            case 3:
                this.f368a.c();
                this.f368a.d.removeMessages(3);
                this.f368a.d.sendEmptyMessageDelayed(3, 5000L);
                break;
        }
    }
}
