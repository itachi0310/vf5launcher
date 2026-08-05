package com.fyt.flow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.android.launcher17.Launcher;

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
            int state = tm.getSimState();
            Launcher.getLauncher();
            Message msg = Launcher.wpvHandler.obtainMessage();
            msg.arg1 = state;
            msg.what = 1002;
            Launcher.getLauncher();
            Launcher.wpvHandler.sendMessageDelayed(msg, 5000L);
        }
    }
}
