package com.vf5regen;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import android.util.SparseArray;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteModule;
import com.syu.ipc.IRemoteToolkit;

public class Module5Manager {
    private static Module5Manager instance;
    private IRemoteToolkit remoteToolkit;
    private Context context;
    private boolean isServiceConnected = false;
    private final SparseArray<IRemoteModule> activeModules = new SparseArray<>();
    private final SparseArray<PerModuleCallback> activeCallbacks = new SparseArray<>();
    private boolean isScanning = false;

    private static final String tag = "VF5Regen_Scanner";

    public interface OnExplorerListener {
        void onDataUpdate(int moduleId, int code, int value);
        void onServiceStatus(boolean connected);
        void onNewModuleDiscovered(int moduleId);
    }

    private OnExplorerListener listener;

    public static synchronized Module5Manager getInstance(Context ctx) {
        if (instance == null) instance = new Module5Manager(ctx);
        return instance;
    }

    private Module5Manager(Context ctx) {
        this.context = ctx.getApplicationContext();
        bindToService();
    }

    private void bindToService() {
        Intent intent = new Intent("com.syu.ms.toolkit");
        intent.setPackage("com.syu.ms");
        context.bindService(intent, mConn, Context.BIND_AUTO_CREATE);
    }

    private final ServiceConnection mConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            isServiceConnected = true;
            remoteToolkit = IRemoteToolkit.Stub.asInterface(service);
            if (listener != null) listener.onServiceStatus(true);
            Log.d(tag, "Service Connected.");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isServiceConnected = false;
            activeModules.clear();
            activeCallbacks.clear();
            if (listener != null) listener.onServiceStatus(false);
        }
    };

    public void startScan(int min, int max) {
        if (!isServiceConnected || remoteToolkit == null || isScanning) return;
        
        stopScan(); 
        isScanning = true;

        new Thread(() -> {
            try {
                for (int m = min; m <= max; m++) {
                    if (!isServiceConnected || remoteToolkit == null || !isScanning) break;
                    
                    try {
                        IRemoteModule mod = remoteToolkit.getRemoteModule(m);
                        if (mod != null) {
                            activeModules.put(m, mod);
                            if (listener != null) listener.onNewModuleDiscovered(m);
                            
                            PerModuleCallback cb = new PerModuleCallback(m);
                            activeCallbacks.put(m, cb);
                            
                            for (int i = 0; i <= 1000; i++) {
                                mod.register(cb, i, 1);
                            }
                            Log.d(tag, "Connected and registered Module: " + m);
                        }
                    } catch (Exception e) {
                        // ignore
                    }
                    Thread.sleep(20); 
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                isScanning = false;
            }
        }).start();
    }

    public void stopScan() {
        isScanning = false;
        try {
            for (int i = 0; i < activeModules.size(); i++) {
                int mId = activeModules.keyAt(i);
                IRemoteModule mod = activeModules.valueAt(i);
                PerModuleCallback cb = activeCallbacks.get(mId);
                if (mod != null && cb != null) {
                    for (int j = 0; j <= 1000; j++) {
                        mod.unregister(cb, j);
                    }
                }
            }
        } catch (Exception e) {
            Log.e(tag, "Error unregistering modules", e);
        }
        activeModules.clear();
        activeCallbacks.clear();
    }

    public void connect(OnExplorerListener listener) {
        this.listener = listener;
    }

    private class PerModuleCallback extends IModuleCallback.Stub {
        private final int moduleId;
        public PerModuleCallback(int id) { this.moduleId = id; }
        @Override
        public void update(int code, int[] ints, float[] flts, String[] strs) {
            if (ints != null && ints.length > 0 && listener != null) {
                listener.onDataUpdate(moduleId, code, ints[0]);
            }
        }
    }
}
