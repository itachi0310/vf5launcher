package com.vf5regenlauncher;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickBarController {
    private static final String TAG = "QuickBarController";
    private static final String PREF_KEY_PREFIX = "quick_app_slot_";

    private final AndrewLauncherActivity activity;
    private final ImageView[] slotViews = new ImageView[3];
    private final String[] slotPackages = new String[3];

    private View layoutRightWidgets;
    private View containerPipWrapper;

    public QuickBarController(AndrewLauncherActivity activity) {
        this.activity = activity;
        initViews();
        loadSlotData();
    }

    private void initViews() {
        slotViews[0] = activity.findViewById(R.id.btn_quick_app_1);
        slotViews[1] = activity.findViewById(R.id.btn_quick_app_2);
        slotViews[2] = activity.findViewById(R.id.btn_quick_app_3);

        layoutRightWidgets = activity.findViewById(R.id.layout_right_widgets);
        containerPipWrapper = activity.findViewById(R.id.container_pip_wrapper);

        for (int i = 0; i < 3; i++) {
            final int slotIndex = i;
            if (slotViews[i] != null) {
                slotViews[i].setOnClickListener(v -> onSlotClick(slotIndex));
                slotViews[i].setOnLongClickListener(v -> {
                    showAppPickerForSlot(slotIndex);
                    return true;
                });
            }
        }
    }

    private void loadSlotData() {
        SharedPreferences sp = activity.getSharedPreferences("launcher_prefs", Context.MODE_PRIVATE);
        for (int i = 0; i < 3; i++) {
            slotPackages[i] = sp.getString(PREF_KEY_PREFIX + i, "");
            updateSlotUI(i);
        }
    }

    private void updateSlotUI(int slotIndex) {
        ImageView imgView = slotViews[slotIndex];
        if (imgView == null) return;

        String pkg = slotPackages[slotIndex];
        if (pkg != null && !pkg.isEmpty()) {
            try {
                PackageManager pm = activity.getPackageManager();
                Drawable icon = pm.getApplicationIcon(pkg);
                imgView.setImageDrawable(icon);
                imgView.clearColorFilter(); // Loại bỏ app:tint để hiển thị icon màu gốc
                return;
            } catch (PackageManager.NameNotFoundException e) {
                Log.w(TAG, "App not found for package: " + pkg);
            }
        }

        // Mặc định nếu chưa chọn app
        imgView.setImageResource(android.R.drawable.ic_input_add);
        imgView.setColorFilter(0x77FFFFFF); // Dùng tint xám nhạt
    }

    private void onSlotClick(int slotIndex) {
        String pkg = slotPackages[slotIndex];
        if (pkg == null || pkg.isEmpty()) {
            showAppPickerForSlot(slotIndex);
        } else {
            launchAppInExpandedPip(pkg);
        }
    }

    public void launchAppInExpandedPip(String packageName) {
        AppEmbedManager embedManager = activity.getAppEmbedManager();
        if (embedManager == null) return;

        // 1. Ẩn 2 Widget Thời tiết & Nhạc bên phải
        if (layoutRightWidgets != null) {
            layoutRightWidgets.setVisibility(View.GONE);
        }

        // 2. Mở rộng khung PiP ra 100% chiều rộng cột phải
        if (containerPipWrapper != null) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) containerPipWrapper.getLayoutParams();
            params.weight = 100f;
            containerPipWrapper.setLayoutParams(params);
        }

        // 3. Khởi chạy app trong PiP và cập nhật tọa độ mới
        embedManager.launchApp(packageName);
        if (containerPipWrapper != null) {
            containerPipWrapper.post(() -> embedManager.updatePipRect());
        }
        Log.d(TAG, "Launched app in EXPANDED PiP: " + packageName);
    }

    public void restoreDefaultMapAndWidgets() {
        // 1. Hiện lại 2 Widget Thời tiết & Nhạc
        if (layoutRightWidgets != null) {
            layoutRightWidgets.setVisibility(View.VISIBLE);
        }

        // 2. Khôi phục kích thước PiP về 65% mặc định
        if (containerPipWrapper != null) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) containerPipWrapper.getLayoutParams();
            params.weight = 65f;
            containerPipWrapper.setLayoutParams(params);
        }

        // 3. Cập nhật lại bản đồ mặc định
        AppEmbedManager embedManager = activity.getAppEmbedManager();
        if (embedManager != null) {
            SharedPreferences sp = activity.getSharedPreferences("driving_prefs", Context.MODE_PRIVATE);
            String defaultMap = sp.getString("default_map_package", "com.vietmap.vietmaplive");
            embedManager.launchApp(defaultMap);
            if (containerPipWrapper != null) {
                containerPipWrapper.post(() -> embedManager.updatePipRect());
            }
        }
        Log.d(TAG, "Restored default map and right widgets layout");
    }

    private void showAppPickerForSlot(final int slotIndex) {
        final PackageManager pm = activity.getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> pkgAppsList = pm.queryIntentActivities(mainIntent, 0);

        Collections.sort(pkgAppsList, (o1, o2) ->
                o1.loadLabel(pm).toString().compareToIgnoreCase(o2.loadLabel(pm).toString()));

        final List<String> appNames = new ArrayList<>();
        final List<String> packageNames = new ArrayList<>();

        // Thêm tùy chọn Xóa Shortcut nếu đang có app
        boolean hasExistingApp = slotPackages[slotIndex] != null && !slotPackages[slotIndex].isEmpty();
        if (hasExistingApp) {
            appNames.add("❌ [Xóa phím tắt này]");
            packageNames.add("");
        }

        for (ResolveInfo ri : pkgAppsList) {
            appNames.add(ri.loadLabel(pm).toString());
            packageNames.add(ri.activityInfo.packageName);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Chọn ứng dụng cho Phím tắt " + (slotIndex + 1));
        builder.setItems(appNames.toArray(new CharSequence[0]), (dialog, which) -> {
            String selectedPkg = packageNames.get(which);
            slotPackages[slotIndex] = selectedPkg;

            activity.getSharedPreferences("launcher_prefs", Context.MODE_PRIVATE)
                    .edit()
                    .putString(PREF_KEY_PREFIX + slotIndex, selectedPkg)
                    .apply();

            updateSlotUI(slotIndex);

            if (!selectedPkg.isEmpty()) {
                Toast.makeText(activity, "Đã gán Phím tắt " + (slotIndex + 1) + ": " + appNames.get(which), Toast.LENGTH_SHORT).show();
                launchAppInExpandedPip(selectedPkg);
            } else {
                Toast.makeText(activity, "Đã xóa phím tắt " + (slotIndex + 1), Toast.LENGTH_SHORT).show();
                restoreDefaultMapAndWidgets();
            }
        });
        builder.show();
    }
}
