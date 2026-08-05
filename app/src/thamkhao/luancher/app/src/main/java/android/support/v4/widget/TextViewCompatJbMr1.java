package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/TextViewCompatJbMr1.class */
class TextViewCompatJbMr1 {
    TextViewCompatJbMr1() {
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView textView, @Nullable Drawable start, @Nullable Drawable top, @Nullable Drawable end, @Nullable Drawable bottom) {
        boolean rtl = textView.getLayoutDirection() == 1;
        textView.setCompoundDrawables(rtl ? end : start, top, rtl ? start : end, bottom);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @Nullable Drawable start, @Nullable Drawable top, @Nullable Drawable end, @Nullable Drawable bottom) {
        boolean rtl = textView.getLayoutDirection() == 1;
        textView.setCompoundDrawablesWithIntrinsicBounds(rtl ? end : start, top, rtl ? start : end, bottom);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, int start, int top, int end, int bottom) {
        boolean rtl = textView.getLayoutDirection() == 1;
        textView.setCompoundDrawablesWithIntrinsicBounds(rtl ? end : start, top, rtl ? start : end, bottom);
    }
}
