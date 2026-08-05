package com.fyt.car;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f484a = new Handler(Looper.getMainLooper());
    private final ArrayList b = new ArrayList();
    private int[] c;
    private float[] d;
    private String[] e;
    private byte[] f;
    private long[] g;

    public synchronized void a(b bVar) {
        if (bVar != null) {
            this.b.remove(bVar);
        }
    }

    public synchronized void a(b bVar, boolean z) {
        if (bVar != null) {
            if (!this.b.contains(bVar)) {
                this.b.add(bVar);
                if (z) {
                    bVar.a(this.c, this.g, this.d, this.e, this.f);
                }
            }
        }
    }

    public synchronized void a(int[] iArr, long[] jArr, float[] fArr, String[] strArr, byte[] bArr) {
        synchronized (this) {
            boolean z = Arrays.equals(this.c, iArr);
            if (z && !Arrays.equals(this.d, fArr)) {
                z = false;
            }
            if (z && !Arrays.equals(this.e, strArr)) {
                z = false;
            }
            if (z && !Arrays.equals(this.f, bArr)) {
                z = false;
            }
            boolean z2 = (!z || Arrays.equals(this.g, jArr)) ? z : false;
            this.c = iArr;
            this.d = fArr;
            this.e = strArr;
            this.f = bArr;
            this.g = jArr;
            if (!z2) {
                f484a.post(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(this.c, this.g, this.d, this.e, this.f);
        }
    }
}
