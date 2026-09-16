package com.fyt.flow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes.dex */
public class SimStateReceiver extends BroadcastReceiver {
    public static final String ACTION_SIM_STATE_CHANGED = "android.intent.action.SIM_STATE_CHANGED";
    private static final int SIM_INVALID = 1;
    public static final int SIM_MSG = 1002;
    private static final int SIM_VALID = 0;
    private int simState = 1;

    public int getSimState() {
        return this.simState;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_SIM_STATE_CHANGED)) {
            TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
            tm.getSimState();
        }
    }
}
