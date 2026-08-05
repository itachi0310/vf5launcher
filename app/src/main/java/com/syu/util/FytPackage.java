package com.syu.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/**
 * Port of FytPackage from launcher17.
 * Standardizes app package names and Intent generation.
 */
public class FytPackage {
    public static final String GaodeACTION = "com.autonavi.amapauto";
    public static final String mapsAction = "com.google.android.apps.maps";
    public static final String browserAction = "com.android.browser";
    public static final String sysSetAction = "com.android.settings";
    public static final String fourcamera2Action = "com.syu.fourcamera2";

    public static Intent getIntent(Context context, String pkg) {
        Intent mainIntent;
        Intent intent;
        if (pkg.equals(sysSetAction)) {
            intent = new Intent("android.settings.SETTINGS");
            mainIntent = new Intent("android.settings.SETTINGS", null);
        } else {
            mainIntent = new Intent(Intent.ACTION_MAIN, null);
            intent = new Intent(Intent.ACTION_MAIN);
        }
        mainIntent.setPackage(pkg);
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> apps = pm.queryIntentActivities(mainIntent, 0);
        for (ResolveInfo res : apps) {
            if (res.activityInfo.packageName.equals(pkg)) {
                Log.d("FytPackage", "Target class: " + res.activityInfo.name);
                intent = new Intent(Intent.ACTION_MAIN);
                // Standard SYU Flag: 0x10200000 | 0x00000001 (standard) -> 270532608 (standard)
                intent.setFlags(270532608); 
                intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            }
        }
        return intent;
    }
}
