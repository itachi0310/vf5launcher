package com.vf5regenlauncher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
import java.util.Locale;

/**
 * Manages embedding map applications (Vietmap, Google Maps, etc.) into the Ember container.
 * 
 * Implementation based on FYT framework PIP (Picture-in-Picture) mechanism:
 * 1. Read app package from system property: persist.launcher.packagename
 * 2. Calculate container coordinates
 * 3. Set PIP rectangle: sys.lsec.pip_rect
 * 4. Launch app with force_pip flag
 */
public class AppEmbedManager {
    private static final String TAG = "AppEmbedManager";
    private final Activity activity;
    private final FrameLayout container;
    private String currentPackage;

    public AppEmbedManager(Activity activity) {
        this.activity = activity;
        this.container = activity.findViewById(R.id.container_main_app);
        init();
    }

    // === System Property Access (FYT Framework) ===
    
    private void setSystemProperty(String key, String value) {
        boolean success = false;
        
        // Method 1: Reflection on SystemProperties (Works for system apps)
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method set = c.getMethod("set", String.class, String.class);
            set.setAccessible(true);
            set.invoke(null, key, value);
            Log.d(TAG, "✓ Set property via SystemProperties: " + key + " = " + value);
            success = true;
        } catch (Exception e) {
            // Expected on non-system apps for sys.* and persist.* properties
            Log.w(TAG, "⚠ SystemProperties.set failed for " + key + " (" + value + "), trying fallbacks...");
        }

        // Method 2: Settings.System (Many FYT/SYU systems mirror properties here)
        if (!success) {
            try {
                android.provider.Settings.System.putString(activity.getContentResolver(), key, value);
                Log.d(TAG, "✓ Set property via Settings.System: " + key + " = " + value);
                success = true;
            } catch (Exception e) {
                // Usually requires WRITE_SETTINGS permission
                Log.w(TAG, "⚠ Settings.System.putString failed for " + key);
            }
        }

        // Method 3: Intent Broadcast (Known backdoor for SYU/FYT systems)
        try {
            // Try common SYU/FYT broadcast actions
            String[] actions = {
                "com.syu.set_system_property",
                "com.syu.ms.action.SET_PROP",
                "com.syu.action.SET_PROP",
                "com.lsec.action.SET_PROP",
                "com.syu.action.SET_SYSTEM_PROPERTY"
            };
            
            for (String action : actions) {
                Intent intent = new Intent(action);
                intent.putExtra("key", key);
                intent.putExtra("value", value);
                intent.putExtra("prop", key);
                intent.putExtra("val", value);
                intent.putExtra("PROPERTY", key);
                intent.putExtra("VALUE", value);
                activity.sendBroadcast(intent);
            }
            Log.d(TAG, "✓ Sent SYU/FYT fallback broadcasts for: " + key);
        } catch (Exception ex) {
            Log.e(TAG, "✗ Fallback broadcasts failed", ex);
        }

