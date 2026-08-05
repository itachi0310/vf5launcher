package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/ContextCompatJellybean.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ContextCompatJellybean {
    ContextCompatJellybean() {
    }

    public static void startActivities(Context context, Intent[] intents, Bundle options) {
        context.startActivities(intents, options);
    }
}
