package com.android.launcher6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class PackageChangedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        if (schemeSpecificPart == null || schemeSpecificPart.length() == 0) {
            return;
        }
        ip.a(context.getApplicationContext());
        ob.a(ip.a().f(), schemeSpecificPart);
    }
}
