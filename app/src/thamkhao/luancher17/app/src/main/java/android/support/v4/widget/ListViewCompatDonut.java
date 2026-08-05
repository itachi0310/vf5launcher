package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/ListViewCompatDonut.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ListViewCompatDonut {
    ListViewCompatDonut() {
    }

    static void scrollListBy(ListView listView, int y) {
        View firstView;
        int firstPosition = listView.getFirstVisiblePosition();
        if (firstPosition != -1 && (firstView = listView.getChildAt(0)) != null) {
            int newTop = firstView.getTop() - y;
            listView.setSelectionFromTop(firstPosition, newTop);
        }
    }
}
