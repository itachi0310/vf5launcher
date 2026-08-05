package com.android.c.a;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
class c extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f63a;

    private c(a aVar) {
        this.f63a = aVar;
    }

    /* synthetic */ c(a aVar, c cVar) {
        this(aVar);
    }

    private b b() {
        b bVarA;
        synchronized (this.f63a.t) {
            while (true) {
                bVarA = this.f63a.w.a();
                if (bVarA == null) {
                    this.f63a.t.wait();
                }
            }
        }
        return bVarA;
    }

    public void a() {
        interrupt();
        try {
            join();
        } catch (InterruptedException e) {
            Log.w("TiledImageRenderer", "Interrupted while waiting for TileDecoder thread to finish!");
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!isInterrupted()) {
            try {
                this.f63a.b(b());
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
