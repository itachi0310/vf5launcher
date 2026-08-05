package com.android.gallery3d.glrenderer;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class RawTexture extends BasicTexture {
    private static final String TAG = "RawTexture";
    private boolean mIsFlipped;
    private final boolean mOpaque;

    public RawTexture(int width, int height, boolean opaque) {
        this.mOpaque = opaque;
        setSize(width, height);
    }

    @Override // com.android.gallery3d.glrenderer.Texture
    public boolean isOpaque() {
        return this.mOpaque;
    }

    @Override // com.android.gallery3d.glrenderer.BasicTexture
    public boolean isFlippedVertically() {
        return this.mIsFlipped;
    }

    public void setIsFlippedVertically(boolean isFlipped) {
        this.mIsFlipped = isFlipped;
    }

    protected void prepare(GLCanvas canvas) {
        GLId glId = canvas.getGLId();
        this.mId = glId.generateTexture();
        canvas.initializeTextureSize(this, 6408, 5121);
        canvas.setTextureParameters(this);
        this.mState = 1;
        setAssociatedCanvas(canvas);
    }

    @Override // com.android.gallery3d.glrenderer.BasicTexture
    protected boolean onBind(GLCanvas canvas) {
        if (isLoaded()) {
            return true;
        }
        Log.w(TAG, "lost the content due to context change");
        return false;
    }

    @Override // com.android.gallery3d.glrenderer.BasicTexture
    public void yield() {
    }

    @Override // com.android.gallery3d.glrenderer.BasicTexture
    protected int getTarget() {
        return 3553;
    }
}
