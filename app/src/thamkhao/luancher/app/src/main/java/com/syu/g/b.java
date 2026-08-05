package com.syu.g;

import android.app.ActivityManager;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static boolean a(Context context, String str) {
        try {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(100)) {
                if (runningTaskInfo.topActivity.getPackageName().equals(str) || runningTaskInfo.baseActivity.getPackageName().equals(str)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
