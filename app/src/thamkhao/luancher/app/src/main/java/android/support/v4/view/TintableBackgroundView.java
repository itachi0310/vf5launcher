package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/view/TintableBackgroundView.class */
public interface TintableBackgroundView {
    void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList);

    @Nullable
    ColorStateList getSupportBackgroundTintList();

    void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode);

    @Nullable
    PorterDuff.Mode getSupportBackgroundTintMode();
}
