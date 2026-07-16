package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: classes.dex */
public class Air_0004_FYT1_DongNanV5 extends AirBase {
    public Air_0004_FYT1_DongNanV5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0004_fyt_dongnanv5/air_fyt1_dongnanv5_n.webp";
        this.mPathHighlight = "0004_fyt_dongnanv5/air_fyt1_dongnanv5_p.webp";
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
        if (this.DATA[15] != 0) {
            this.srPath.addRect(755.0f, 57.0f, 856.0f, 113.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(912.0f, 49.0f, 989.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(459.0f, 68.0f, 513.0f, 97.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(457.0f, 98.0f, 500.0f, 136.0f, Path.Direction.CW);
        }
        if (this.DATA[12] == 0) {
            this.srPath.addRect(152.0f, 44.0f, 288.0f, 120.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(309.0f, 34.0f, 429.0f, 133.0f, Path.Direction.CW);
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(457.0f, 14.0f, 539.0f, 67.0f, Path.Direction.CW);
        }
        int value = this.DATA[21];
        if (value < 1) {
            value = 1;
        } else if (value > 9) {
            value = 9;
        }
        this.srPath.addRect(583.0f, 66.0f, ((value - 1) * 18) + 583, 126.0f, Path.Direction.CW);
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
        int temp = this.DATA[27];
        if (temp == 1) {
            c.drawText("LOW", 60.0f, 100.0f, this.mPaint);
        } else if (temp == 9) {
            c.drawText("HI", 60.0f, 100.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf((temp + 180) / 10), Integer.valueOf((temp + 180) % 10)), 60.0f, 100.0f, this.mPaint);
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
