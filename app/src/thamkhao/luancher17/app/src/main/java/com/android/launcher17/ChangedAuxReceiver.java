package com.android.launcher17;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class ChangedAuxReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (Launcher.mModel != null) {
            Launcher.mModel.onReceive(context, intent);
        }
    }
}
