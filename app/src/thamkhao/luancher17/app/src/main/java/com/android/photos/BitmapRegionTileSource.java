package com.android.photos;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.android.gallery3d.common.BitmapUtils;
import com.android.gallery3d.glrenderer.BasicTexture;
import com.android.gallery3d.glrenderer.BitmapTexture;
import com.android.photos.views.TiledImageRenderer;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(15)
public class BitmapRegionTileSource implements TiledImageRenderer.TileSource {
    private static final int GL_SIZE_LIMIT = 2048;
    private static final int MAX_PREVIEW_SIZE = 1024;
    private static final boolean REUSE_BITMAP;
    private static final String TAG = "BitmapRegionTileSource";
    private Canvas mCanvas;
    BitmapRegionDecoder mDecoder;
    int mHeight;
    private BitmapFactory.Options mOptions;
    private Rect mOverlapRegion;
    private BasicTexture mPreview;
    private final int mRotation;
    int mTileSize;
    private Rect mWantRegion;
    int mWidth;

    static {
        REUSE_BITMAP = Build.VERSION.SDK_INT >= 16;
    }

    public BitmapRegionTileSource(Context context, String path, int previewSize, int rotation) {
        this(null, context, path, null, 0, previewSize, rotation);
    }

    public BitmapRegionTileSource(Context context, Uri uri, int previewSize, int rotation) {
        this(null, context, null, uri, 0, previewSize, rotation);
    }

    public BitmapRegionTileSource(Resources res, Context context, int resId, int previewSize, int rotation) {
        this(res, context, null, null, resId, previewSize, rotation);
    }

