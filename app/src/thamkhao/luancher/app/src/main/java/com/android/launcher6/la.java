package com.android.launcher6;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class la implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f367a;
    private final /* synthetic */ Runnable b;

    la(Context context, Runnable runnable) {
        this.f367a = context;
        this.b = runnable;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.v("MemoryDumpActivity", "service connected, dumping...");
        MemoryDumpActivity.a(this.f367a, ((lc) iBinder).a());
        this.f367a.unbindService(this);
        if (this.b != null) {
            this.b.run();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
