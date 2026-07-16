package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: classes.dex */
public class Air_0017_WC2_MaiTeng extends AirBase {
    public Air_0017_WC2_MaiTeng(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0017_wc2_golf7/air_wc2_maiteng.webp";
        this.mPathHighlight = "0017_wc2_golf7/air_wc2_maiteng_p.webp";
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
        if (this.DATA[89] != 0) {
            this.srPath.addRect(274.0f, 20.0f, 375.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[91] != 0) {
            this.srPath.addRect(153.0f, 104.0f, 233.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[88] != 0) {
            this.srPath.addRect(775.0f, 21.0f, 892.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[87] != 0) {
            this.srPath.addRect(137.0f, 24.0f, 253.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[152] != 0) {
            this.srPath.addRect(409.0f, 15.0f, 493.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[151] != 0) {
            this.srPath.addRect(769.0f, 104.0f, 892.0f, 154.0f, Path.Direction.CW);
        }
        if (this.DATA[90] != 0) {
            this.srPath.addRect(272.0f, 99.0f, 374.0f, 151.0f, Path.Direction.CW);
        }
        if (this.DATA[157] == 0) {
            this.srPath.addRect(393.0f, 97.0f, 508.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[94] != 0) {
            this.srPath.addRect(545.0f, 124.0f, 615.0f, 153.0f, Path.Direction.CW);
        }
        if (this.DATA[153] != 0) {
            this.srPath.addRect(536.0f, 18.0f, 603.0f, 69.0f, Path.Direction.CW);
        }
        if (this.DATA[95] != 0) {
            this.srPath.addRect(544.0f, 72.0f, 589.0f, 93.0f, Path.Direction.CW);
        }
        if (this.DATA[96] != 0) {
            this.srPath.addRect(524.0f, 90.0f, 571.0f, 123.0f, Path.Direction.CW);
        }
        if (this.DATA[156] != 0) {
            this.srPath.addRect(88.0f, 37.0f, 124.0f, 84.0f, Path.Direction.CW);
            this.srPath.addRect(730.0f, 37.0f, 766.0f, 84.0f, Path.Direction.CW);
            this.srPath.addRect(987.0f, 39.0f, 1020.0f, 85.0f, Path.Direction.CW);
        }
        int value = this.DATA[97];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(657.0f, 102.0f, (value * 15) + 657, 160.0f, Path.Direction.CW);
        int value2 = this.DATA[92];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(66.0f, 129.0f, 66.0f + (value2 * 19.0f), 150.0f, Path.Direction.CW);
        int value3 = this.DATA[93];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 > 3) {
            value3 = 3;
        }
        this.srPath.addRect(972.0f - (value3 * 19.0f), 125.0f, 972.0f, 162.0f, Path.Direction.CW);
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
        int temp = this.DATA[98];
        if (temp == 254) {
            c.drawText("LOW", 50.0f, 72.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 50.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp * 5) / 10.0f).toString(), 50.0f, 72.0f, this.mPaint);
        }
        int temp2 = this.DATA[99];
        if (temp2 == 254) {
            c.drawText("LOW", 950.0f, 72.0f, this.mPaint);
        } else if (temp2 == 255) {
            c.drawText("HI", 950.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp2 * 5) / 10.0f).toString(), 950.0f, 72.0f, this.mPaint);
        }
        int temp3 = this.DATA[154];
        if (temp3 == 254) {
            c.drawText("LOW", 690.0f, 72.0f, this.mPaint);
        } else if (temp3 == 255) {
            c.drawText("HI", 690.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append((temp3 * 5) / 10.0f).toString(), 690.0f, 72.0f, this.mPaint);
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
