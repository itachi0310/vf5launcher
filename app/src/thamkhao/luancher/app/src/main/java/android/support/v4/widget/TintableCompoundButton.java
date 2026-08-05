package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/TintableCompoundButton.class */
public interface TintableCompoundButton {
    void setSupportButtonTintList(@Nullable ColorStateList colorStateList);

    @Nullable
    ColorStateList getSupportButtonTintList();

    void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode);

    @Nullable
    PorterDuff.Mode getSupportButtonTintMode();
}
