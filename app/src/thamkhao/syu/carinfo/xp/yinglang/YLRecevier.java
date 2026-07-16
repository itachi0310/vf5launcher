package com.syu.carinfo.xp.yinglang;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class YLRecevier extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.syu.onstar.xp.yinglang.showpip") && !YLOnStarAct.mIsFront) {
            YLShowPip.showWindow();
        }
    }
}
