package com.vf5regenlauncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MediaWidgetController {
    private static final String TAG = "MediaWidgetController";
    
    // Các Action gửi lệnh điều khiển nhạc ngược lại hệ thống ô tô ROM FYT
    public static final String NEXTMUSIC = "com.syu.music.next";
    public static final String PREVMUSIC = "com.syu.music.prev";
    public static final String PLAYPAUSEMUSIC = "com.syu.music.playpause";
    
    // Bluetooth AV Commands
    public static final String BT_NEXT = "com.syu.bt.byav.widgetNext";
    public static final String BT_PREV = "com.syu.bt.byav.widgetPrev";
    public static final String BT_PLAYPAUSE = "com.syu.bt.byav.widgetPlayPause";

    private final AndrewLauncherActivity activity;
    private TextView tvTitle;
    private TextView tvArtist;
    private ImageButton btnPrev;
    private ImageButton btnToggle;
    private ImageButton btnNext;
    private ImageView ivAlbum;

    private boolean isRegistered = false;
    private boolean isPlaying = false;

    public MediaWidgetController(AndrewLauncherActivity activity) {
        this.activity = activity;
        initViews();
    }

    private void initViews() {
        tvTitle = activity.findViewById(R.id.tv_music_title);
        tvArtist = activity.findViewById(R.id.tv_music_artist);
        btnPrev = activity.findViewById(R.id.btn_music_prev);
        btnToggle = activity.findViewById(R.id.btn_music_toggle);
        btnNext = activity.findViewById(R.id.btn_music_next);
        ivAlbum = activity.findViewById(R.id.iv_music_album);
        
        View container = activity.findViewById(R.id.container_music_widget);
        if (container != null) {
            container.setOnClickListener(v -> openMusicApp());
        }

        if (btnPrev != null) {
            btnPrev.setOnClickListener(v -> sendMediaCommand(PREVMUSIC));
        }
        if (btnNext != null) {
            btnNext.setOnClickListener(v -> sendMediaCommand(NEXTMUSIC));
        }
        if (btnToggle != null) {
            btnToggle.setOnClickListener(v -> sendMediaCommand(PLAYPAUSEMUSIC));
        }
    }

    private void openMusicApp() {
        try {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setComponent(new android.content.ComponentName("com.syu.music", "com.syu.music.MAct"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(intent);
        } catch (Throwable e) {
            try {
                Intent intent = activity.getPackageManager().getLaunchIntentForPackage("com.syu.music");
                if (intent != null) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    activity.startActivity(intent);
                }
            } catch (Throwable ignored) {}
        }
    }

    private void sendMediaCommand(String action) {
        try {
            // Thử gửi lệnh cho ứng dụng nhạc chính
            Intent intent = new Intent(action);
            intent.setPackage("com.syu.music");
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            try { activity.startService(intent); } catch (Throwable ignored) {}
            activity.sendBroadcast(intent);

            // Gửi lệnh tương ứng cho Bluetooth (nơi thường xử lý nhạc từ điện thoại)
            String btAction = null;
            if (action.equals(NEXTMUSIC)) btAction = BT_NEXT;
            else if (action.equals(PREVMUSIC)) btAction = BT_PREV;
            else if (action.equals(PLAYPAUSEMUSIC)) btAction = BT_PLAYPAUSE;

            if (btAction != null) {
                Intent btIntent = new Intent(btAction);
                btIntent.setPackage("com.syu.bt");
                btIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                try { activity.startService(btIntent); } catch (Throwable ignored) {}
                activity.sendBroadcast(btIntent);
            }
            
            // Một số ROM cần lệnh chung không có package
            Intent generic = new Intent(action);
            generic.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            activity.sendBroadcast(generic);
            
            Log.d(TAG, "Sent media command stack for: " + action);
        } catch (Throwable e) {
            Log.e(TAG, "Failed to send media command", e);
        }
    }

    private final BroadcastReceiver mediaReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent == null) return;
            String action = intent.getAction();
            Log.d(TAG, "Received media intent action: " + action);

            if ("com.fyt.launcher.music".equals(action) || "action.fyt.music".equals(action) || 
                "com.syu.music.notifier".equals(action) || "com.vf5launcher.MUSIC_UPDATE_INTERNAL".equals(action)) {
                
                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    // Ưu tiên dữ liệu BT nếu có
                    String title = bundle.getString("btav");
                    if (title == null || title.isEmpty()) title = bundle.getString("title");
                    if (title == null || title.isEmpty()) title = bundle.getString("music_name");
                    
                    String artist = bundle.getString("btav_art");
                    if (artist == null || artist.isEmpty()) artist = bundle.getString("play_artist");
                    if (artist == null || artist.isEmpty()) artist = bundle.getString("author_name");
                    
                    boolean state = bundle.getBoolean("play_state", false);
                    if (bundle.containsKey("state")) {
                        state = bundle.getBoolean("state", false);
                    }

                    isPlaying = state;
                    
                    if (tvTitle != null && title != null && !title.isEmpty()) {
                        tvTitle.setText(title);
                    }
                    if (tvArtist != null && artist != null && !artist.isEmpty()) {
                        tvArtist.setText(artist);
                    }
                    if (btnToggle != null) {
                        btnToggle.setImageResource(isPlaying ? android.R.drawable.ic_media_pause : android.R.drawable.ic_media_play);
                    }
                    Log.d(TAG, "Updated music info -> Title: " + title + ", Artist: " + artist + ", Playing: " + state);
                }
            }
        }
    };

    public void register() {
        if (!isRegistered) {
            IntentFilter filter = new IntentFilter();
            filter.addAction("com.fyt.launcher.music");
            filter.addAction("action.fyt.music");
            filter.addAction("com.syu.music.notifier");
            filter.addAction("com.vf5launcher.MUSIC_UPDATE_INTERNAL");
            try {
                activity.registerReceiver(mediaReceiver, filter);
                isRegistered = true;
                Log.d(TAG, "Registered mediaReceiver successfully");
            } catch (Throwable e) {
                Log.e(TAG, "Failed to register mediaReceiver", e);
            }
        }
    }

    public void unregister() {
        if (isRegistered) {
            try {
                activity.unregisterReceiver(mediaReceiver);
                isRegistered = false;
                Log.d(TAG, "Unregistered mediaReceiver successfully");
            } catch (Throwable e) {
                Log.e(TAG, "Failed to unregister mediaReceiver", e);
            }
        }
    }
}
