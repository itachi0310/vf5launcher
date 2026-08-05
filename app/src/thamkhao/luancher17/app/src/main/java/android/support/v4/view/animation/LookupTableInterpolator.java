package android.support.v4.view.animation;

import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted, all sources:
  190001025_com.android.launcher17.apk:libs/android-support-v4.jar:android/support/v4/view/animation/LookupTableInterpolator.class
  classes.dex
 */
/* JADX INFO: loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] values) {
        this.mValues = values;
        this.mStepSize = 1.0f / (this.mValues.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        if (input >= 1.0f) {
            return 1.0f;
        }
        if (input <= 0.0f) {
            return 0.0f;
        }
        int position = Math.min((int) ((this.mValues.length - 1) * input), this.mValues.length - 2);
        float quantized = position * this.mStepSize;
        float diff = input - quantized;
        float weight = diff / this.mStepSize;
        return this.mValues[position] + ((this.mValues[position + 1] - this.mValues[position]) * weight);
    }
}
