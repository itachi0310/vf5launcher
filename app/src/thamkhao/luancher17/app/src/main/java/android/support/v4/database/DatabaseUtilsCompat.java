package android.support.v4.database;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/database/DatabaseUtilsCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class DatabaseUtilsCompat {
    private DatabaseUtilsCompat() {
    }

    public static String concatenateWhere(String a, String b) {
        if (TextUtils.isEmpty(a)) {
            return b;
        }
        return TextUtils.isEmpty(b) ? a : "(" + a + ") AND (" + b + ")";
    }

    public static String[] appendSelectionArgs(String[] originalValues, String[] newValues) {
        if (originalValues == null || originalValues.length == 0) {
            return newValues;
        }
        String[] result = new String[originalValues.length + newValues.length];
        System.arraycopy(originalValues, 0, result, 0, originalValues.length);
        System.arraycopy(newValues, 0, result, originalValues.length, newValues.length);
        return result;
    }
}
