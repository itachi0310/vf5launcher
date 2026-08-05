package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/graphics/drawable/DrawableWrapper.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public interface DrawableWrapper {
    Drawable getWrappedDrawable();

    void setCompatTint(int i);

    void setCompatTintList(ColorStateList colorStateList);

    void setCompatTintMode(PorterDuff.Mode mode);

    void setWrappedDrawable(Drawable drawable);
}
