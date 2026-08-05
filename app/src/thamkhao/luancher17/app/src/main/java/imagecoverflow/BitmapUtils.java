package imagecoverflow;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.support.v4.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class BitmapUtils {
    public static Bitmap createReflectedBitmap(Bitmap srcBitmap, float reflectHeight) {
        if (srcBitmap == null) {
            return null;
        }
        int srcWidth = srcBitmap.getWidth();
        int srcHeight = srcBitmap.getHeight();
        int reflectionWidth = srcBitmap.getWidth();
        int reflectionHeight = reflectHeight == 0.0f ? srcHeight / 3 : (int) (srcHeight * reflectHeight);
        if (srcWidth == 0 || srcHeight == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        try {
            Bitmap reflectionBitmap = Bitmap.createBitmap(srcBitmap, 0, srcHeight - reflectionHeight, reflectionWidth, reflectionHeight, matrix, false);
            if (reflectionBitmap == null) {
                return null;
            }
            Canvas canvas = new Canvas(reflectionBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            LinearGradient shader = new LinearGradient(0.0f, 0.0f, 0.0f, reflectionBitmap.getHeight(), 1895825407, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.MIRROR);
            paint.setShader(shader);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawRect(0.0f, 0.0f, reflectionBitmap.getWidth(), reflectionBitmap.getHeight(), paint);
            return reflectionBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
