package com.android.launcher6;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.util.LongSparseArray;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MemoryTracker extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f90a = MemoryTracker.class.getSimpleName();
    ActivityManager e;
    public final LongSparseArray b = new LongSparseArray();
    public final ArrayList c = new ArrayList();
    private int[] f = new int[0];
    private final Object g = new Object();
    Handler d = new lb(this);
    private final IBinder h = new lc(this);

    public static void a(Context context, String str) {
        context.startService(new Intent(context, (Class<?>) MemoryTracker.class).setAction("com.android.launcher6.action.START_TRACKING").putExtra("pid", Process.myPid()).putExtra("name", str));
    }

    public ld a(int i) {
        return (ld) this.b.get(i);
    }

    public void a(int i, String str, long j) {
        synchronized (this.g) {
            Long l = new Long(i);
            if (this.c.contains(l)) {
                return;
            }
            this.c.add(l);
            b();
            this.b.put(i, new ld(i, str, j));
        }
    }

    public int[] a() {
        return this.f;
    }

    void b() {
        int size = this.c.size();
        this.f = new int[size];
        StringBuffer stringBuffer = new StringBuffer("Now tracking processes: ");
        for (int i = 0; i < size; i++) {
            int iIntValue = ((Long) this.c.get(i)).intValue();
            this.f[i] = iIntValue;
            stringBuffer.append(iIntValue);
            stringBuffer.append(" ");
        }
        Log.v(f90a, stringBuffer.toString());
    }

    void c() {
        synchronized (this.g) {
            Debug.MemoryInfo[] processMemoryInfo = this.e.getProcessMemoryInfo(this.f);
            for (int i = 0; i < processMemoryInfo.length; i++) {
                Debug.MemoryInfo memoryInfo = processMemoryInfo[i];
                if (i > this.c.size()) {
                    Log.e(f90a, "update: unknown process info received: " + memoryInfo);
                    break;
                }
                long jIntValue = ((Long) this.c.get(i)).intValue();
                ld ldVar = (ld) this.b.get(jIntValue);
                ldVar.i = (ldVar.i + 1) % ldVar.f.length;
                long[] jArr = ldVar.f;
                int i2 = ldVar.i;
                long totalPss = memoryInfo.getTotalPss();
                ldVar.d = totalPss;
                jArr[i2] = totalPss;
                long[] jArr2 = ldVar.g;
                int i3 = ldVar.i;
                long totalPrivateDirty = memoryInfo.getTotalPrivateDirty();
                ldVar.e = totalPrivateDirty;
                jArr2[i3] = totalPrivateDirty;
                if (ldVar.d > ldVar.h) {
                    ldVar.h = ldVar.d;
                }
                if (ldVar.e > ldVar.h) {
                    ldVar.h = ldVar.e;
                }
                if (ldVar.d == 0) {
                    Log.v(f90a, "update: pid " + jIntValue + " has pss=0, it probably died");
                    this.b.remove(jIntValue);
                }
            }
            for (int size = this.c.size() - 1; size >= 0; size--) {
                if (this.b.get(((Long) this.c.get(size)).intValue()) == null) {
                    this.c.remove(size);
                    b();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.d.sendEmptyMessage(1);
        return this.h;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.e = (ActivityManager) getSystemService("activity");
        for (ActivityManager.RunningServiceInfo runningServiceInfo : this.e.getRunningServices(256)) {
            if (runningServiceInfo.service.getPackageName().equals(getPackageName())) {
                Log.v(f90a, "discovered running service: " + runningServiceInfo.process + " (" + runningServiceInfo.pid + ")");
                a(runningServiceInfo.pid, runningServiceInfo.process, System.currentTimeMillis() - (SystemClock.elapsedRealtime() - runningServiceInfo.activeSince));
            }
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : this.e.getRunningAppProcesses()) {
            String str = runningAppProcessInfo.processName;
            if (str.startsWith(getPackageName())) {
                Log.v(f90a, "discovered other running process: " + str + " (" + runningAppProcessInfo.pid + ")");
                a(runningAppProcessInfo.pid, str, System.currentTimeMillis());
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.d.sendEmptyMessage(2);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.v(f90a, "Received start id " + i2 + ": " + intent);
        if (intent != null && "com.android.launcher6.action.START_TRACKING".equals(intent.getAction())) {
            a(intent.getIntExtra("pid", -1), intent.getStringExtra("name"), intent.getLongExtra("start", System.currentTimeMillis()));
        }
        this.d.sendEmptyMessage(1);
        return 1;
    }
}
