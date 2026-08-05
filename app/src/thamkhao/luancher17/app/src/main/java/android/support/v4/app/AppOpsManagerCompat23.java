package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/AppOpsManagerCompat23.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class AppOpsManagerCompat23 {
    AppOpsManagerCompat23() {
    }

    public static String permissionToOp(String permission) {
        return AppOpsManager.permissionToOp(permission);
    }

    public static int noteOp(Context context, String op, int uid, String packageName) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        return appOpsManager.noteOp(op, uid, packageName);
    }

    public static int noteProxyOp(Context context, String op, String proxiedPackageName) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        return appOpsManager.noteProxyOp(op, proxiedPackageName);
    }
}
