package android.support.v4.app;

import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/app/ActivityOptionsCompatJB.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ActivityOptionsCompatJB {
    private final ActivityOptions mActivityOptions;

    public static ActivityOptionsCompatJB makeCustomAnimation(Context context, int enterResId, int exitResId) {
        return new ActivityOptionsCompatJB(ActivityOptions.makeCustomAnimation(context, enterResId, exitResId));
    }

    public static ActivityOptionsCompatJB makeScaleUpAnimation(View source, int startX, int startY, int startWidth, int startHeight) {
        return new ActivityOptionsCompatJB(ActivityOptions.makeScaleUpAnimation(source, startX, startY, startWidth, startHeight));
    }

    public static ActivityOptionsCompatJB makeThumbnailScaleUpAnimation(View source, Bitmap thumbnail, int startX, int startY) {
        return new ActivityOptionsCompatJB(ActivityOptions.makeThumbnailScaleUpAnimation(source, thumbnail, startX, startY));
    }

    private ActivityOptionsCompatJB(ActivityOptions activityOptions) {
        this.mActivityOptions = activityOptions;
    }

    public Bundle toBundle() {
        return this.mActivityOptions.toBundle();
    }

    public void update(ActivityOptionsCompatJB otherOptions) {
        this.mActivityOptions.update(otherOptions.mActivityOptions);
    }
}
