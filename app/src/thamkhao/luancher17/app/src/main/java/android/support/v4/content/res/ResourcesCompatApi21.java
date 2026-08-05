package android.support.v4.content.res;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/content/res/ResourcesCompatApi21.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class ResourcesCompatApi21 {
    ResourcesCompatApi21() {
    }

    public static Drawable getDrawable(Resources res, int id, Resources.Theme theme) throws Resources.NotFoundException {
        return res.getDrawable(id, theme);
    }

    public static Drawable getDrawableForDensity(Resources res, int id, int density, Resources.Theme theme) throws Resources.NotFoundException {
        return res.getDrawableForDensity(id, density, theme);
    }
}
