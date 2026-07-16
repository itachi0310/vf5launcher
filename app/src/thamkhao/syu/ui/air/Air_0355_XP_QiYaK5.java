package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: classes.dex */
public class Air_0355_XP_QiYaK5 extends AirBase {
    public Air_0355_XP_QiYaK5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0447_od_rzc_19tusheng/air_19tusheng_n.webp";
        this.mPathHighlight = "0447_od_rzc_19tusheng/air_19tusheng_p.webp";
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
        if (this.DATA[11] != 0) {
            this.srPath.addRect(353.0f, 101.0f, 430.0f, 157.0f, Path.Direction.CW);
        }
        if (this.DATA[13] != 0) {
            this.srPath.addRect(191.0f, 104.0f, 295.0f, 152.0f, Path.Direction.CW);
        }
        if (this.DATA[14] == 0) {
            this.srPath.addRect(912.0f, 106.0f, 1003.0f, 149.0f, Path.Direction.CW);
        }
        if (this.DATA[65] != 0 || this.DATA[18] != 0) {
            this.srPath.addRect(619.0f, 12.0f, 718.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[76] != 0) {
            this.srPath.addRect(616.0f, 106.0f, 723.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(493.0f, 60.0f, 553.0f, 95.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(470.0f, 87.0f, 522.0f, 131.0f, Path.Direction.CW);
        }
        if (this.DATA[12] != 0) {
            this.srPath.addRect(323.0f, 15.0f, 454.0f, 77.0f, Path.Direction.CW);
        }
        this.srPath.addRect(976.0f, 38.0f, 1016.0f, 77.0f, Path.Direction.CW);
        this.srPath.addRect(268.0f, 43.0f, 301.0f, 78.0f, Path.Direction.CW);
        int value = this.DATA[21];
        this.srPath.addRect(742.0f, 51.0f, (value * 18) + 742, 115.0f, Path.Direction.CW);
        int value2 = this.DATA[44];
        this.srPath.addRect(15.0f, 97.0f, (value2 * 18) + 15, 158.0f, Path.Direction.CW);
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
        if (left_temp == 0) {
            c.drawText("LO", 218.0f, 60.0f, this.mPaint);
        } else if (left_temp == 30) {
            c.drawText("HI", 218.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.0f + (left_temp / 2.0f)).toString(), 218.0f, 60.0f, this.mPaint);
        }
        int right_temp = this.DATA[28];
        if (right_temp == 0) {
            c.drawText("LO", 934.0f, 60.0f, this.mPaint);
        } else if (right_temp == 30) {
            c.drawText("HI", 934.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.0f + (right_temp / 2.0f)).toString(), 934.0f, 60.0f, this.mPaint);
        }
        int rear_temp = this.DATA[40];
        if (rear_temp == 0) {
            c.drawText("LO", 52.0f, 60.0f, this.mPaint);
        } else if (rear_temp == 30) {
            c.drawText("HI", 52.0f, 60.0f, this.mPaint);
        } else if (rear_temp == -1 || rear_temp == 255) {
            c.drawText("--", 52.0f, 60.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(17.0f + (rear_temp / 2.0f)).toString(), 52.0f, 60.0f, this.mPaint);
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
