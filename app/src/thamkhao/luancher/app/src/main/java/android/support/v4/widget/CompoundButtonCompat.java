package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/CompoundButtonCompat.class */
public final class CompoundButtonCompat {
    private static final CompoundButtonCompatImpl IMPL;

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/CompoundButtonCompat$CompoundButtonCompatImpl.class */
    interface CompoundButtonCompatImpl {
        void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList);

        ColorStateList getButtonTintList(CompoundButton compoundButton);

        void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode mode);

        PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton);

        Drawable getButtonDrawable(CompoundButton compoundButton);
    }

    static {
        int sdk = Build.VERSION.SDK_INT;
        if (sdk >= 23) {
            IMPL = new Api23CompoundButtonImpl();
        } else if (sdk >= 21) {
            IMPL = new LollipopCompoundButtonImpl();
        } else {
            IMPL = new BaseCompoundButtonCompat();
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/CompoundButtonCompat$BaseCompoundButtonCompat.class */
    static class BaseCompoundButtonCompat implements CompoundButtonCompatImpl {
        BaseCompoundButtonCompat() {
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatImpl
        public void setButtonTintList(CompoundButton button, ColorStateList tint) {
            CompoundButtonCompatDonut.setButtonTintList(button, tint);
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatImpl
        public ColorStateList getButtonTintList(CompoundButton button) {
            return CompoundButtonCompatDonut.getButtonTintList(button);
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatImpl
        public void setButtonTintMode(CompoundButton button, PorterDuff.Mode tintMode) {
            CompoundButtonCompatDonut.setButtonTintMode(button, tintMode);
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatImpl
        public PorterDuff.Mode getButtonTintMode(CompoundButton button) {
            return CompoundButtonCompatDonut.getButtonTintMode(button);
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatImpl
        public Drawable getButtonDrawable(CompoundButton button) {
            return CompoundButtonCompatDonut.getButtonDrawable(button);
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/CompoundButtonCompat$LollipopCompoundButtonImpl.class */
    static class LollipopCompoundButtonImpl extends BaseCompoundButtonCompat {
        LollipopCompoundButtonImpl() {
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.BaseCompoundButtonCompat, android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatImpl
        public void setButtonTintList(CompoundButton button, ColorStateList tint) {
            CompoundButtonCompatLollipop.setButtonTintList(button, tint);
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.BaseCompoundButtonCompat, android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatImpl
        public ColorStateList getButtonTintList(CompoundButton button) {
            return CompoundButtonCompatLollipop.getButtonTintList(button);
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.BaseCompoundButtonCompat, android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatImpl
        public void setButtonTintMode(CompoundButton button, PorterDuff.Mode tintMode) {
            CompoundButtonCompatLollipop.setButtonTintMode(button, tintMode);
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.BaseCompoundButtonCompat, android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatImpl
        public PorterDuff.Mode getButtonTintMode(CompoundButton button) {
            return CompoundButtonCompatLollipop.getButtonTintMode(button);
        }
    }

    /* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/CompoundButtonCompat$Api23CompoundButtonImpl.class */
    static class Api23CompoundButtonImpl extends LollipopCompoundButtonImpl {
        Api23CompoundButtonImpl() {
        }

        @Override // android.support.v4.widget.CompoundButtonCompat.BaseCompoundButtonCompat, android.support.v4.widget.CompoundButtonCompat.CompoundButtonCompatImpl
        public Drawable getButtonDrawable(CompoundButton button) {
            return CompoundButtonCompatApi23.getButtonDrawable(button);
        }
    }

    private CompoundButtonCompat() {
    }

    public static void setButtonTintList(@NonNull CompoundButton button, @Nullable ColorStateList tint) {
        IMPL.setButtonTintList(button, tint);
    }

    @Nullable
    public static ColorStateList getButtonTintList(@NonNull CompoundButton button) {
        return IMPL.getButtonTintList(button);
    }

    public static void setButtonTintMode(@NonNull CompoundButton button, @Nullable PorterDuff.Mode tintMode) {
        IMPL.setButtonTintMode(button, tintMode);
    }

    @Nullable
    public static PorterDuff.Mode getButtonTintMode(@NonNull CompoundButton button) {
        return IMPL.getButtonTintMode(button);
    }

    @Nullable
    public static Drawable getButtonDrawable(@NonNull CompoundButton button) {
        return IMPL.getButtonDrawable(button);
    }
}
