package android.support.v4.content.res;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/res/ResourcesCompatIcsMr1.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ResourcesCompatIcsMr1 {
    ResourcesCompatIcsMr1() {
    }

    public static Drawable getDrawableForDensity(Resources res, int id, int density) throws Resources.NotFoundException {
        return res.getDrawableForDensity(id, density);
    }
}