        // Method 4: Shell command (Last resort, works if app has root or if system is permissive)
        try {
            java.lang.Process process = Runtime.getRuntime().exec(new String[]{"setprop", key, value});
            process.waitFor();
            Log.d(TAG, "✓ Attempted setprop via shell: " + key);
        } catch (Exception ignored) {}
    }

    private String getSystemProperty(String key, String def) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            get.setAccessible(true);
            String result = (String) get.invoke(null, key, def);
            Log.d(TAG, "✓ Read property: " + key + " = " + result);
            return result;
        } catch (Exception e) {
            Log.e(TAG, "✗ Failed to read property: " + key, e);
            return def;
        }
    }

    // === Initialization ===

    private void init() {
        if (container == null) {
            Log.e(TAG, "✗ ERROR: container_main_app not found in layout!");
            return;
        }

        // Step 1: Determine which map app to use
        determineMapPackage();

        if (currentPackage == null || currentPackage.isEmpty()) {
            Log.e(TAG, "✗ No map app package available");
            return;
        }

        Log.d(TAG, "Selected map app: " + currentPackage);

        // Step 2: Wait for layout measurement, then setup PIP
        container.post(this::setupAndLaunchPip);
    }

    private void determineMapPackage() {
        // Priority 1: User's choice from app settings
        SharedPreferences sp = activity.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
        currentPackage = sp.getString("default_map_package", null);

        // Priority 2: System property (set by Settings activity)
        if (currentPackage == null || currentPackage.isEmpty()) {
            currentPackage = getSystemProperty("persist.launcher.packagename", "");
        }

        // Priority 3: Default to VietMap Live
        if (currentPackage == null || currentPackage.isEmpty()) {
            currentPackage = "com.vietmap.vietmaplive";
            Log.d(TAG, "Using default map app: " + currentPackage);
        }
    }

    // === PIP Setup ===

    /**
     * Refresh the PIP region settings and ensure the app is visible.
     * Useful when returning to Home screen.
     */
    public void refreshPipState() {
        if (container == null) return;
        
        container.post(() -> {
            int[] location = new int[2];
            container.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            int w = container.getWidth();
            int h = container.getHeight();

            if (w > 0 && h > 0) {
                String pipRect = String.format(Locale.US, "%d %d %d %d", x, y, x + w, y + h);
                applyPipSettings(pipRect);
                
                // Thay vì gọi launchMapApp() ngay lập tức (gây nhảy app), 
                // ta chỉ kích hoạt lại PIP qua tín hiệu hệ thống. 
                // Chỉ launch lại nếu sau 1s app vẫn không hiện (logic này có thể thêm sau nếu cần).
                Log.d(TAG, "✓ PIP state refreshed: " + pipRect);
            }
        });
    }

    /**
     * Hide the PIP window. Should be called when the launcher is not visible.
     */
    public void hidePip() {
        Log.d(TAG, "Hiding PIP");
        setSystemProperty("sys.lsec.pip_show", "0");
        
        // Gửi broadcast thông báo ẩn cho hệ thống
        try {
            Intent showIntent = new Intent("com.syu.pip.show");
            showIntent.putExtra("show", false);
            showIntent.putExtra("packagename", currentPackage);
            activity.sendBroadcast(showIntent);

            // Xóa rect để tránh đè lên các app khác (một số firmware cần điều này)
            Intent rectIntent = new Intent("com.syu.action.PIP_RECT");
            rectIntent.putExtra("pip_rect", "0 0 0 0");
            activity.sendBroadcast(rectIntent);
        } catch (Exception ignored) {}
    }

    private void setupAndLaunchPip() {
        if (container == null) {
            Log.e(TAG, "Container is null, cannot setup PIP");
            return;
        }

        // Measure container
        int[] location = new int[2];
        container.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        int w = container.getWidth();
        int h = container.getHeight();

        Log.d(TAG, String.format("Container measured: x=%d, y=%d, w=%d, h=%d", x, y, w, h));

        // Validate dimensions
        if (w <= 0 || h <= 0) {
            Log.w(TAG, "Container dimensions invalid, retrying...");
            container.postDelayed(this::setupAndLaunchPip, 300);
            return;
        }

        // Step A: Set PIP rectangle (format: "left top right bottom")
        String pipRect = String.format(Locale.US, "%d %d %d %d", x, y, x + w, y + h);

        // Apply settings immediately
        applyPipSettings(pipRect);

        // Step D: Launch the map app (delay 300ms for system to prepare)
        new Handler(Looper.getMainLooper()).postDelayed(this::launchMapApp, 300);

        // Hide loading text
        android.view.View statusView = container.findViewById(R.id.tv_widget_status);
        if (statusView != null) {
            statusView.setVisibility(android.view.View.GONE);
        }
    }

    private void applyPipSettings(String pipRect) {
        Log.d(TAG, "Applying PIP Settings: " + pipRect);
        
        // 1. Ghi vào System Property (Ưu tiên cao nhất)
        setSystemProperty("sys.lsec.pip_rect", pipRect);
        setSystemProperty("persist.launcher.packagename", currentPackage);
        setSystemProperty("sys.lsec.pip_show", "1");
        setSystemProperty("sys.lsec.pip_mode", "1");
        
        // Bật touch cho vùng PIP
        setSystemProperty("sys.lsec.pip_touch", "1");

        // 3. Gửi Intent ép hệ thống cập nhật Layout ngay lập tức
        try {
            // Tín hiệu A: Cập nhật tọa độ và trạng thái
            Intent rectIntent = new Intent("com.syu.action.PIP_RECT");
            rectIntent.putExtra("pip_rect", pipRect);
            rectIntent.putExtra("rect", pipRect);
            rectIntent.putExtra("show", true);
            rectIntent.putExtra("packagename", currentPackage);
            activity.sendBroadcast(rectIntent);

            // Tín hiệu B: Ép hiển thị (Force Show)
            Intent showIntent = new Intent("com.syu.pip.show");
            showIntent.putExtra("show", true);
            showIntent.putExtra("rect", pipRect);
            showIntent.putExtra("packagename", currentPackage);
            activity.sendBroadcast(showIntent);
            
            // Tín hiệu C: Dự phòng cho một số dòng firmware khác
            Intent lsecIntent = new Intent("com.lsec.action.PIP_SHOW");
            lsecIntent.putExtra("show", true);
            lsecIntent.putExtra("rect", pipRect);
            activity.sendBroadcast(lsecIntent);
        } catch (Exception ignored) {}
    }

    // === App Launching ===

    private void launchMapApp() {
        if (currentPackage == null || currentPackage.isEmpty()) {
            Log.e(TAG, "No package to launch");
            return;
        }

        try {
            PackageManager pm = activity.getPackageManager();
            Intent intent = pm.getLaunchIntentForPackage(currentPackage);

            if (intent == null) return;

            // Configure intent
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

            // ⭐ NHỮNG FLAG QUAN TRỌNG NHẤT ĐỂ APP "CO" LẠI
            intent.putExtra("force_pip", true);
            intent.putExtra("pip_mode", 1);
            intent.putExtra("pip_show", true);
            
            // Lấy tọa độ hiện tại của container để gửi kèm vào Intent
            int[] location = new int[2];
            container.getLocationOnScreen(location);
            String currentRect = String.format(Locale.US, "%d %d %d %d", 
                location[0], location[1], location[0] + container.getWidth(), location[1] + container.getHeight());
            intent.putExtra("pip_rect", currentRect);
            
            // Thêm các key bổ sung mà một số app Map (Vietmap) yêu cầu
            intent.putExtra("com.syu.action.PIP", true);
            intent.putExtra("isPipMode", true);

            activity.startActivity(intent);
            Log.d(TAG, "✓ Launched map app with embedded flags: " + currentPackage);

        } catch (Exception e) {
            Log.e(TAG, "Error launching map app", e);
        }
    }

    // === Public API ===

    /**
     * Show the specified app in the PIP container without changing default settings
     */
    public void launchApp(String packageName) {
        if (packageName == null || packageName.isEmpty()) {
            Log.e(TAG, "Invalid package name");
            return;
        }

        this.currentPackage = packageName;

        // Chỉ nhúng và chạy, không lưu vào driving_prefs để tránh đổi app mặc định
        setSystemProperty("persist.launcher.packagename", packageName);
        launchMapApp();
        Log.d(TAG, "Embedding app: " + packageName);
    }

    /**
     * Get currently active map app package
     */
    public String getCurrentPackage() {
        return currentPackage;
    }
}
