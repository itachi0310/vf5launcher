package com.android.launcher17;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ShortcutInfo extends ItemInfo {
    boolean customIcon;
    long firstInstallTime;
    int flags;
    private int iconResid;
    Intent.ShortcutIconResource iconResource;
    Intent intent;
    private Bitmap mAppIcon;
    private Bitmap mIcon;
    boolean usingFallbackIcon;

    public void setIconResid(int iconResid) {
        this.iconResid = iconResid;
    }

    public int getIconResid() {
        return this.iconResid;
    }

    ShortcutInfo() {
        this.flags = 0;
        this.itemType = 1;
    }

    @Override // com.android.launcher17.ItemInfo
    protected Intent getIntent() {
        return this.intent;
    }

    public ShortcutInfo(Context context, ShortcutInfo info) {
        super(info);
        this.flags = 0;
        this.title = info.title.toString();
        this.intent = new Intent(info.intent);
        if (info.iconResource != null) {
            this.iconResource = new Intent.ShortcutIconResource();
            this.iconResource.packageName = info.iconResource.packageName;
            this.iconResource.resourceName = info.iconResource.resourceName;
        }
        this.mIcon = info.mIcon;
        this.customIcon = info.customIcon;
        initFlagsAndFirstInstallTime(getPackageInfo(context, this.intent.getComponent().getPackageName()));
    }

    public ShortcutInfo(AppInfo info) {
        super(info);
        this.flags = 0;
        this.title = info.title.toString();
        this.intent = new Intent(info.intent);
        this.customIcon = false;
        this.flags = info.flags;
        this.firstInstallTime = info.firstInstallTime;
        this.iconResid = info.getIconResid();
        this.mAppIcon = info.appIcon;
    }

    public static PackageInfo getPackageInfo(Context context, String packageName) {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi;
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("ShortcutInfo", "PackageManager.getPackageInfo failed for " + packageName);
            return null;
        }
    }

    void initFlagsAndFirstInstallTime(PackageInfo pi) {
        this.flags = AppInfo.initFlags(pi);
        this.firstInstallTime = AppInfo.initFirstInstallTime(pi);
    }

    public void setIcon(Bitmap b) {
        this.mIcon = b;
    }

    public void setAppIcon(Bitmap b) {
        this.mAppIcon = b;
    }

    public Bitmap getAppIcon() {
        return this.mAppIcon;
    }

    public Bitmap getIcon(IconCache iconCache) {
        if (this.mIcon == null) {
            updateIcon(iconCache);
        }
        return this.mIcon;
    }

    public void updateIcon(IconCache iconCache) {
        this.mIcon = iconCache.getIcon(this.intent);
        this.usingFallbackIcon = iconCache.isDefaultIcon(this.mIcon);
    }

    final void setActivity(Context context, ComponentName className, int launchFlags) {
        this.intent = new Intent("android.intent.action.MAIN");
        this.intent.addCategory("android.intent.category.LAUNCHER");
        this.intent.setComponent(className);
        this.intent.setFlags(launchFlags);
        this.itemType = 0;
        initFlagsAndFirstInstallTime(getPackageInfo(context, this.intent.getComponent().getPackageName()));
    }

    @Override // com.android.launcher17.ItemInfo
    void onAddToDatabase(ContentValues values) {
        super.onAddToDatabase(values);
        String titleStr = this.title != null ? this.title.toString() : null;
        values.put("title", titleStr);
        String uri = this.intent != null ? this.intent.toUri(0) : null;
        values.put("intent", uri);
        if (this.customIcon) {
            values.put(LauncherSettings.BaseLauncherColumns.ICON_TYPE, (Integer) 1);
            writeBitmap(values, this.mIcon);
            return;
        }
        if (!this.usingFallbackIcon) {
            writeBitmap(values, this.mIcon);
        }
        values.put(LauncherSettings.BaseLauncherColumns.ICON_TYPE, (Integer) 0);
        if (this.iconResource != null) {
            values.put(LauncherSettings.BaseLauncherColumns.ICON_PACKAGE, this.iconResource.packageName);
            values.put("iconResource", this.iconResource.resourceName);
        }
    }

    @Override // com.android.launcher17.ItemInfo
    public String toString() {
        return "ShortcutInfo(title=" + this.title.toString() + "intent=" + this.intent + "id=" + this.id + " type=" + this.itemType + " container=" + this.container + " screen=" + this.screenId + " cellX=" + this.cellX + " cellY=" + this.cellY + " spanX=" + this.spanX + " spanY=" + this.spanY + " dropPos=" + this.dropPos + ")";
    }

    public static void dumpShortcutInfoList(String tag, String label, ArrayList<ShortcutInfo> list) {
        Log.d(tag, String.valueOf(label) + " size=" + list.size());
        for (ShortcutInfo info : list) {
            Log.d(tag, "   title=\"" + ((Object) info.title) + " icon=" + info.mIcon + " customIcon=" + info.customIcon);
        }
    }
}
