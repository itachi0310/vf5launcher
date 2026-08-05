package android.support.v4.content;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/content/EditorCompatGingerbread.class */
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
