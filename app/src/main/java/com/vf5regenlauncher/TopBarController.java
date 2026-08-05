package com.vf5regenlauncher;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.syu.util.WindowUtil;

/**
 * Port of TopBar to Launcher17 architecture.
 */
public class TopBarController {
    private final Activity activity;

    public TopBarController(Activity activity) {
        this.activity = activity;
        setupListeners();
    }

    private void setupListeners() {
        View btnSettings = activity.findViewById(R.id.btn_top_settings);
        if (btnSettings != null) {
            btnSettings.setOnClickListener(v -> {
                WindowUtil.removePip();
                activity.startActivity(new Intent(activity, SettingsActivity.class));
            });
        }
    }
}
