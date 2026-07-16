package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;
import com.syu.util.Print;
import com.syu.util.ToolkitMath;

/* JADX INFO: loaded from: classes.dex */
public class Air_0379_BNR_GM extends AirBase {
    public Air_0379_BNR_GM(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 300;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0036_wc2_gm/air_gl8_wc.webp";
        this.mPathHighlight = "0036_wc2_gm/air_gl8_wc_p.webp";
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
        if (this.DATA[107] != 0) {
            this.srPath.addRect(21.0f, 29.0f, 193.0f, 86.0f, Path.Direction.CW);
        }
        if (this.DATA[89] == 0) {
            this.srPath.addRect(699.0f, 7.0f, 830.0f, 63.0f, Path.Direction.CW);
        }
        if (this.DATA[91] != 0) {
            this.srPath.addRect(371.0f, 15.0f, 475.0f, 93.0f, Path.Direction.CW);
        }
        if (this.DATA[93] == 1) {
            this.srPath.addRect(727.0f, 149.0f, 822.0f, 180.0f, Path.Direction.CW);
        }
        if (this.DATA[99] != 0) {
            this.srPath.addRect(525.0f, 105.0f, 587.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[100] != 0) {
            this.srPath.addRect(559.0f, 147.0f, 599.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[101] != 0) {
            this.srPath.addRect(529.0f, 163.0f, 573.0f, 194.0f, Path.Direction.CW);
        }
        if (this.DATA[110] != 0) {
            this.srPath.addRect(596.0f, 104.0f, 673.0f, 135.0f, Path.Direction.CW);
        }
        if (this.DATA[129] != 0) {
            this.srPath.addRect(558.0f, 203.0f, 645.0f, 230.0f, Path.Direction.CW);
        }
        if (this.DATA[130] != 0) {
            this.srPath.addRect(597.0f, 240.0f, 642.0f, 257.0f, Path.Direction.CW);
        }
        if (this.DATA[131] != 0) {
            this.srPath.addRect(570.0f, 258.0f, 611.0f, 288.0f, Path.Direction.CW);
        }
        if (this.DATA[134] == 1) {
            this.srPath.addRect(923.0f, 239.0f, 1020.0f, 274.0f, Path.Direction.CW);
        }
        int value = ToolkitMath.clamp(this.DATA[133], 0, 7);
        if (value < 0) {
            value = 0;
        } else if (value > 6) {
            value = 6;
        }
        this.srPath.addRect(790.0f, 211.0f, (value * 20) + 790, 288.0f, Path.Direction.CW);
        if (this.DATA[95] != 0) {
            this.srPath.addRect(189.0f, 23.0f, 248.0f, 84.0f, Path.Direction.CW);
        }
        if (this.DATA[96] != 0) {
            this.srPath.addRect(951.0f, 26.0f, 1004.0f, 83.0f, Path.Direction.CW);
        }
        int value2 = this.DATA[95];
        Print.log("LG", "LEFT value=" + value2);
        if (value2 < 0 || value2 > 3) {
            value2 = 0;
        }
        this.srPath.addRect(249.0f, 57.0f, (value2 * 20) + 249, 84.0f, Path.Direction.CW);
        int value3 = this.DATA[96];
        Print.log("LG", "RIGHT value=" + value3);
        if (value3 < 0 || value3 > 3) {
            value3 = 0;
        }
        this.srPath.addRect(886.0f, 59.0f, (value3 * 20) + 886, 86.0f, Path.Direction.CW);
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
        int frontLevel = this.DATA[112];
        if (frontLevel == 0) {
            c.drawText("OFF", 440.0f, 155.0f, this.mPaint);
        } else if (frontLevel == 19) {
            c.drawText("AUTO", 440.0f, 155.0f, this.mPaint);
        } else {
            c.drawText("Lev" + frontLevel, 440.0f, 155.0f, this.mPaint);
        }
        int temp = this.DATA[97];
        if (temp == 254) {
            c.drawText("LOW", 225.0f, 155.0f, this.mPaint);
        } else if (temp == 255) {
            c.drawText("HI", 225.0f, 155.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp / 10), Integer.valueOf(temp % 10)), 225.0f, 155.0f, this.mPaint);
        }
        int temp2 = this.DATA[98];
        if (temp2 == 254) {
            c.drawText("LOW", 915.0f, 155.0f, this.mPaint);
        } else if (temp2 == 255) {
            c.drawText("HI", 915.0f, 155.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 915.0f, 155.0f, this.mPaint);
        }
        int temp3 = this.DATA[128];
        if (temp3 == 254) {
            c.drawText("LOW", 350.0f, 260.0f, this.mPaint);
        } else if (temp3 == 255) {
            c.drawText("HI", 350.0f, 260.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp3 / 10), Integer.valueOf(temp3 % 10)), 350.0f, 260.0f, this.mPaint);
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
