package android.support.v4.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/text/TextUtilsCompatJellybeanMr1.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class TextUtilsCompatJellybeanMr1 {
    TextUtilsCompatJellybeanMr1() {
    }

    @NonNull
    public static String htmlEncode(@NonNull String s) {
        return TextUtils.htmlEncode(s);
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
