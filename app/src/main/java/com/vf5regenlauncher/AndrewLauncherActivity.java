package com.vf5regenlauncher;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
    private AppEmbedManager appEmbedManager; // Kept as instance but uses static methods internally

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
        
        // Refactored: Attach the container for coordinate tracking
        android.widget.FrameLayout container = findViewById(R.id.container_main_app);
        AppEmbedManager.attachContainer(this, container);

        canbusConnector.addListener(dashboardController);
        canbusConnector.addListener(bottomNavController);
        canbusConnector.addListener(topBarController);
        canbusConnector.addListener(drivingAssistant);
        
        // Thêm listener cho chính Activity để bắt các phím vô lăng đặc biệt
        canbusConnector.addListener(canbusKeyHandler);
        
        canbusConnector.connect();
        
        // Kiểm tra nếu Activity được mở bởi phím Mode (Intent Radio)
        handleSpecialIntents(getIntent());

        // Lắng nghe tín hiệu PIP bị chết để khôi phục
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.lsec.pipdie");
        registerReceiver(pipDieReceiver, filter);
    }

    private final android.content.BroadcastReceiver pipDieReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(android.content.Context context, Intent intent) {
            if ("com.lsec.pipdie".equals(intent.getAction())) {
                Log.d("Launcher", "PIP died, restarting...");
                AppEmbedManager.isPipShowing = false; // Reset flag để cho phép mở lại
                AppEmbedManager.showPip();
            }
        }
    };

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleSpecialIntents(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Launcher", "onRestart - Preparing PIP early");
        AppEmbedManager.isPipShowing = false; 
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
            // Tạm thời tắt logic này để dò mã chuẩn từ TopBar
            // if (moduleId == 0) {
            //     if ((code == 7 || code == 12) && value == 1) {
            //         if (dashboardController != null) dashboardController.toggleRegenMode();
            //     }
            // }
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
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                LauncherApplication.getAppContext().startActivity(intent);
            }
        }
    }

    private void checkWriteSettingsPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
                        Uri.parse("package:" + getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                LauncherApplication.getAppContext().startActivity(intent);
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
        
        // Reference: onResume/onStop handles PiP visibility.
        // When opening App List, we should probably hide PiP to let it take full screen.
        AppEmbedManager.hidePip();

        try {
            // Standard Android Intent
            Intent intent = new Intent(Intent.ACTION_ALL_APPS);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (intent.resolveActivity(getPackageManager()) != null) {
                LauncherApplication.getAppContext().startActivity(intent);
                return;
            }

            // Fallback
            Intent appListIntent = new Intent(this, AppListActivity.class);
            appListIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            LauncherApplication.getAppContext().startActivity(appListIntent);
        } catch (Exception e) {
            Log.e("Launcher", "Could not open app list", e);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Match original Launcher.onStart() logic
        AppEmbedManager.refreshPackageName();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Match reference: onResume calls a(null) which triggers startMapPip
        Log.d("Launcher", "onResume - Triggering showPip like reference");
        AppEmbedManager.showPip();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Launcher", "onStop - Hiding PIP like reference");
        AppEmbedManager.hidePip();
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
