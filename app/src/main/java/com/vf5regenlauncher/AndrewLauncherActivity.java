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
        
        // Thêm listener cho chính Activity để bắt các phím vô lăng đặc biệt
        canbusConnector.addListener(canbusKeyHandler);
        
        canbusConnector.connect();
        
        // Kiểm tra nếu Activity được mở bởi phím Mode (Intent Radio)
        handleSpecialIntents(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleSpecialIntents(intent);
    }

    private void handleSpecialIntents(Intent intent) {
        if (intent != null && "com.syu.radio".equals(intent.getAction())) {
            Log.d("SCAN_DATA", "Intercepted Mode Key (com.syu.radio)");
            if (dashboardController != null) {
                dashboardController.toggleDriveMode();
            }
        }
    }

    private final CanbusConnector.CanbusDataListener canbusKeyHandler = new CanbusConnector.CanbusDataListener() {
        @Override
        public void onDataReceived(int moduleId, int code, int value) {
            // Module 0 thường chứa các sự kiện phím hệ thống
            if (moduleId == 0) {
                // Đã loại bỏ code 114 vì nó là cần số (Gears)
                // Thử các mã phím cuộc gọi khác thường gặp: 7, 12, 115 (tùy firmware)
                if ((code == 7 || code == 12) && value == 1) {
                    Log.d("SCAN_DATA", "Intercepted Call Key | Code: " + code);
                    if (dashboardController != null) {
                        dashboardController.toggleRegenMode();
                    }
                }
            }
        }
    };

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
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            int keyCode = event.getKeyCode();
            Log.d("SCAN_DATA", "Key Pressed: " + keyCode);

            // 1. Xử lý phím Mode (Vô lăng) - Mã 176 hoặc 209
            if (keyCode == 176 || keyCode == 209) {
                if (dashboardController != null) {
                    dashboardController.toggleDriveMode();
                }
                return true;
            }

            // 2. Xử lý phím Menu hoặc Đa nhiệm (Menu=82, AppSwitch=187)
            if (keyCode == 82 || keyCode == 187 || keyCode == 221 || keyCode == 222) {
                openSystemAppList();
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    public void openSystemAppList() {
        Log.d("Launcher", "Opening System App List...");
        try {
            // Thử mở trực tiếp Activity Launcher của SYU (Cách này rất hiệu quả nếu Broadcast bị chặn)
            Intent syuLauncher = new Intent();
            syuLauncher.setComponent(new android.content.ComponentName("com.syu.canbus", "com.syu.canbus.LauncherActivity"));
            syuLauncher.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                startActivity(syuLauncher);
                return;
            } catch (Exception ignored) {}

            // Thử lệnh Broadcast mở giao diện chính của Canbus
            sendBroadcast(new Intent("com.syu.allapps"));
            sendBroadcast(new Intent("action.com.syu.canbus.LAUNCHER"));

            // Intent chuẩn Android
            Intent intent = new Intent(Intent.ACTION_ALL_APPS);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                return;
            }

            // Fallback
            startActivity(new Intent(this, AppListActivity.class));
        } catch (Exception e) {
            Log.e("Launcher", "Could not open app list", e);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Khi quay lại launcher, chỉ ép hiện vùng PIP (Không dùng startActivity để tránh nhảy app)
        if (appEmbedManager != null) {
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(() -> {
                appEmbedManager.refreshPipState();
            }, 500); // Giảm delay xuống 500ms để Map hiện nhanh hơn
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
