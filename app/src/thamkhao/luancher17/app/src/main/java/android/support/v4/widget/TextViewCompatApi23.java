package android.support.v4.widget;

import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/widget/TextViewCompatApi23.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class TextViewCompatApi23 {
    TextViewCompatApi23() {
    }

    public static void setTextAppearance(@NonNull TextView textView, @StyleRes int resId) {
        textView.setTextAppearance(resId);
    }
}
