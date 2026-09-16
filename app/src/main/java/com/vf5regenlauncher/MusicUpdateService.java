package com.vf5regenlauncher;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class MusicUpdateService extends Service {
    private static final String TAG = "MusicUpdateService";
    public static final String ACTION_MUSIC_UPDATE = "com.fyt.launcher.music";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String action = intent.getAction();
            Log.d(TAG, "Received music update via Service start: " + action);
            // Chuyển tiếp dữ liệu sang MediaWidgetController qua Broadcast nội bộ
            Intent broadcast = new Intent("com.vf5launcher.MUSIC_UPDATE_INTERNAL");
            broadcast.putExtra("original_action", action);
            Bundle extras = intent.getExtras();
            if (extras != null) {
                broadcast.putExtras(extras);
            }
            sendBroadcast(broadcast);
        }
        return START_NOT_STICKY;
    }
}
