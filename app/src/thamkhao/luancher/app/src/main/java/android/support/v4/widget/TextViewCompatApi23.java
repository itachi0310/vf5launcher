package android.support.v4.widget;

import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.widget.TextView;

/* JADX INFO: loaded from: Launcher3.apk:libs/android-support-v4.jar:android/support/v4/widget/TextViewCompatApi23.class */
class TextViewCompatApi23 {
    TextViewCompatApi23() {
    }

    public static void setTextAppearance(@NonNull TextView textView, @StyleRes int resId) {
        textView.setTextAppearance(resId);
    }
}
