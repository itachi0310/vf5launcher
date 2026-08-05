package android.support.v4.app;

import android.text.Html;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/ShareCompatJB.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ShareCompatJB {
    ShareCompatJB() {
    }

    public static String escapeHtml(CharSequence html) {
        return Html.escapeHtml(html);
    }
}
