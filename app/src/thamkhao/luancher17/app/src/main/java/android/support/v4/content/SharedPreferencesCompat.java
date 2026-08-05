package android.support.v4.content;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/SharedPreferencesCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesCompat {

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/SharedPreferencesCompat$EditorCompat.class
  classes.dex
 */
    public static final class EditorCompat {
        private static EditorCompat sInstance;
        private final Helper mHelper;

        /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/SharedPreferencesCompat$EditorCompat$Helper.class
  classes.dex
 */
        private interface Helper {
            void apply(@NonNull SharedPreferences.Editor editor);
        }

        /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/SharedPreferencesCompat$EditorCompat$EditorHelperBaseImpl.class
  classes.dex
 */
        private static class EditorHelperBaseImpl implements Helper {
            private EditorHelperBaseImpl() {
            }

            @Override // android.support.v4.content.SharedPreferencesCompat.EditorCompat.Helper
            public void apply(@NonNull SharedPreferences.Editor editor) {
                editor.commit();
            }
        }

        /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/SharedPreferencesCompat$EditorCompat$EditorHelperApi9Impl.class
  classes.dex
 */
        private static class EditorHelperApi9Impl implements Helper {
            private EditorHelperApi9Impl() {
            }

            @Override // android.support.v4.content.SharedPreferencesCompat.EditorCompat.Helper
            public void apply(@NonNull SharedPreferences.Editor editor) {
                EditorCompatGingerbread.apply(editor);
            }
        }

        private EditorCompat() {
            if (Build.VERSION.SDK_INT >= 9) {
                this.mHelper = new EditorHelperApi9Impl();
            } else {
                this.mHelper = new EditorHelperBaseImpl();
            }
        }

        public static EditorCompat getInstance() {
            if (sInstance == null) {
                sInstance = new EditorCompat();
            }
            return sInstance;
        }

        public void apply(@NonNull SharedPreferences.Editor editor) {
            this.mHelper.apply(editor);
        }
    }

    private SharedPreferencesCompat() {
    }
}
