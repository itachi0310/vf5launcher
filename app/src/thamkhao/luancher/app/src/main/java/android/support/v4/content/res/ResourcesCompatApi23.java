package android.support.v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/content/res/ResourcesCompatApi23.class */
class ResourcesCompatApi23 {
    ResourcesCompatApi23() {
    }

    public static int getColor(Resources res, int id, Resources.Theme theme) throws Resources.NotFoundException {
        return res.getColor(id, theme);
    }

    public static ColorStateList getColorStateList(Resources res, int id, Resources.Theme theme) throws Resources.NotFoundException {
        return res.getColorStateList(id, theme);
    }
}
