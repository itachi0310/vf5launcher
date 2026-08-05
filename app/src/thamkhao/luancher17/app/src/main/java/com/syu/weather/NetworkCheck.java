package com.syu.weather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/weather/NetworkCheck.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public class NetworkCheck extends BroadcastReceiver {
    public static final int DELAY = 30000;
    boolean hasNet;
    Context mContext;
    boolean isRegister = false;
    List<OnNetworkStateChangeLisenter> mLisenters = new ArrayList();

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:bin/autolib.jar:com/syu/weather/NetworkCheck$OnNetworkStateChangeLisenter.class
  classes.dex
 */
    public interface OnNetworkStateChangeLisenter {
        void onChanged(boolean z);
    }

    public NetworkCheck(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean hasNet = isConnectionAvailable(context);
        if (hasNet != this.hasNet) {
            this.hasNet = hasNet;
            if (this.mLisenters != null && this.mLisenters.size() > 0) {
                List<OnNetworkStateChangeLisenter> lisenters = new ArrayList<>(this.mLisenters);
                for (OnNetworkStateChangeLisenter lisenter : lisenters) {
                    lisenter.onChanged(this.hasNet);
                }
            }
        }
    }

    public void register(Context context) {
        Context sContext = context.getApplicationContext();
        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        sContext.registerReceiver(this, filter);
        this.isRegister = true;
    }

    public void unregister(Context context) {
        if (this.isRegister) {
            Context sContext = context.getApplicationContext();
            sContext.unregisterReceiver(this);
            this.isRegister = false;
        }
    }

    public boolean isConnectionAvailable(Context cotext) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) cotext.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public void registerLisenter(OnNetworkStateChangeLisenter lisenter) {
        if (this.mLisenters == null) {
            this.mLisenters = new ArrayList();
        }
        this.hasNet = isConnectionAvailable(this.mContext);
        if (lisenter != null && !this.mLisenters.contains(lisenter)) {
            this.mLisenters.add(lisenter);
            lisenter.onChanged(this.hasNet);
        }
    }

    public void unRegisterLisenter(OnNetworkStateChangeLisenter lisenter) {
        if (this.mLisenters != null && lisenter != null && this.mLisenters.contains(lisenter)) {
            this.mLisenters.remove(lisenter);
        }
    }
}
