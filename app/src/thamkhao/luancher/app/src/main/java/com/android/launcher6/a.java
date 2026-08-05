package com.android.launcher6;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f100a;
    private boolean b;
    private lf d;
    private boolean e = false;
    private Handler c = new Handler();

    public void a() {
        this.f100a = 0L;
        this.e = false;
    }

    public void a(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.e = true;
        this.f100a = jCurrentTimeMillis + j;
        if (this.b) {
            return;
        }
        this.c.postDelayed(this, this.f100a - jCurrentTimeMillis);
        this.b = true;
    }

    public void a(lf lfVar) {
        this.d = lfVar;
    }

    public boolean b() {
        return this.e;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b = false;
        if (this.f100a != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.f100a > jCurrentTimeMillis) {
                this.c.postDelayed(this, Math.max(0L, this.f100a - jCurrentTimeMillis));
                this.b = true;
            } else {
                this.e = false;
                if (this.d != null) {
                    this.d.a(this);
                }
            }
        }
    }
}
