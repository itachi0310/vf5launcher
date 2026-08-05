package com.syu.utils;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

/* JADX INFO: loaded from: Launcher3.apk:bin/autolib.jar:com/syu/utils/ActivityUtils.class */
public class ActivityUtils {
    public static boolean startActivitySafely(@NonNull Context context, Intent intent, int... flags) {
        boolean success = false;
        if (context != null && intent != null) {
            if (flags != null && flags.length > 0) {
                for (int flag : flags) {
                    intent.addFlags(flag);
                }
            } else {
                intent.addFlags(270532608);
            }
            try {
                context.startActivity(intent);
                success = true;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return success;
    }

    public static boolean startActivitySafelyForAction(@NonNull Context context, String action, String pkg, int... flags) {
        boolean success = false;
        if (action != null && action.length() > 0) {
            Intent intent = new Intent(action);
            if (pkg != null && pkg.length() > 0) {
                intent.setPackage(pkg);
            }
            success = startActivitySafely(context, intent, new int[0]);
        }
        return success;
    }

    public static boolean startActivitySafelyForComponentName(@NonNull Context context, String clazz, String pkg, int... flags) {
        boolean success = false;
        boolean hasClazz = clazz != null && clazz.length() > 0;
        boolean hasPkg = pkg != null && pkg.length() > 0;
        if (hasClazz && hasPkg) {
            Intent intent = new Intent();
            ComponentName c = new ComponentName(pkg, clazz);
            intent.setComponent(c);
            success = startActivitySafely(context, intent, new int[0]);
        }
        return success;
    }
}
