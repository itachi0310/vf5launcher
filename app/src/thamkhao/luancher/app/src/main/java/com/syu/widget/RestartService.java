package com.syu.widget;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class RestartService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f554a = new Handler();
    Runnable b = new a(this);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
