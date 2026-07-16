package com.syu.carinfo.rzc.klc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class RzcKlcRecevier extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.syu.onstar.rzc.showpip") && !RzcKlcOnStarAct.mIsFront) {
            RzcShowPip.showWindow();
        }
    }
}
