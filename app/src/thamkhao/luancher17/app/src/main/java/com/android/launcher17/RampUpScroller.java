package com.android.launcher17;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
class RampUpScroller {
    private long mDeltaTime;
    private int mDeltaX;
    private int mDeltaY;
    private final Interpolator mInterpolator = new AccelerateInterpolator();
    private final long mRampUpTime;
    private long mStartTime;
    private float mTargetVelocityX;
    private float mTargetVelocityY;

    public RampUpScroller(long rampUpTime) {
        this.mRampUpTime = rampUpTime;
    }

    public void start() {
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mDeltaTime = this.mStartTime;
    }

    public void computeScrollDelta() {
        float scale;
        long currentTime = AnimationUtils.currentAnimationTimeMillis();
        long elapsedSinceStart = currentTime - this.mStartTime;
        if (elapsedSinceStart < this.mRampUpTime) {
            scale = this.mInterpolator.getInterpolation(elapsedSinceStart / this.mRampUpTime);
        } else {
            scale = 1.0f;
        }
        long elapsedSinceDelta = currentTime - this.mDeltaTime;
        this.mDeltaTime = currentTime;
        this.mDeltaX = (int) (elapsedSinceDelta * scale * this.mTargetVelocityX);
        this.mDeltaY = (int) (elapsedSinceDelta * scale * this.mTargetVelocityY);
    }

    public void setTargetVelocity(float x, float y) {
        this.mTargetVelocityX = x;
        this.mTargetVelocityY = y;
    }

    public float getTargetVelocityX() {
        return this.mTargetVelocityX;
    }

    public float getTargetVelocityY() {
        return this.mTargetVelocityY;
    }

    public int getDeltaX() {
        return this.mDeltaX;
    }

    public int getDeltaY() {
        return this.mDeltaY;
    }
}
