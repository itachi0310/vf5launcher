package com.syu.util;

import android.app.ActivityManager;
import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AppUtil {
    public static boolean isInTheTaskbar(Context context, String packageName) {
        try {
            ActivityManager manager = (ActivityManager) context.getSystemService("activity");
            List<ActivityManager.RunningTaskInfo> info = manager.getRunningTasks(100);
            for (ActivityManager.RunningTaskInfo runningTaskInfo : info) {
                if (runningTaskInfo.topActivity.getPackageName().equals(packageName) || runningTaskInfo.baseActivity.getPackageName().equals(packageName)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
