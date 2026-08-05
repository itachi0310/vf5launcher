package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/content/IntentCompatHoneycomb.class */
class IntentCompatHoneycomb {
    IntentCompatHoneycomb() {
    }

    public static Intent makeMainActivity(ComponentName mainActivity) {
        return Intent.makeMainActivity(mainActivity);
    }

    public static Intent makeRestartActivityTask(ComponentName mainActivity) {
        return Intent.makeRestartActivityTask(mainActivity);
    }
}
