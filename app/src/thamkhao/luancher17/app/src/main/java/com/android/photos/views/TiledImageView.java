package com.android.photos.views;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.View;
import android.widget.FrameLayout;
import com.android.gallery3d.glrenderer.BasicTexture;
import com.android.gallery3d.glrenderer.GLES20Canvas;
import com.syu.ipc.data.FinalCanbus;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes.dex */
public class TiledImageView extends FrameLayout {
    private static final boolean IS_SUPPORTED;
    private static final boolean USE_CHOREOGRAPHER;
    private static final boolean USE_TEXTURE_VIEW = false;
    private Choreographer.FrameCallback mFrameCallback;
    private Runnable mFreeTextures;
    private GLSurfaceView mGLSurfaceView;
    private boolean mInvalPending;
    protected Object mLock;
    protected ImageRendererWrapper mRenderer;
    private RectF mTempRectF;
    private BlockingGLTextureView mTextureView;
    private float[] mValues;

    static {
        IS_SUPPORTED = Build.VERSION.SDK_INT >= 16;
        USE_CHOREOGRAPHER = Build.VERSION.SDK_INT >= 16;
    }

    protected static class ImageRendererWrapper {
        public int centerX;
        public int centerY;
        TiledImageRenderer image;
        Runnable isReadyCallback;
        public int rotation;
        public float scale;
        public TiledImageRenderer.TileSource source;

        protected ImageRendererWrapper() {
        }
    }

    public static boolean isTilingSupported() {
        return IS_SUPPORTED;
    }

    public TiledImageView(Context context) {
        this(context, null);
    }

