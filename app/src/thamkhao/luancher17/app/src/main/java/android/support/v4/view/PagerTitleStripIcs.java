package android.support.v4.view;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/PagerTitleStripIcs.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
class PagerTitleStripIcs {
    PagerTitleStripIcs() {
    }

    public static void setSingleLineAllCaps(TextView text) {
        text.setTransformationMethod(new SingleLineAllCapsTransform(text.getContext()));
    }

    /* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/PagerTitleStripIcs$SingleLineAllCapsTransform.class
  classes.dex
 */
    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private static final String TAG = "SingleLineAllCapsTransform";
        private Locale mLocale;

        public SingleLineAllCapsTransform(Context context) {
            this.mLocale = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence source, View view) {
            CharSequence source2 = super.getTransformation(source, view);
            if (source2 != null) {
                return source2.toString().toUpperCase(this.mLocale);
            }
            return null;
        }
    }
}
