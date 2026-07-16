package com.syu.module;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import com.syu.ipc.IRemoteToolkit;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class MsToolkitConnection implements ServiceConnection {
    private static final MsToolkitConnection INSTANCE = new MsToolkitConnection();
    static Looper looper;
    private boolean mConnecting;
    private Context mContext;
    private IRemoteToolkit mRemoteToolkit;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<ConnectionObserver> mConnectionObservers = new ArrayList<>();
    private Runnable mRunnableConnect = new Runnable() { // from class: com.syu.module.MsToolkitConnection.1
        @Override // java.lang.Runnable
        public void run() {
            if (MsToolkitConnection.this.mRemoteToolkit != null) {
                MsToolkitConnection.this.mConnecting = false;
                return;
            }
            Intent intent = new Intent("com.syu.ms.toolkit");
            intent.setComponent(new ComponentName("com.syu.ms", "app.ToolkitService"));
            MsToolkitConnection.this.mContext.bindService(intent, MsToolkitConnection.INSTANCE, 1);
            MsToolkitConnection.this.mHandler.postDelayed(this, new Random().nextInt(3000) + 1000);
        }
    };

    static {
        HandlerThread thread = new HandlerThread("ConnectionThread");
        thread.start();
        looper = thread.getLooper();
    }

    public static MsToolkitConnection getInstance() {
        return INSTANCE;
    }

    private MsToolkitConnection() {
    }

    public IRemoteToolkit getRemoteToolkit() {
        return this.mRemoteToolkit;
    }

    public void connect(Context context) {
        connect(context, 0L);
    }

    private synchronized void connect(Context context, long delayMillis) {
        if (!this.mConnecting && this.mRemoteToolkit == null && context != null) {
            this.mContext = context.getApplicationContext();
            this.mConnecting = true;
            this.mHandler.post(this.mRunnableConnect);
        }
    }

    public synchronized void addObserver(ConnectionObserver observer) {
        if (observer != null) {
            if (!this.mConnectionObservers.contains(observer)) {
                this.mConnectionObservers.add(observer);
                if (this.mRemoteToolkit != null) {
                    this.mHandler.post(new OnServiceConnected(this, observer, null));
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000c A[Catch: all -> 0x0019, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:5:0x0008, B:7:0x000c), top: B:13:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void removeObserver(com.syu.module.ConnectionObserver r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 == 0) goto L8
            java.util.ArrayList<com.syu.module.ConnectionObserver> r0 = r3.mConnectionObservers     // Catch: java.lang.Throwable -> L19
            r0.remove(r4)     // Catch: java.lang.Throwable -> L19
        L8:
            com.syu.ipc.IRemoteToolkit r0 = r3.mRemoteToolkit     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L17
            android.os.Handler r0 = r3.mHandler     // Catch: java.lang.Throwable -> L19
            com.syu.module.MsToolkitConnection$OnServiceDisconnected r1 = new com.syu.module.MsToolkitConnection$OnServiceDisconnected     // Catch: java.lang.Throwable -> L19
            r2 = 0
            r1.<init>(r3, r4, r2)     // Catch: java.lang.Throwable -> L19
            r0.post(r1)     // Catch: java.lang.Throwable -> L19
        L17:
            monitor-exit(r3)
            return
        L19:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.syu.module.MsToolkitConnection.removeObserver(com.syu.module.ConnectionObserver):void");
    }

    public synchronized void clearObservers() {
        if (this.mRemoteToolkit != null) {
            for (ConnectionObserver observer : this.mConnectionObservers) {
                this.mHandler.post(new OnServiceDisconnected(this, observer, null));
            }
        }
        this.mConnectionObservers.clear();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName name, IBinder service) {
        this.mRemoteToolkit = IRemoteToolkit.Stub.asInterface(service);
        for (ConnectionObserver observer : this.mConnectionObservers) {
            this.mHandler.post(new OnServiceConnected(this, observer, null));
        }
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName name) {
        this.mRemoteToolkit = null;
        for (ConnectionObserver observer : this.mConnectionObservers) {
            this.mHandler.post(new OnServiceDisconnected(this, observer, null));
        }
        connect(this.mContext, new Random().nextInt(3000) + 1000);
    }

    private class OnServiceConnected implements Runnable {
        private ConnectionObserver observer;

        private OnServiceConnected(ConnectionObserver observer) {
            this.observer = observer;
        }

        /* synthetic */ OnServiceConnected(MsToolkitConnection msToolkitConnection, ConnectionObserver connectionObserver, OnServiceConnected onServiceConnected) {
            this(connectionObserver);
        }

        @Override // java.lang.Runnable
        public void run() {
            IRemoteToolkit toolkit = MsToolkitConnection.this.mRemoteToolkit;
            if (toolkit != null && this.observer != null) {
                this.observer.onConnected(toolkit);
            }
        }
    }

    private class OnServiceDisconnected implements Runnable {
        private ConnectionObserver observer;

        private OnServiceDisconnected(ConnectionObserver observer) {
            this.observer = observer;
        }

        /* synthetic */ OnServiceDisconnected(MsToolkitConnection msToolkitConnection, ConnectionObserver connectionObserver, OnServiceDisconnected onServiceDisconnected) {
            this(connectionObserver);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.observer != null) {
                this.observer.onDisconnected();
            }
        }
    }
}