    public TiledImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mInvalPending = false;
        this.mValues = new float[9];
        this.mLock = new Object();
        this.mFreeTextures = new Runnable() { // from class: com.android.photos.views.TiledImageView.1
            @Override // java.lang.Runnable
            public void run() {
                TiledImageView.this.mRenderer.image.freeTextures();
            }
        };
        this.mTempRectF = new RectF();
        if (IS_SUPPORTED) {
            this.mRenderer = new ImageRendererWrapper();
            this.mRenderer.image = new TiledImageRenderer(this);
            this.mGLSurfaceView = new GLSurfaceView(context);
            this.mGLSurfaceView.setEGLContextClientVersion(2);
            this.mGLSurfaceView.setRenderer(new TileRenderer(this, null));
            this.mGLSurfaceView.setRenderMode(0);
            View view = this.mGLSurfaceView;
            addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void destroy() {
        if (IS_SUPPORTED) {
            this.mGLSurfaceView.queueEvent(this.mFreeTextures);
        }
    }

    public void onPause() {
        if (IS_SUPPORTED) {
            this.mGLSurfaceView.onPause();
        }
    }

    public void onResume() {
        if (IS_SUPPORTED) {
            this.mGLSurfaceView.onResume();
        }
    }

    public void setTileSource(TiledImageRenderer.TileSource source, Runnable isReadyCallback) {
        if (IS_SUPPORTED) {
            synchronized (this.mLock) {
                this.mRenderer.source = source;
                this.mRenderer.isReadyCallback = isReadyCallback;
                this.mRenderer.centerX = source != null ? source.getImageWidth() / 2 : 0;
                this.mRenderer.centerY = source != null ? source.getImageHeight() / 2 : 0;
                this.mRenderer.rotation = source != null ? source.getRotation() : 0;
                this.mRenderer.scale = 0.0f;
                updateScaleIfNecessaryLocked(this.mRenderer);
            }
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (IS_SUPPORTED) {
            synchronized (this.mLock) {
                updateScaleIfNecessaryLocked(this.mRenderer);
            }
        }
    }

    private void updateScaleIfNecessaryLocked(ImageRendererWrapper renderer) {
        if (renderer != null && renderer.source != null && renderer.scale <= 0.0f && getWidth() != 0) {
            renderer.scale = Math.min(getWidth() / renderer.source.getImageWidth(), getHeight() / renderer.source.getImageHeight());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (IS_SUPPORTED) {
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void setTranslationX(float translationX) {
        if (IS_SUPPORTED) {
            super.setTranslationX(translationX);
        }
    }

    @Override // android.view.View
    public void invalidate() {
        if (IS_SUPPORTED) {
            if (USE_CHOREOGRAPHER) {
                invalOnVsync();
            } else {
                this.mGLSurfaceView.requestRender();
            }
        }
    }

    @TargetApi(16)
    private void invalOnVsync() {
        if (!this.mInvalPending) {
            this.mInvalPending = true;
            if (this.mFrameCallback == null) {
                this.mFrameCallback = new Choreographer.FrameCallback() { // from class: com.android.photos.views.TiledImageView.2
                    @Override // android.view.Choreographer.FrameCallback
                    public void doFrame(long frameTimeNanos) {
                        TiledImageView.this.mInvalPending = false;
                        TiledImageView.this.mGLSurfaceView.requestRender();
                    }
                };
            }
            Choreographer.getInstance().postFrameCallback(this.mFrameCallback);
        }
    }

    public void positionFromMatrix(Matrix matrix) {
        int cx;
        int cy;
        if (IS_SUPPORTED && this.mRenderer.source != null) {
            int rotation = this.mRenderer.source.getRotation();
            boolean swap = rotation % FinalCanbus.CAR_FYTA_ChangChengFengJun6 != 0;
            int width = swap ? this.mRenderer.source.getImageHeight() : this.mRenderer.source.getImageWidth();
            int height = swap ? this.mRenderer.source.getImageWidth() : this.mRenderer.source.getImageHeight();
            this.mTempRectF.set(0.0f, 0.0f, width, height);
            matrix.mapRect(this.mTempRectF);
            matrix.getValues(this.mValues);
            int cx2 = width / 2;
            int cy2 = height / 2;
            float scale = this.mValues[0];
            int xoffset = Math.round(((getWidth() - this.mTempRectF.width()) / 2.0f) / scale);
            int yoffset = Math.round(((getHeight() - this.mTempRectF.height()) / 2.0f) / scale);
            if (rotation == 90 || rotation == 180) {
                cx = (int) (cx2 + ((this.mTempRectF.left / scale) - xoffset));
            } else {
                cx = (int) (cx2 - ((this.mTempRectF.left / scale) - xoffset));
            }
            if (rotation == 180 || rotation == 270) {
                cy = (int) (cy2 + ((this.mTempRectF.top / scale) - yoffset));
            } else {
                cy = (int) (cy2 - ((this.mTempRectF.top / scale) - yoffset));
            }
            this.mRenderer.scale = scale;
            this.mRenderer.centerX = swap ? cy : cx;
            ImageRendererWrapper imageRendererWrapper = this.mRenderer;
            if (!swap) {
                cx = cy;
            }
            imageRendererWrapper.centerY = cx;
            invalidate();
        }
    }

    private class TileRenderer implements GLSurfaceView.Renderer {
        private GLES20Canvas mCanvas;

        private TileRenderer() {
        }

        /* synthetic */ TileRenderer(TiledImageView tiledImageView, TileRenderer tileRenderer) {
            this();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            this.mCanvas = new GLES20Canvas();
            BasicTexture.invalidateAllTextures();
            TiledImageView.this.mRenderer.image.setModel(TiledImageView.this.mRenderer.source, TiledImageView.this.mRenderer.rotation);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            this.mCanvas.setSize(width, height);
            TiledImageView.this.mRenderer.image.setViewSize(width, height);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl) {
            Runnable readyCallback;
            this.mCanvas.clearBuffer();
            synchronized (TiledImageView.this.mLock) {
                readyCallback = TiledImageView.this.mRenderer.isReadyCallback;
                TiledImageView.this.mRenderer.image.setModel(TiledImageView.this.mRenderer.source, TiledImageView.this.mRenderer.rotation);
                TiledImageView.this.mRenderer.image.setPosition(TiledImageView.this.mRenderer.centerX, TiledImageView.this.mRenderer.centerY, TiledImageView.this.mRenderer.scale);
            }
            boolean complete = TiledImageView.this.mRenderer.image.draw(this.mCanvas);
            if (complete && readyCallback != null) {
                synchronized (TiledImageView.this.mLock) {
                    if (TiledImageView.this.mRenderer.isReadyCallback == readyCallback) {
                        TiledImageView.this.mRenderer.isReadyCallback = null;
                    }
                }
                if (readyCallback != null) {
                    TiledImageView.this.post(readyCallback);
                }
            }
        }
    }

    private static class ColoredTiles implements TiledImageRenderer.TileSource {
        private static final int[] COLORS = {SupportMenu.CATEGORY_MASK, -16776961, InputDeviceCompat.SOURCE_ANY, -16711936, -16711681, -65281, -1};
        private Paint mPaint = new Paint();
        private Canvas mCanvas = new Canvas();

        private ColoredTiles() {
        }

        @Override // com.android.photos.views.TiledImageRenderer.TileSource
        public int getTileSize() {
            return 256;
        }

        @Override // com.android.photos.views.TiledImageRenderer.TileSource
        public int getImageWidth() {
            return 16384;
        }

        @Override // com.android.photos.views.TiledImageRenderer.TileSource
        public int getImageHeight() {
            return 8192;
        }

        @Override // com.android.photos.views.TiledImageRenderer.TileSource
        public int getRotation() {
            return 0;
        }

        @Override // com.android.photos.views.TiledImageRenderer.TileSource
        public Bitmap getTile(int level, int x, int y, Bitmap bitmap) {
            int tileSize = getTileSize();
            if (bitmap == null) {
                bitmap = Bitmap.createBitmap(tileSize, tileSize, Bitmap.Config.ARGB_8888);
            }
            this.mCanvas.setBitmap(bitmap);
            this.mCanvas.drawColor(COLORS[level]);
            this.mPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.mPaint.setTextSize(20.0f);
            this.mPaint.setTextAlign(Paint.Align.CENTER);
            this.mCanvas.drawText(String.valueOf(x) + "x" + y, 128.0f, 128.0f, this.mPaint);
            int tileSize2 = tileSize << level;
            this.mCanvas.drawText(String.valueOf(x / tileSize2) + "x" + (y / tileSize2) + " @ " + level, 128.0f, 30.0f, this.mPaint);
            this.mCanvas.setBitmap(null);
            return bitmap;
        }

        @Override // com.android.photos.views.TiledImageRenderer.TileSource
        public BasicTexture getPreview() {
            return null;
        }
    }
}
