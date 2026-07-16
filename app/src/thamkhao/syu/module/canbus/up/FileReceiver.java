package com.syu.module.canbus.up;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class FileReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle bundle;
        String action = intent.getAction();
        if ("com.syu.filemanager".equals(action) && (bundle = intent.getExtras()) != null) {
            DataCanUp.mFileUpdatePath = bundle.getString("update_file");
            DataCanUp.NOTIFY_EVENTS_FILEPATH.onNotify();
        }
    }
}
