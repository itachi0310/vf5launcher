package android.support.v4.app;

import android.text.Html;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/app/ShareCompatJB.class */
class ShareCompatJB {
    ShareCompatJB() {
    }

    public static String escapeHtml(CharSequence html) {
        return Html.escapeHtml(html);
    }
}
