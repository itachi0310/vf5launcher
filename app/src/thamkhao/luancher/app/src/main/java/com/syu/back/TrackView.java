package com.syu.back;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: Launcher3.apk:bin/autolib.jar:com/syu/back/TrackView.class */
public class TrackView extends View {
    static final int DEFAULT_FLAGS = 5;
    float angle;
    int mWidth;
    int mHeight;
    Paint paint;
    Paint sPaint;
    TrackUtils utils;
    TrackUtils.TRACK_TYPE type;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$syu$back$TrackUtils$TRACK_TYPE;

    static /* synthetic */ int[] $SWITCH_TABLE$com$syu$back$TrackUtils$TRACK_TYPE() {
        int[] iArr = $SWITCH_TABLE$com$syu$back$TrackUtils$TRACK_TYPE;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[TrackUtils.TRACK_TYPE.valuesCustom().length];
        try {
            iArr2[TrackUtils.TRACK_TYPE.BENZ.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[TrackUtils.TRACK_TYPE.RECT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[TrackUtils.TRACK_TYPE.RECT_DASH.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$com$syu$back$TrackUtils$TRACK_TYPE = iArr2;
        return iArr2;
    }

    public TrackView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.angle = 35.0f;
        this.type = TrackUtils.TRACK_TYPE.BENZ;
    }

    public TrackView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.angle = 35.0f;
        this.type = TrackUtils.TRACK_TYPE.BENZ;
    }

    public TrackView(Context context) {
        super(context);
        this.angle = 35.0f;
        this.type = TrackUtils.TRACK_TYPE.BENZ;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.utils = TrackUtils.initialize();
        this.utils.setup(this.mWidth, this.mHeight);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mWidth == 0 || this.mHeight == 0) {
            return;
        }
        if (this.paint == null) {
            this.paint = new Paint(5);
            this.paint.setAntiAlias(true);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setColor(InputDeviceCompat.SOURCE_ANY);
            this.paint.setStrokeWidth(5.0f);
            this.paint.setFlags(1);
            this.paint.setFilterBitmap(true);
            this.sPaint = new Paint(5);
            this.sPaint.setAntiAlias(true);
            this.sPaint.setStyle(Paint.Style.STROKE);
            this.sPaint.setStrokeWidth(2.5f);
            this.sPaint.setFilterBitmap(true);
        }
        TrackUtils.Crcle[] cs = this.utils.calculateCrcle((float) (((double) this.angle) * 0.017453292519943295d));
        float[] ps1 = this.utils.realToCameraForJ(this.utils.getPointForAngle(cs[0], 0.0d, this.angle > 0.0f));
        Log.e("PP", String.format("ps1[i]   = %f", Float.valueOf(ps1[1])));
        canvas.save();
        canvas.translate(this.mWidth / 2, (this.mHeight - ps1[1]) + 3.0f);
        switch ($SWITCH_TABLE$com$syu$back$TrackUtils$TRACK_TYPE()[this.type.ordinal()]) {
            case 1:
                drawContent(canvas, cs);
                break;
            case 2:
                drawContentRect(canvas, cs, false);
                break;
            case 3:
                drawContentRect(canvas, cs, true);
                break;
        }
        canvas.restore();
    }

    void drawContent(Canvas canvas, TrackUtils.Crcle[] cs) {
        drawArc(canvas, cs, this.angle, true, false);
        TrackUtils.Crcle[] crcles = this.utils.calculateCrcle(0.62831855f);
        float[] dst = this.utils.getPointsOfArc(crcles[0], true);
        float[] arcPs = new float[(TrackUtils.POINT_COUNT - 1) * 2];
        System.arraycopy(dst, 2, arcPs, 0, arcPs.length);
        drawLine(arcPs, canvas, null, this.paint);
        TrackUtils.Crcle[] crcles2 = this.utils.calculateCrcle(-0.62831855f);
        float[] dst2 = this.utils.getPointsOfArc(crcles2[0], false);
        System.arraycopy(dst2, 2, arcPs, 0, arcPs.length);
        drawLine(arcPs, canvas, null, this.paint);
    }

    void drawContentRect(Canvas canvas, TrackUtils.Crcle[] cs, boolean dash) {
        float[] dst = this.utils.getPointsOfArc(cs[0], this.angle > 0.0f);
        float[] dst1 = this.utils.getPointsOfArc(cs[1], this.angle > 0.0f);
        int count = dst.length >> 1;
        int num1 = TrackUtils.first;
        int len = num1 * 2;
        this.sPaint.setColor(SupportMenu.CATEGORY_MASK);
        this.sPaint.setStrokeWidth(2.5f);
        float[] lineps = {dst[(num1 - 1) * 2], dst[((num1 - 1) * 2) + 1], dst1[(num1 - 1) * 2], dst1[((num1 - 1) * 2) + 1]};
        canvas.drawLines(lineps, this.sPaint);
        this.sPaint.setStrokeWidth(5.0f);
        float[] ps = new float[len];
        System.arraycopy(dst, 0, ps, 0, ps.length);
        drawLine(ps, dash, canvas);
        System.arraycopy(dst1, 0, ps, 0, ps.length);
        drawLine(ps, dash, canvas);
        int num2 = (TrackUtils.middle - num1) + 1;
        int len2 = num2 * 2;
        this.sPaint.setColor(InputDeviceCompat.SOURCE_ANY);
        this.sPaint.setStrokeWidth(2.5f);
        float[] lineps2 = {dst[((num1 + num2) - 2) * 2], dst[(((num1 + num2) - 2) * 2) + 1], dst1[((num1 + num2) - 2) * 2], dst1[(((num1 + num2) - 2) * 2) + 1]};
        canvas.drawLines(lineps2, this.sPaint);
        this.sPaint.setStrokeWidth(5.0f);
        float[] ps2 = new float[len2];
        System.arraycopy(dst, (num1 - 1) * 2, ps2, 0, ps2.length);
        drawLine(ps2, dash, canvas);
        System.arraycopy(dst1, (num1 - 1) * 2, ps2, 0, ps2.length);
        drawLine(ps2, dash, canvas);
        this.sPaint.setColor(-16711936);
        int num3 = ((count - num1) - num2) + 2;
        int len3 = num3 * 2;
        this.sPaint.setStrokeWidth(2.5f);
        float[] lineps3 = {dst[(count - 1) * 2], dst[((count - 1) * 2) + 1] - 0.5f, dst1[(count - 1) * 2], dst1[((count - 1) * 2) + 1] - 0.5f};
        canvas.drawLines(lineps3, this.sPaint);
        this.sPaint.setStrokeWidth(5.0f);
        float[] ps3 = new float[len3];
        System.arraycopy(dst, ((num1 + num2) - 2) * 2, ps3, 0, ps3.length);
        drawLine(ps3, dash, canvas);
        System.arraycopy(dst1, ((num1 + num2) - 2) * 2, ps3, 0, ps3.length);
        drawLine(ps3, dash, canvas);
    }

    void drawRect(Canvas canvas) {
        Rect rectOfView = TrackUtils.getUtils().rectOfView;
        float[] ps = this.utils.realToCameraForJ(this.utils.pointOfView((-this.utils.axisLen) / 2, (-this.utils.axisLen) / 2, rectOfView.bottom, rectOfView.bottom + TrackUtils.MAX_DISTANCE));
        float[] ps1 = this.utils.realToCameraForJ(this.utils.pointOfView(this.utils.axisLen / 2, this.utils.axisLen / 2, rectOfView.bottom, rectOfView.bottom + TrackUtils.MAX_DISTANCE));
        this.paint.setColor(InputDeviceCompat.SOURCE_ANY);
        drawLine(ps, canvas, null, this.paint);
        drawLine(ps1, canvas, null, this.paint);
        float[] ps3 = {ps[ps.length - 2], ps[ps.length - 1], ps1[ps1.length - 2], ps1[ps1.length - 1]};
        canvas.drawLines(ps3, this.paint);
    }

    public void drawArc(Canvas canvas, TrackUtils.Crcle[] cs, float ang, boolean close, boolean outer) {
        float[] dst = this.utils.getPointsOfArc(cs[0], this.angle > 0.0f);
        float[] arcPs = new float[(TrackUtils.POINT_COUNT - 1) * 2];
        System.arraycopy(dst, 2, arcPs, 0, arcPs.length);
        drawLine(arcPs, canvas, null, this.paint);
        float[] dst1 = this.utils.getPointsOfArc(cs[1], this.angle > 0.0f);
        System.arraycopy(dst1, 2, arcPs, 0, arcPs.length);
        drawLine(arcPs, canvas, null, this.paint);
        if (close) {
            float[] ps3 = {dst[dst.length - 2], dst[dst.length - 1] + 0.5f, dst1[dst1.length - 2], dst1[dst1.length - 1] + 0.5f};
            canvas.drawLines(ps3, this.paint);
            this.paint.setColor(SupportMenu.CATEGORY_MASK);
            float[] ps4 = {dst[2], dst[3] + 0.5f, dst1[2], dst1[3] + 0.5f};
            canvas.drawLines(ps4, this.paint);
            this.paint.setColor(InputDeviceCompat.SOURCE_ANY);
        }
        if (!outer) {
            float[] inter = this.utils.getPointsOfArc(new TrackUtils.Crcle(cs[0].cx, cs[0].cy, cs[0].radius + 100), this.angle > 0.0f);
            float[] inter1 = this.utils.getPointsOfArc(new TrackUtils.Crcle(cs[0].cx, cs[0].cy, cs[0].radius + HttpStatus.SC_MULTIPLE_CHOICES), this.angle > 0.0f);
            this.paint.setStrokeWidth(2.5f);
            for (int i = 1; i < (inter.length >> 1) - 2; i++) {
                if (i < TrackUtils.first) {
                    this.paint.setColor(SupportMenu.CATEGORY_MASK);
                } else if (i <= TrackUtils.middle) {
                    this.paint.setColor(InputDeviceCompat.SOURCE_ANY);
                } else {
                    this.paint.setColor(-16711936);
                }
                canvas.drawLine(inter[i * 2], inter[(i * 2) + 1], inter1[i * 2], inter1[(i * 2) + 1], this.paint);
            }
            float[] out = this.utils.getPointsOfArc(new TrackUtils.Crcle(cs[1].cx, cs[1].cy, cs[1].radius - 100), this.angle > 0.0f);
            float[] out1 = this.utils.getPointsOfArc(new TrackUtils.Crcle(cs[1].cx, cs[1].cy, cs[1].radius - HttpStatus.SC_MULTIPLE_CHOICES), this.angle > 0.0f);
            for (int i2 = 1; i2 < (out.length >> 1) - 2; i2++) {
                if (i2 < TrackUtils.first) {
                    this.paint.setColor(SupportMenu.CATEGORY_MASK);
                } else if (i2 <= TrackUtils.middle) {
                    this.paint.setColor(InputDeviceCompat.SOURCE_ANY);
                } else {
                    this.paint.setColor(-16711936);
                }
                canvas.drawLine(out[i2 * 2], out[(i2 * 2) + 1], out1[i2 * 2], out1[(i2 * 2) + 1], this.paint);
            }
            this.paint.setStrokeWidth(5.0f);
            this.paint.setColor(InputDeviceCompat.SOURCE_ANY);
            float[] ps5 = {inter[TrackUtils.first * 2], inter[(TrackUtils.first * 2) + 1] + 0.5f, out[TrackUtils.first * 2], out[(TrackUtils.first * 2) + 1] + 0.5f};
            canvas.drawLines(ps5, this.paint);
            float[] centers = this.utils.getPointsOfArc(new TrackUtils.Crcle(cs[0].cx, cs[0].cy, cs[0].radius + (this.utils.axisLen / 2)), this.angle > 0.0f);
            canvas.drawCircle(centers[centers.length - 2], centers[centers.length - 1], 3.0f, this.paint);
            canvas.drawCircle(centers[TrackUtils.first * 2], centers[(TrackUtils.first * 2) + 1], 3.0f, this.paint);
            this.paint.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawCircle(centers[2], centers[3], 3.0f, this.paint);
            this.paint.setColor(InputDeviceCompat.SOURCE_ANY);
        }
    }

    public void setType(TrackUtils.TRACK_TYPE type) {
        if (this.type == type) {
            return;
        }
        this.type = type;
        invalidate();
    }

    public void setAngle(float angle) {
        if (this.angle == angle) {
            return;
        }
        this.angle = (float) (angle == 0.0f ? 0.001d : angle);
        invalidate();
    }

    public void drawLine(float[] points, Canvas canvas, PathEffect effect, Paint paint) {
        int count = points == null ? 0 : points.length >> 1;
        if (count <= 0) {
            return;
        }
        Paint.Style lastStyle = paint.getStyle();
        if (lastStyle != Paint.Style.STROKE) {
            paint.setStyle(Paint.Style.STROKE);
        }
        if (effect != null) {
            paint.setPathEffect(effect);
        }
        Path path = new Path();
        path.moveTo(points[0], points[1]);
        for (int i = 1; i < count; i++) {
            path.lineTo(points[i * 2], points[(i * 2) + 1]);
        }
        canvas.drawPath(path, paint);
        if (lastStyle != Paint.Style.STROKE) {
            paint.setStyle(lastStyle);
        }
        if (effect != null) {
            paint.setPathEffect(null);
        }
    }

    void drawLine(float[] ps, boolean dash, Canvas canvas) {
        if (dash) {
            canvas.drawLines(ps, this.sPaint);
        } else {
            drawLine(ps, canvas, null, this.sPaint);
        }
    }

    void drawDashArc(Canvas canvas, TrackUtils.Crcle c, int mode) {
        float[] dst = this.utils.getPointsOfArc(new TrackUtils.Crcle(c.cx, c.cy, c.radius + (mode * 100)), this.angle > 0.0f);
        float[] dst1 = this.utils.getPointsOfArc(new TrackUtils.Crcle(c.cx, c.cy, c.radius + (mode * HttpStatus.SC_MULTIPLE_CHOICES)), this.angle > 0.0f);
        this.paint.setStrokeWidth(2.5f);
        for (int i = 1; i < (dst.length >> 1) - 2; i++) {
            canvas.drawLine(dst[i * 2], dst[(i * 2) + 1], dst1[i * 2], dst1[(i * 2) + 1], this.paint);
        }
        this.paint.setStrokeWidth(5.0f);
    }
}
