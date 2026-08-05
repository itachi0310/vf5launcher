package com.fyt.car;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.android.launcher17.LauncherApplication;
import com.android.launcher17.R;
import com.syu.widget.Widget;

/* JADX INFO: loaded from: classes.dex */
public class MusicService extends Service {
    public static final String MUSICSERVICE = "com.fyt.launcher.music";
    public static final String MUSIC_PKG = "com.syu.music";
    public static final String NEXTMUSIC = "com.syu.music.next";
    public static final String PLAYPAUSEMUSIC = "com.syu.music.playpause";
    public static final String PLAY_ALBUM = "play_album";
    public static final String PLAY_ARTIST = "play_artist";
    public static final String PLAY_CURMINUTES = "play_cur";
    public static final String PLAY_PATH = "play_path";
    public static final String PLAY_STATE = "play_state";
    public static final String PLAY_TOTALMINUTES = "play_total";
    public static final String PREVMUSIC = "com.syu.music.prev";
    public static final String REMOVE_MUSIC = "com.fyt.systemui.remove";
    public static final String TITLE = "title";
    public static byte[] album_cover;
    public static String music_name = "";
    public static String author_name = "";
    public static String music_path = "";
    public static Boolean state = false;
    public static String album = "";
    public static long TOTALMINUTES = 0;
    public static long CURMINUTES = 0;

    @Override // android.app.Service
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            return super.onStartCommand(intent, flags, startId);
        }
        String action = intent.getAction();
        if ("com.fyt.launcher.music".equals(action)) {
            Bundle bundle = intent.getExtras();
            TOTALMINUTES = bundle.getLong("play_total");
            CURMINUTES = bundle.getLong("play_cur");
            music_name = bundle.getString("title");
            author_name = bundle.getString("play_artist");
            music_path = bundle.getString(PLAY_PATH);
            state = Boolean.valueOf(bundle.getBoolean("play_state"));
            if (bundle.getString("play_album") != null) {
                album = bundle.getString("play_album");
            } else {
                album = "";
            }
            if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_widget_design)) {
                Widget.update(LauncherApplication.sApp);
            } else {
                LauncherNotify.NOTIFIER_MUSIC.set(null, new long[]{TOTALMINUTES, CURMINUTES}, null, new String[]{music_name, author_name, state.toString(), album, music_path}, album_cover);
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
