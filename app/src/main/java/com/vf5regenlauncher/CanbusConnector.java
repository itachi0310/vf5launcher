package com.vf5regenlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteModule;
import com.syu.ipc.IRemoteToolkit;
import java.util.ArrayList;

public class CanbusConnector {
    private static final String TAG = "CanbusConnector";
    private static CanbusConnector instance;
    private IRemoteToolkit remoteToolkit;
    private final Context context;
    private final ArrayList<CanbusDataListener> listeners = new ArrayList<>();

    // Proxy bọc IRemoteModule để xử lý an toàn tương tự RemoteModuleProxy trong SYU
    public class RemoteModuleProxy {
        private IRemoteModule module;
        private final int moduleId;

        public RemoteModuleProxy(int id) { this.moduleId = id; }
        
        public void setModule(IRemoteModule module) { this.module = module; }
        
        public void cmd(int code, int[] values) {
            if (module != null) {
                try {
                    module.cmd(code, values, null, null);
                } catch (RemoteException e) {
                    Log.e(TAG, "Error in module " + moduleId + " cmd " + code, e);
                }
            } else {
                Log.w(TAG, "Module " + moduleId + " is not connected yet");
            }
        }

        public void register(IModuleCallback callback, int code, int update) {
            if (module != null) {
                try { module.register(callback, code, update); }
                catch (RemoteException e) { e.printStackTrace(); }
            }
        }
    }

    private final RemoteModuleProxy module0 = new RemoteModuleProxy(0);
    private final RemoteModuleProxy module7 = new RemoteModuleProxy(7);

    public interface CanbusDataListener {
        void onDataReceived(int moduleId, int code, int value);
    }

    public static synchronized CanbusConnector getInstance(Context context) {
        if (instance == null) instance = new CanbusConnector(context);
        return instance;
    }

    private CanbusConnector(Context context) {
        this.context = context.getApplicationContext();
    }

    public void addListener(CanbusDataListener listener) {
        if (!listeners.contains(listener)) listeners.add(listener);
    }

    public void removeListener(CanbusDataListener listener) {
        listeners.remove(listener);
    }

    public void connect() {
        Log.d(TAG, "Connecting to com.syu.ms.toolkit...");
        
        // Strategy 1: Action-based intent
        Intent intent = new Intent("com.syu.ms.toolkit");
        
        // Strategy 2: Explicit component names (common on different versions)
        ComponentName[] components = {
            new ComponentName("com.syu.ms", "app.ToolkitService"),
            new ComponentName("com.syu.ms", "com.syu.ms.ToolkitService"),
            new ComponentName("com.syu.canbus", "app.ToolkitService")
        };

        boolean result = false;
        for (ComponentName comp : components) {
            intent.setComponent(comp);
            try {
                result = context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
                Log.d(TAG, "Binding to " + comp.flattenToString() + " | Result: " + result);
                if (result) break;
            } catch (Exception e) {
                Log.w(TAG, "Failed to bind to " + comp.flattenToString());
            }
        }

        if (!result) {
            // Strategy 3: Just action
            intent.setComponent(null);
            try {
                result = context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
                Log.d(TAG, "Binding via action 'com.syu.ms.toolkit' | Result: " + result);
            } catch (Exception e) {
                Log.e(TAG, "Failed final binding attempt", e);
            }
        }
    }

    private void notifyListeners(int moduleId, int code, int value) {
        for (CanbusDataListener listener : listeners) {
            listener.onDataReceived(moduleId, code, value);
        }
    }

    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "Service Connected");
            remoteToolkit = IRemoteToolkit.Stub.asInterface(service);
            reRegister();
            notifyListeners(-1, -1, 1);
        }
        @Override public void onServiceDisconnected(ComponentName name) { 
            Log.d(TAG, "Service Disconnected");
            module0.setModule(null);
            module7.setModule(null);
            notifyListeners(-1, -1, 0);
        }
    };

    public void reRegister() {
        if (remoteToolkit == null) return;
        try {
            module0.setModule(remoteToolkit.getRemoteModule(0));
            module7.setModule(remoteToolkit.getRemoteModule(7));

            // Đăng ký nhận dữ liệu
            for (int i = 0; i <= 1000; i++) {
                module0.register(mCallback0, i, 1);
                module7.register(mCallback7, i, 1);
            }
//            // Register Car ID (usually 1000)
//            module0.register(mCallback0, 1000, 1);

            // Lệnh Init đặc biệt cho VinFast RZC để "đánh thức" module
            module7.cmd(0, new int[]{38, 0});
            module7.cmd(0, new int[]{64, 0});

        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in reRegister", e);
        }
    }

    // CMD 2 là C_CONTRAL cho VinFast (15860165) theo file HP tham khảo
    public void sendAirCommand(int[] data) {
        if (data == null) return;
        Log.d(TAG, "sendAirCommand (via Proxy cmd 2): " + java.util.Arrays.toString(data));
        module7.cmd(2, data);
    }

    // Một số lệnh vẫn có thể dùng CMD 0 hoặc 1
    public void sendRawCommand(int cmd, int[] data) {
        module7.cmd(cmd, data);
    }

    public void sendCarCommand(int id, int value) {
        module7.cmd(1, new int[]{id, value});
    }

    private final IModuleCallback mCallback0 = new IModuleCallback.Stub() {
        @Override public void update(int code, int[] ints, float[] flts, String[] strs) {
            if (ints != null && ints.length > 0) {
                // LOG CHI TIẾT ĐỂ DÒ PHÍM VÔ LĂNG VÀ TRẠNG THÁI XE
                Log.d("SCAN_DATA", "Module 0 | Code: " + code + " | Value: " + ints[0]);
                notifyListeners(0, code, ints[0]);
            }
        }
    };

    private final IModuleCallback mCallback7 = new IModuleCallback.Stub() {
        @Override public void update(int code, int[] ints, float[] flts, String[] strs) {
            if (ints != null && ints.length > 0) {
                // LOG CHI TIẾT ĐỂ DÒ TRẠNG THÁI SẠC VÀ ĐIỀU HÒA
                Log.d("SCAN_DATA", "Module 7 | Code: " + code + " | Value: " + ints[0]);
                notifyListeners(7, code, ints[0]);
            }
        }
    };
}
