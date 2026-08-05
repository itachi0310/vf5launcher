package com.android.launcher6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class PreloadReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LauncherProvider launcherProviderG = ip.g();
        if (launcherProviderG != null) {
            String stringExtra = intent.getStringExtra("com.android.launcher6.action.EXTRA_WORKSPACE_NAME");
            new Thread(new mg(this, launcherProviderG, !TextUtils.isEmpty(stringExtra) ? context.getResources().getIdentifier(stringExtra, "xml", "com.android.launcher6") : 0)).start();
        }
    }
}
