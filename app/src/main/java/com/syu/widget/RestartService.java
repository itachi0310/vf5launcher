package com.syu.widget;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class RestartService extends Service {
    Handler mHandler = new Handler();
    Runnable run = new Runnable() { // from class: com.syu.widget.RestartService.1
        @Override // java.lang.Runnable
        public void run() {
            RestartService.this.mHandler.removeCallbacks(RestartService.this.run);
            RestartService.this.mHandler.postDelayed(RestartService.this.run, 500L);
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
