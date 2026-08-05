package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/TintableCompoundButton.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
public interface TintableCompoundButton {
    @Nullable
    ColorStateList getSupportButtonTintList();

    @Nullable
    PorterDuff.Mode getSupportButtonTintMode();

    void setSupportButtonTintList(@Nullable ColorStateList colorStateList);

    void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode);
}
