package android.support.v4.content;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/EditorCompatGingerbread.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class EditorCompatGingerbread {
    EditorCompatGingerbread() {
    }

    public static void apply(@NonNull SharedPreferences.Editor editor) {
        try {
            editor.apply();
        } catch (AbstractMethodError e) {
            editor.commit();
        }
    }
}
