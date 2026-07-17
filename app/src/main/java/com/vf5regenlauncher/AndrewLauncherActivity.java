package com.vf5regenlauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;

public class AndrewLauncherActivity extends AppCompatActivity {
    private static AndrewLauncherActivity instance;
    private DashboardController dashboardController;
    private BottomNavController bottomNavController;
    private TopBarController topBarController;
    private DrivingAssistant drivingAssistant;
    private CanbusConnector canbusConnector;
    private AppEmbedManager appEmbedManager;

    public static AndrewLauncherActivity getInstance() {
        return instance;
    }

    public AppEmbedManager getAppEmbedManager() {
        return appEmbedManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_andrew_launcher);

        checkOverlayPermission();
        checkWriteSettingsPermission();
        requestInternetPermissions();

        canbusConnector = CanbusConnector.getInstance(this);
        
        dashboardController = new DashboardController(this);
        bottomNavController = new BottomNavController(this);
        topBarController = new TopBarController(this);
        drivingAssistant = new DrivingAssistant(this);
        appEmbedManager = new AppEmbedManager(this);

        canbusConnector.addListener(dashboardController);
        canbusConnector.addListener(bottomNavController);
        canbusConnector.addListener(topBarController);
        canbusConnector.addListener(drivingAssistant);
        
        canbusConnector.connect();
    }

    private void requestInternetPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.INTERNET) 
                    != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                    android.Manifest.permission.INTERNET,
                    android.Manifest.permission.ACCESS_NETWORK_STATE
                }, 1);
            }
        }
    }

    private void checkOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivity(intent);
            }
        }
    }

    private void checkWriteSettingsPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
                        Uri.parse("package:" + getPackageName()));
                startActivity(intent);
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // LOG TẤT CẢ CÁC PHÍM NHẬN ĐƯỢC ĐỂ TÌM PHÍM VÔ LĂNG
        Log.d("SCAN_DATA", "Key Pressed: " + keyCode);

        // Chặn các phím Mode (176) hoặc các phím tương tự từ vô lăng để tránh popup hệ thống
        if (keyCode == 176 || keyCode == 209) {
            if (dashboardController != null) {
                dashboardController.toggleDriveMode();
            }
            return true;
        }

        // Xử lý phím Menu (82) hoặc phím App Switch (187)
        if (keyCode == KeyEvent.KEYCODE_MENU || keyCode == 187) {
            openSystemAppList();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    public void openSystemAppList() {
        try {
            // Cách 1: Sử dụng Intent chuẩn của Android
            Intent intent = new Intent(Intent.ACTION_ALL_APPS);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                return;
            }

            // Cách 2: Sử dụng Broadcast đặc trưng của đầu SYU/FYT (Phổ biến nhất)
            sendBroadcast(new Intent("com.syu.allapps"));
            
            // Cách 3: Thử Intent cụ thể của SYU Canbus
            Intent syuIntent = new Intent("com.syu.canbus.ALL_APPS");
            syuIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(syuIntent);
        } catch (Exception e) {
            Log.e("Launcher", "Could not open system app list", e);
            // Fallback cuối cùng là AppListActivity nội bộ
            Intent intent = new Intent(this, AppListActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Khi quay lại launcher, làm mới vùng vẽ sau một chút delay để tránh bung app
        if (appEmbedManager != null) {
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
                appEmbedManager.refreshPipState();
            }, 800); // Tăng delay lên 800ms để hệ thống ổn định
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Quan trọng: Ẩn PIP khi rời khỏi launcher để không đè lên các ứng dụng khác
        // và để giải phóng focus giúp hiện bàn phím ở các app khác.
        if (appEmbedManager != null) {
            appEmbedManager.hidePip();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (canbusConnector != null) {
            canbusConnector.removeListener(dashboardController);
            canbusConnector.removeListener(bottomNavController);
            canbusConnector.removeListener(topBarController);
            canbusConnector.removeListener(drivingAssistant);
        }
        if (instance == this) {
            instance = null;
        }
    }

    @Override
    public void onBackPressed() {
        // Không làm gì để tránh thoát Launcher bằng phím Back
    }
}
