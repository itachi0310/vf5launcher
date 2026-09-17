package com.vf5regenlauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.vf5regenlauncher.util.WindowUtil;

public class AndrewLauncherActivity extends AppCompatActivity {
    private static AndrewLauncherActivity instance;
    private DashboardController dashboardController;
    private BottomNavController bottomNavController;
    private TopBarController topBarController;
    private DrivingAssistant drivingAssistant;
    private CanbusConnector canbusConnector;
    private AppEmbedManager appEmbedManager;
    private MediaWidgetController mediaWidgetController;
    private WeatherWidgetController weatherWidgetController;

    public Handler handler = new Handler(Looper.getMainLooper());

    public static AndrewLauncherActivity getInstance() {
        return instance;
    }

    public AppEmbedManager getAppEmbedManager() {
        return appEmbedManager;
    }

    private State mState = State.WORKSPACE;

    private State mOnResumeState = State.NONE;

    private View pipViews;

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
        mediaWidgetController = new MediaWidgetController(this);
        weatherWidgetController = new WeatherWidgetController(this);

        canbusConnector.addListener(dashboardController);
        canbusConnector.addListener(bottomNavController);
        canbusConnector.addListener(topBarController);
        canbusConnector.addListener(drivingAssistant);
        
        // Thêm listener cho chính Activity để bắt các phím vô lăng đặc biệt
        canbusConnector.addListener(canbusKeyHandler);
        
        canbusConnector.connect();

        WindowUtil.initDefaultApp();
        
        try {
            registerReceiver(pipDieReceiver, new android.content.IntentFilter("com.lsec.pipdie"));
        } catch (Throwable e) {
            Log.e("Launcher", "Failed to register pipDieReceiver", e);
        }
        
        // Buộc ép mở Map ngay khi khởi tạo xong (tránh việc Map không mở ở lần đầu)
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (appEmbedManager != null) {
                    appEmbedManager.updatePipRect();
                }
                com.vf5regenlauncher.util.WindowUtil.visible = false; // Reset state để openPip không bị filter
                com.vf5regenlauncher.util.WindowUtil.startMapPip();
            }
        }, 1500);
        
        // Kiểm tra nếu Activity được mở bởi phím Mode (Intent Radio)
//        handleSpecialIntents(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleSpecialIntents(intent);
    }

    private void handleSpecialIntents(Intent intent) {
        if (intent == null) return;
        
        String action = intent.getAction();
        if ("com.syu.radio".equals(action)) {
            Log.d("SCAN_DATA", "Intercepted Mode Key -> Toggle Drive Mode");
            if (dashboardController != null) {
                dashboardController.toggleDriveMode();
            }
        } else if ("com.syu.bt".equals(action)) {
            Log.d("SCAN_DATA", "Intercepted Call Key -> Toggle Regen Mode");
            if (dashboardController != null) {
                dashboardController.toggleRegenMode();
            }
        }
    }

    private final CanbusConnector.CanbusDataListener canbusKeyHandler = new CanbusConnector.CanbusDataListener() {
        @Override
        public void onDataReceived(int moduleId, int code, int value) {
            if (moduleId == 0) {
                // Thử nghiệm phím cuộc gọi qua code 7 hoặc 12 (nếu chúng là phím)
                // Hoặc bất kỳ mã nào nhảy khi bạn nhấn phím Cuộc gọi
                if ((code == 7 || code == 12) && value == 1) {
                    Log.d("SCAN_DATA", "Call Key Intercepted via Canbus Code: " + code);
//                    if (dashboardController != null) {
//                        dashboardController.toggleRegenMode();
//                    }
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

    public boolean isAllAppsVisible() {
        return this.mState == State.APPS_CUSTOMIZE || this.mOnResumeState == State.APPS_CUSTOMIZE;
    }

    private final android.content.BroadcastReceiver pipDieReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(android.content.Context context, Intent intent) {
            if (intent != null && "com.lsec.pipdie".equals(intent.getAction())) {
                Log.d("Launcher", "Received com.lsec.pipdie broadcast - restoring Map PiP");
                com.vf5regenlauncher.util.WindowUtil.visible = false;
                if (!isAllAppsVisible()) {
                    if (appEmbedManager != null) {
                        appEmbedManager.updatePipRect();
                    }
                    com.vf5regenlauncher.util.WindowUtil.startMapPip();
                }
            }
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Launcher", "onStart-----> reset/hide PiP");
        com.vf5regenlauncher.util.WindowUtil.visible = false;
        com.vf5regenlauncher.util.WindowUtil.removePip(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mediaWidgetController != null) {
            mediaWidgetController.register();
        }
        if (weatherWidgetController != null) {
            weatherWidgetController.register();
        }
        if (!isAllAppsVisible()) {
            if (appEmbedManager != null) {
                appEmbedManager.updatePipRect();
            }
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.d("Launcher", "onResume-----> startMapPip after 500ms");
                    // Force reset visible state trước khi mở để tránh bị kẹt logic
                    com.vf5regenlauncher.util.WindowUtil.visible = false;
                    com.vf5regenlauncher.util.WindowUtil.startMapPip();
                }
            }, 500);
        } else {
            com.vf5regenlauncher.util.WindowUtil.removePip(pipViews);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaWidgetController != null) {
            mediaWidgetController.unregister();
        }
        if (weatherWidgetController != null) {
            weatherWidgetController.unregister();
        }
        Log.d("Launcher", "Launcher paused - map remains in background mode");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(pipDieReceiver);
        } catch (Throwable e) {
            Log.e("Launcher", "Failed to unregister pipDieReceiver", e);
        }
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

    private enum State {
        NONE,
        WORKSPACE,
        APPS_CUSTOMIZE,
        APPS_CUSTOMIZE_SPRING_LOADED;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] stateArrValuesCustom = values();
            int length = stateArrValuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(stateArrValuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }
}
