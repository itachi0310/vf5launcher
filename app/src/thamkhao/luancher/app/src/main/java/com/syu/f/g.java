package com.syu.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import java.util.Random;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public class g implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f528a;
    final int b;
    SparseArray c;
    com.syu.c.g d;
    Context e;
    HandlerThread f;
    Handler g;
    boolean h;
    String i;
    String j;

    public g(Context context) {
        this(context, null, null);
    }

    public g(Context context, String str, String str2) {
        this.f528a = 1500;
        this.b = HttpStatus.SC_INTERNAL_SERVER_ERROR;
        this.c = new SparseArray();
        this.f = new HandlerThread("remote connection");
        this.h = true;
        this.e = context.getApplicationContext();
        this.f.start();
        this.g = new Handler(this.f.getLooper());
        this.i = str;
        this.j = str2;
    }

    public int a(int i, int i2, int i3, int i4) {
        f fVar = (f) this.c.get(i);
        return fVar != null ? fVar.a(i2, i3, i4) : i2;
    }

    public void a() {
        this.h = true;
        if (this.i == null || this.i.isEmpty()) {
            this.i = "com.syu.ms.toolkit";
        }
        if (this.j == null || this.j.isEmpty()) {
            this.j = "com.syu.ms";
        }
        Intent intent = new Intent(this.i);
        intent.setPackage(this.j);
        this.e.bindService(intent, this, 1);
        Handler handler = new Handler();
        handler.postDelayed(new h(this, handler), new Random().nextInt(1500) + HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    public void a(int i, int i2, int... iArr) {
        f fVar = (f) this.c.get(i);
        if (fVar != null) {
            try {
                com.syu.c.d dVarC = fVar.c();
                if (dVarC != null) {
                    dVarC.a(i2, iArr, null, null);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(int i, int i2, String... strArr) {
        f fVar = (f) this.c.get(i);
        if (fVar != null) {
            try {
                com.syu.c.d dVarC = fVar.c();
                if (dVarC != null) {
                    dVarC.a(i2, null, null, strArr);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(int i, e eVar) {
        f fVar = (f) this.c.get(i);
        if (fVar != null) {
            fVar.a(eVar);
        }
    }

    public void a(int i, e eVar, int... iArr) {
        f fVar = (f) this.c.get(i);
        if (fVar != null) {
            fVar.a(eVar, iArr);
        }
    }

    public void a(int i, int... iArr) {
        if (iArr == null) {
            return;
        }
        this.g.post(new k(this, (f) this.c.get(i), iArr));
    }

    public void b(int i, int... iArr) {
        this.c.put(i, new l(this, iArr));
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            this.d = com.syu.c.h.a(iBinder);
            if (this.d == null || this.c.size() <= 0) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                this.g.post(new i(this, this.c.keyAt(i)));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (this.h) {
            this.d = null;
            a();
        } else if (this.d != null) {
            if (this.c.size() > 0) {
                this.g.post(new j(this));
            }
            this.d = null;
        }
    }
}
