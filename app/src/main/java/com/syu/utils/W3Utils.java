package com.syu.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.syu.remote.Callback;
import com.syu.util.FytPackage;
import java.util.ArrayList;
import java.util.List;

/**
 * Standard SYU W3Utils.
 */
public class W3Utils implements Callback.OnRefreshLisenter {
    static List<String> mFilterApps = new ArrayList<>();
    static W3Utils utils = null;

    public static W3Utils initialize(Context context) {
        if (utils == null) {
            utils = new W3Utils(context);
        }
        return utils;
    }

    W3Utils(Context context) {
        // Core Filter Apps
        addFilterApp(FytPackage.GaodeACTION);
        addFilterApp(FytPackage.mapsAction);
    }

    public static void addFilterApp(String pkg) {
        if (pkg != null && !mFilterApps.contains(pkg)) {
            mFilterApps.add(pkg);
        }
    }

    @Override
    public void onRefresh(int i, int[] iArr, float[] fArr, String[] strArr) {
        // Standard refresh logic
    }
}
