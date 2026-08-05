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
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.syu.car.CarStates;
import com.syu.util.FytPackage;
import com.syu.util.WindowUtil;

/**
 * Main Activity refactored to follow Launcher17 architecture.
 * Uses CarStates for IPC and WindowUtil for PiP.
 */
public class AndrewLauncherActivity extends AppCompatActivity {
    private static AndrewLauncherActivity instance;
    private DashboardController dashboardController;
    private BottomNavController bottomNavController;
    private TopBarController topBarController;
    private DrivingAssistant drivingAssistant;
    private CarStates mCarStates;

    public static AndrewLauncherActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_andrew_launcher);

        // 1. Framework Permissions
        checkOverlayPermission();
        checkWriteSettingsPermission();

        // 2. Framework State Management
        mCarStates = CarStates.getCar(this);

        // 3. Controllers Integration
        dashboardController = new DashboardController(this);
        bottomNavController = new BottomNavController(this);
        topBarController = new TopBarController(this);
        drivingAssistant = new DrivingAssistant(this);

        // 4. UI Events
        setupPipContainer();

        // 5. System Receivers
        initRegisterReceiver();
    }

    private void setupPipContainer() {
        FrameLayout container = findViewById(R.id.container_main_app);
        if (container != null) {
            container.addOnLayoutChangeListener((v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom) -> {
                if (left != oldLeft || top != oldTop || right != oldRight || bottom != oldBottom) {
                    measureAndSavePipRect(container);
                }
            });
            container.post(() -> measureAndSavePipRect(container));
        }
    }

    private void measureAndSavePipRect(FrameLayout container) {
        int[] location = new int[2];
        container.getLocationOnScreen(location);
        int w = container.getWidth();
        int h = container.getHeight();
        if (w > 0 && h > 0) {
            String rect = java.util.Locale.US != null ? 
                String.format(java.util.Locale.US, "%d %d %d %d", location[0], location[1], location[0] + w, location[1] + h) :
                String.format("%d %d %d %d", location[0], location[1], location[0] + w, location[1] + h);
            SystemPropertiesUtil.set("sys.lsec.pip_rect", rect);
            Log.d("Launcher", "Updated PIP Rect: " + rect);
        }
    }

    private void initRegisterReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.lsec.pipdie");
        registerReceiver(mPipDieReceiver, filter);
    }

    private final android.content.BroadcastReceiver mPipDieReceiver = new android.content.BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("com.lsec.pipdie".equals(intent.getAction())) {
                Log.d("Launcher", "PiP died, restarting...");
                WindowUtil.startMapPip();
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Launcher", "onResume - Activating Framework PiP");
        WindowUtil.startMapPip();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Launcher", "onStop - Deactivating Framework PiP");
        WindowUtil.removePip();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            int keyCode = event.getKeyCode();
            // SYU Handle Special Keys (Mode, Menu)
            if (keyCode == 176 || keyCode == 209) {
                if (dashboardController != null) dashboardController.toggleDriveMode();
                return true;
            }
            if (keyCode == 82 || keyCode == 187) {
                openSystemAppList();
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    public void openSystemAppList() {
        WindowUtil.removePip();
        Intent intent = new Intent(this, AppListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void checkOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        }
    }

    private void checkWriteSettingsPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.System.canWrite(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        // Block back button like a true launcher
    }
}
