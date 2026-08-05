package android.support.v4.widget;

import android.os.Build;
import android.support.annotation.NonNull;
import android.widget.ListView;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/ListViewCompat.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public final class ListViewCompat {
    public static void scrollListBy(@NonNull ListView listView, int y) {
        if (Build.VERSION.SDK_INT >= 19) {
            ListViewCompatKitKat.scrollListBy(listView, y);
        } else {
            ListViewCompatDonut.scrollListBy(listView, y);
        }
    }

    private ListViewCompat() {
    }
}
