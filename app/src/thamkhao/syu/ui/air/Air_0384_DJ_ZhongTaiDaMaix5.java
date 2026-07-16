package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: classes.dex */
public class Air_0384_DJ_ZhongTaiDaMaix5 extends AirBase {
    public Air_0384_DJ_ZhongTaiDaMaix5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0384_dj_zhongtaidamaix5/damaix5.webp";
        this.mPathHighlight = "0384_dj_zhongtaidamaix5/damaix5_p.webp";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas c = this.mContentCanvas;
        c.clipRect(this.mRectDrawable, Region.Op.REPLACE);
        c.drawColor(0, PorterDuff.Mode.CLEAR);
        c.save();
        this.mPath.reset();
        this.srPath.reset();
        c.clipRect(this.mRectDrawable);
        if (this.DATA[10] != 0) {
            this.srPath.addRect(8.0f, 101.0f, 166.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(906.0f, 93.0f, 982.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0) {
            this.srPath.addRect(715.0f, 18.0f, 826.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(198.0f, 32.0f, 324.0f, 141.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(362.0f, 36.0f, 419.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(375.0f, 69.0f, 442.0f, 92.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(349.0f, 92.0f, 412.0f, 135.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 1) {
            this.srPath.addRect(691.0f, 95.0f, 842.0f, 156.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        this.srPath.addRect(549.0f, 67.0f, (value * 18) + 549, 128.0f, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.UNION);
        c.clipPath(this.mPath);
        this.mDrawableHighlight.draw(c);
        c.restore();
        this.srPath.reset();
        this.srPath.addRect(this.mRectDrawable, Path.Direction.CW);
        this.mPath.op(this.srPath, Path.Op.XOR);
        c.clipRect(this.mRectDrawable);
        c.clipPath(this.mPath);
        this.mDrawableNormal.draw(c);
        this.mPaint.setTextSize(30.0f);
        int left_temp = this.DATA[27];
        int temp = left_temp >> 1;
        if (temp == 18) {
            c.drawText("LOW", 56.0f, 70.0f, this.mPaint);
            c.drawText("LOW", 930.0f, 70.0f, this.mPaint);
        } else if (temp == 32) {
            c.drawText("HI", 56.0f, 70.0f, this.mPaint);
            c.drawText("HI", 930.0f, 70.0f, this.mPaint);
        } else if ((left_temp & 1) == 1) {
            c.drawText(temp + ".5", 56.0f, 70.0f, this.mPaint);
            c.drawText(temp + ".5", 930.0f, 70.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp).toString(), 56.0f, 70.0f, this.mPaint);
            c.drawText(new StringBuilder().append(temp).toString(), 930.0f, 70.0f, this.mPaint);
        }
        canvas.save();
        if (TheApp.getConfiguration() == 1) {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenWidth() / 1024.0f);
        } else {
            canvas.scale(TheApp.getScreenWidth() / 1024.0f, TheApp.getScreenHeight() / 600.0f);
        }
        canvas.drawBitmap(this.mContent, 0.0f, 0.0f, this.mPaint);
        canvas.restore();
        if (0 != 0) {
            invalidate();
        }
    }
}
