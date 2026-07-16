package com.vf5regenlauncher;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppListActivity extends Activity {
    private PackageManager packageManager;
    private List<AppInfo> apps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);

        packageManager = getPackageManager();
        apps = new ArrayList<>();

        loadApps();

        GridView gridView = findViewById(R.id.apps_grid);
        gridView.setAdapter(new AppAdapter());

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            AppInfo app = apps.get(position);
            // Mở ứng dụng bình thường toàn màn hình
            Intent intent = packageManager.getLaunchIntentForPackage(app.packageName);
            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    private void loadApps() {
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities = packageManager.queryIntentActivities(intent, 0);
        for (ResolveInfo ri : availableActivities) {
            AppInfo app = new AppInfo();
            app.label = ri.loadLabel(packageManager).toString();
            app.packageName = ri.activityInfo.packageName;
            app.icon = ri.activityInfo.loadIcon(packageManager);
            apps.add(app);
        }
        Collections.sort(apps, (a, b) -> a.label.compareToIgnoreCase(b.label));
    }

    private class AppInfo {
        String label;
        String packageName;
        Drawable icon;
    }

    private class AppAdapter extends ArrayAdapter<AppInfo> {
        public AppAdapter() {
            super(AppListActivity.this, R.layout.item_app, apps);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_app, parent, false);
            }

            AppInfo app = apps.get(position);
            ImageView icon = convertView.findViewById(R.id.app_icon);
            TextView label = convertView.findViewById(R.id.app_label);

            icon.setImageDrawable(app.icon);
            label.setText(app.label);

            return convertView;
        }
    }
}
