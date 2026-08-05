package com.vf5regenlauncher;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.syu.util.FytPackage;
import com.syu.util.WindowUtil;
import com.syu.car.CarStates;

/**
 * Port of BottomNav to Launcher17 architecture.
 * Manages apps, settings, and climate controls.
 */
public class BottomNavController {
    private final Activity activity;

    public BottomNavController(Activity activity) {
        this.activity = activity;
        setupListeners();
    }

    private void setupListeners() {
        View btnApps = activity.findViewById(R.id.btn_nav_apps);
        View btnAc = activity.findViewById(R.id.btn_ac_toggle);
        View btnFanUp = activity.findViewById(R.id.btn_fan_up);
        View btnFanDown = activity.findViewById(R.id.btn_fan_down);
        View btnTempUp = activity.findViewById(R.id.btn_temp_up);
        View btnTempDown = activity.findViewById(R.id.btn_temp_down);

        if (btnApps != null) btnApps.setOnClickListener(v -> {
            if (activity instanceof AndrewLauncherActivity) {
                ((AndrewLauncherActivity) activity).openSystemAppList();
            }
        });

        // Climate Controls using CarStates/RemoteTools (SYU standard)
        // Note: These IDs (21, 20, etc.) are placeholders, they vary by Canbus
        if (btnAc != null) btnAc.setOnClickListener(v -> sendCmd(1, 21, 1)); 
        if (btnFanUp != null) btnFanUp.setOnClickListener(v -> sendCmd(1, 20, 1));
        if (btnFanDown != null) btnFanDown.setOnClickListener(v -> sendCmd(1, 20, 0));
    }

    private void sendCmd(int module, int code, int val) {
        CarStates.getCar(activity).getTools().sendInt(module, code, val);
    }

    private void launchApp(String pkg) {
        WindowUtil.removePip();
        try {
            Intent intent = FytPackage.getIntent(activity, pkg);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(intent);
        } catch (Exception e) {
            Log.e("BottomNav", "Could not launch " + pkg, e);
        }
    }
}
