package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.CompoundButton;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/CompoundButtonCompatLollipop.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class CompoundButtonCompatLollipop {
    CompoundButtonCompatLollipop() {
    }

    static void setButtonTintList(CompoundButton button, ColorStateList tint) {
        button.setButtonTintList(tint);
    }

    static ColorStateList getButtonTintList(CompoundButton button) {
        return button.getButtonTintList();
    }

    static void setButtonTintMode(CompoundButton button, PorterDuff.Mode tintMode) {
        button.setButtonTintMode(tintMode);
    }

    static PorterDuff.Mode getButtonTintMode(CompoundButton button) {
        return button.getButtonTintMode();
    }
}
