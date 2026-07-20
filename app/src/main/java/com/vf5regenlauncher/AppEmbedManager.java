package com.vf5regenlauncher;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

public class AppEmbedManager {
    private static final String TAG = "AppEmbedManager";
    private static final String PREFS_RECT = "map_pip_rect";
    private final Activity activity;
    private final FrameLayout container;
    private String currentPackage;
    private String lastRectSent = "";

    public AppEmbedManager(Activity activity) {
        this.activity = activity;
        this.container = activity.findViewById(R.id.container_main_app);
        init();
    }

    public void init() {
        determineMapPackage();
        if (container == null) return;

        // Đợi cho đến khi layout được measure trước khi gửi rect
        ViewTreeObserver vto = container.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                container.getViewTreeObserver().removeOnPreDrawListener(this);
                updatePipRect();
                ensureMapRunning();
                return true;
            }
        });
        
        // Ẩn text loading
        android.view.View statusView = container.findViewById(R.id.tv_widget_status);
        if (statusView != null) statusView.setVisibility(android.view.View.GONE);
        
        // Setup window focus listener để xử lý multitasking
        setupWindowFocusListener();
    }
    
    private void setupWindowFocusListener() {
        Window window = activity.getWindow();
        window.getDecorView().setOnSystemUiVisibilityChangeListener(visibility -> {
            Log.d(TAG, "System UI visibility changed: " + visibility);
        });
    }

    private void determineMapPackage() {
        SharedPreferences sp = activity.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
        currentPackage = sp.getString("default_map_package", null);
        if (currentPackage == null || currentPackage.isEmpty()) {
            currentPackage = getSystemProperty("persist.launcher.packagename", "com.vietmap.vietmaplive");
        }
    }

    /**
     * Cập nhật tọa độ, kiểm tra xem rect có thay đổi không trước khi gửi Broadcast.
     * Tuyệt đối không gọi startActivity ở đây.
     */
    public void updatePipRect() {
        if (container == null || container.getWidth() <= 0 || container.getHeight() <= 0) {
            Log.w(TAG, "Container not ready: width=" + (container != null ? container.getWidth() : "null") 
                    + ", height=" + (container != null ? container.getHeight() : "null"));
            return;
        }

        int[] location = new int[2];
        container.getLocationOnScreen(location);
        String rect = String.format(Locale.US, "%d %d %d %d", 
                location[0], location[1], location[0] + container.getWidth(), location[1] + container.getHeight());

        // Chỉ gửi broadcast nếu rect thay đổi để tránh spam
        if (rect.equals(lastRectSent)) {
            Log.d(TAG, "Rect unchanged, skipping broadcast");
            return;
        }

        lastRectSent = rect;
        Log.d(TAG, "updatePipRect: " + rect);
        
        // Lưu rect vào SharedPreferences để khôi phục khi restart
        SharedPreferences sp = activity.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
        sp.edit().putString(PREFS_RECT, rect).apply();
        
        // 1. Ghi thuộc tính hệ thống
        setSystemProperty("sys.lsec.pip_rect", rect);
        setSystemProperty("sys.lsec.pip_show", "1");
        setSystemProperty("sys.lsec.pip_mode", "1");
        
        // 2. Gửi Broadcast chính
        Intent i = new Intent("com.syu.action.PIP_RECT");
        i.putExtra("pip_rect", rect);
        i.putExtra("rect", rect);
        i.putExtra("show", true);
        activity.sendBroadcast(i);
        
        // 3. Các broadcast phụ để tăng độ ổn định
        activity.sendBroadcast(new Intent("com.syu.pip.show").putExtra("show", true).putExtra("packagename", currentPackage));
        activity.sendBroadcast(new Intent("com.syu.pip.update").putExtra("rect", rect));
    }

    /**
     * Đảm bảo Map đang chạy. Nếu process đã chết mới gọi launchMap().
     */
    public void ensureMapRunning() {
        if (isMapRunning()) {
            Log.d(TAG, "Map process is already alive: " + currentPackage);
            return;
        }
        Log.d(TAG, "Map process not found. Launching...");
        launchMap();
    }

    private boolean isMapRunning() {
        if (currentPackage == null || currentPackage.isEmpty()) return false;
        ActivityManager am = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processes = am.getRunningAppProcesses();
        if (processes != null) {
            for (ActivityManager.RunningAppProcessInfo p : processes) {
                if (currentPackage.equals(p.processName)) return true;
            }
        }
        return false;
    }

    private void launchMap() {
        // Đảm bảo rect được gửi trước khi launch
        updatePipRect();
        setSystemProperty("sys.lsec.force_pip", "1");

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            try {
                PackageManager pm = activity.getPackageManager();
                Intent intent = pm.getLaunchIntentForPackage(currentPackage);
                if (intent == null) return;

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                
                // Các extra bổ trợ - gửi rect đã lưu
                intent.putExtra("force_pip", true);
                intent.putExtra("pip_mode", 1);
                SharedPreferences sp = activity.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
                String savedRect = sp.getString(PREFS_RECT, "");
                if (!savedRect.isEmpty()) {
                    intent.putExtra("pip_rect", savedRect);
                    intent.putExtra("rect", savedRect);
                }
                
                activity.startActivity(intent);
                Log.d(TAG, "✓ Map launch command sent via startActivity with rect: " + savedRect);
            } catch (Exception e) {
                Log.e(TAG, "Launch map failed", e);
            }
        }, 200);
    }

    public void hidePip() {
        Log.d(TAG, "hidePip called manually");
        setSystemProperty("sys.lsec.pip_show", "0");
        try {
            Intent i = new Intent("com.syu.action.PIP_RECT");
            i.putExtra("pip_rect", "0 0 0 0");
            i.putExtra("show", false);
            activity.sendBroadcast(i);
            activity.sendBroadcast(new Intent("com.syu.pip.show").putExtra("show", false));
        } catch (Exception ignored) {}
    }

    private void setSystemProperty(String key, String value) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method set = c.getMethod("set", String.class, String.class);
            set.setAccessible(true);
            set.invoke(null, key, value);
        } catch (Exception e) {
            try {
                android.provider.Settings.System.putString(activity.getContentResolver(), key, value);
            } catch (Exception ignored) {}
        }
    }

    private String getSystemProperty(String key, String def) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            get.setAccessible(true);
            return (String) get.invoke(null, key, def);
        } catch (Exception e) {
            return def;
        }
    }

    public void launchApp(String packageName) {
        this.currentPackage = packageName;
        setSystemProperty("persist.launcher.packagename", packageName);
        launchMap();
    }
}