    private BitmapRegionTileSource(Resources res, Context context, String path, Uri uri, int resId, int previewSize, int rotation) {
        this.mWantRegion = new Rect();
        this.mOverlapRegion = new Rect();
        this.mTileSize = TiledImageRenderer.suggestedTileSize(context);
        this.mRotation = rotation;
        try {
            if (path != null) {
                this.mDecoder = BitmapRegionDecoder.newInstance(path, true);
            } else if (uri != null) {
                InputStream is = context.getContentResolver().openInputStream(uri);
                BufferedInputStream bis = new BufferedInputStream(is);
                this.mDecoder = BitmapRegionDecoder.newInstance((InputStream) bis, true);
            } else {
                InputStream is2 = res.openRawResource(resId);
                BufferedInputStream bis2 = new BufferedInputStream(is2);
                this.mDecoder = BitmapRegionDecoder.newInstance((InputStream) bis2, true);
            }
            this.mWidth = this.mDecoder.getWidth();
            this.mHeight = this.mDecoder.getHeight();
        } catch (IOException e) {
            Log.w(TAG, "ctor failed", e);
        }
        this.mOptions = new BitmapFactory.Options();
        this.mOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        this.mOptions.inPreferQualityOverSpeed = true;
        this.mOptions.inTempStorage = new byte[16384];
        if (previewSize != 0) {
            Bitmap preview = decodePreview(res, context, path, uri, resId, Math.min(previewSize, 1024));
            if (preview.getWidth() <= 2048 && preview.getHeight() <= 2048) {
                this.mPreview = new BitmapTexture(preview);
            } else {
                Log.w(TAG, String.format("Failed to create preview of apropriate size!  in: %dx%d, out: %dx%d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(preview.getWidth()), Integer.valueOf(preview.getHeight())));
            }
        }
    }

    @Override // com.android.photos.views.TiledImageRenderer.TileSource
    public int getTileSize() {
        return this.mTileSize;
    }

    @Override // com.android.photos.views.TiledImageRenderer.TileSource
    public int getImageWidth() {
        return this.mWidth;
    }

    @Override // com.android.photos.views.TiledImageRenderer.TileSource
    public int getImageHeight() {
        return this.mHeight;
    }

    @Override // com.android.photos.views.TiledImageRenderer.TileSource
    public BasicTexture getPreview() {
        return this.mPreview;
    }

    @Override // com.android.photos.views.TiledImageRenderer.TileSource
    public int getRotation() {
        return this.mRotation;
    }

    @Override // com.android.photos.views.TiledImageRenderer.TileSource
    public Bitmap getTile(int level, int x, int y, Bitmap bitmap) {
        int tileSize = getTileSize();
        if (!REUSE_BITMAP) {
            return getTileWithoutReusingBitmap(level, x, y, tileSize);
        }
        int t = tileSize << level;
        this.mWantRegion.set(x, y, x + t, y + t);
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(tileSize, tileSize, Bitmap.Config.ARGB_8888);
        }
        this.mOptions.inSampleSize = 1 << level;
        this.mOptions.inBitmap = bitmap;
        try {
            Bitmap bitmap2 = this.mDecoder.decodeRegion(this.mWantRegion, this.mOptions);
            if (this.mOptions.inBitmap != bitmap2 && this.mOptions.inBitmap != null) {
                this.mOptions.inBitmap = null;
            }
            if (bitmap2 == null) {
                Log.w(TAG, "fail in decoding region");
            }
            return bitmap2;
        } catch (Throwable th) {
            if (this.mOptions.inBitmap != bitmap && this.mOptions.inBitmap != null) {
                this.mOptions.inBitmap = null;
            }
            throw th;
        }
    }

    private Bitmap getTileWithoutReusingBitmap(int level, int x, int y, int tileSize) {
        int t = tileSize << level;
        this.mWantRegion.set(x, y, x + t, y + t);
        this.mOverlapRegion.set(0, 0, this.mWidth, this.mHeight);
        this.mOptions.inSampleSize = 1 << level;
        Bitmap bitmap = this.mDecoder.decodeRegion(this.mOverlapRegion, this.mOptions);
        if (bitmap == null) {
            Log.w(TAG, "fail in decoding region");
        }
        if (!this.mWantRegion.equals(this.mOverlapRegion)) {
            Bitmap result = Bitmap.createBitmap(tileSize, tileSize, Bitmap.Config.ARGB_8888);
            if (this.mCanvas == null) {
                this.mCanvas = new Canvas();
            }
            this.mCanvas.setBitmap(result);
            this.mCanvas.drawBitmap(bitmap, (this.mOverlapRegion.left - this.mWantRegion.left) >> level, (this.mOverlapRegion.top - this.mWantRegion.top) >> level, (Paint) null);
            this.mCanvas.setBitmap(null);
            return result;
        }
        return bitmap;
    }

    private Bitmap decodePreview(Resources res, Context context, String file, Uri uri, int resId, int targetSize) {
        this.mOptions.inSampleSize = BitmapUtils.computeSampleSizeLarger(targetSize / Math.max(this.mWidth, this.mHeight));
        this.mOptions.inJustDecodeBounds = false;
        Bitmap result = null;
        if (file != null) {
            result = BitmapFactory.decodeFile(file, this.mOptions);
        } else if (uri != null) {
            try {
                InputStream is = context.getContentResolver().openInputStream(uri);
                BufferedInputStream bis = new BufferedInputStream(is);
                result = BitmapFactory.decodeStream(bis, null, this.mOptions);
            } catch (IOException e) {
                Log.w(TAG, "getting preview failed", e);
            }
        } else {
            result = BitmapFactory.decodeResource(res, resId, this.mOptions);
        }
        if (result == null) {
            return null;
        }
        float scale = targetSize / Math.max(result.getWidth(), result.getHeight());
        if (scale <= 0.5d) {
            result = BitmapUtils.resizeBitmapByScale(result, scale, true);
        }
        return ensureGLCompatibleBitmap(result);
    }

    private static Bitmap ensureGLCompatibleBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.getConfig() != null) {
            return bitmap;
        }
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        bitmap.recycle();
        return bitmapCopy;
    }
}
