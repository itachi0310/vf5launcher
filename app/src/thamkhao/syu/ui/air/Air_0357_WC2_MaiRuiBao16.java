package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: classes.dex */
public class Air_0357_WC2_MaiRuiBao16 extends AirBase {
    public Air_0357_WC2_MaiRuiBao16(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0357_wc2_mairuibao16/air_wc2_gm_mairuibao_n.webp";
        this.mPathHighlight = "0357_wc2_mairuibao16/air_wc2_gm_mairuibao_p.webp";
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
        if (this.DATA[71] != 0) {
            this.srPath.addRect(152.0f, 17.0f, 284.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[92] == 1) {
            this.srPath.addRect(311.0f, 24.0f, 419.0f, 66.0f, Path.Direction.CW);
        }
        if (this.DATA[72] == 1) {
            this.srPath.addRect(771.0f, 127.0f, 838.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[72] == 2) {
            this.srPath.addRect(756.0f, 94.0f, 843.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[73] != 0) {
            this.srPath.addRect(329.0f, 95.0f, 398.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[74] == 0) {
            this.srPath.addRect(740.0f, 8.0f, 862.0f, 62.0f, Path.Direction.CW);
        }
        if (this.DATA[93] != 0) {
            this.srPath.addRect(765.0f, 61.0f, 839.0f, 85.0f, Path.Direction.CW);
        }
        if (this.DATA[88] != 0) {
            this.srPath.addRect(480.0f, 65.0f, 544.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[75] != 0) {
            this.srPath.addRect(464.0f, 10.0f, 551.0f, 65.0f, Path.Direction.CW);
        }
        if (this.DATA[89] != 0) {
            this.srPath.addRect(465.0f, 96.0f, 554.0f, 159.0f, Path.Direction.CW);
        }
        if (this.DATA[79] != 0) {
            this.srPath.addRect(624.0f, 135.0f, 689.0f, 161.0f, Path.Direction.CW);
        }
        if (this.DATA[94] != 0) {
            this.srPath.addRect(619.0f, 14.0f, 686.0f, 58.0f, Path.Direction.CW);
        }
        if (this.DATA[76] != 0) {
            this.srPath.addRect(616.0f, 60.0f, 659.0f, 83.0f, Path.Direction.CW);
        }
        if (this.DATA[77] != 0) {
            this.srPath.addRect(622.0f, 82.0f, 667.0f, 97.0f, Path.Direction.CW);
        }
        if (this.DATA[78] != 0) {
            this.srPath.addRect(612.0f, 98.0f, 646.0f, 127.0f, Path.Direction.CW);
        }
        int value = this.DATA[90];
        if (value < 0) {
            value = 0;
        } else if (value > 3) {
            value = 3;
        }
        this.srPath.addRect(66.0f, 135.0f, (value * 19) + 66, 151.0f, Path.Direction.CW);
        int value2 = this.DATA[91];
        if (value2 < 0) {
            value2 = 0;
        } else if (value2 > 3) {
            value2 = 3;
        }
        this.srPath.addRect(894.0f, 132.0f, (value2 * 19) + 894, 151.0f, Path.Direction.CW);
        int value3 = this.DATA[80];
        if (value3 < 0) {
            value3 = 0;
        } else if (value3 >= 8) {
            value3 = 8;
        }
        this.srPath.addRect(163.0f, 115.0f, (value3 * 15) + 163, 166.0f, Path.Direction.CW);
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
        int temp = this.DATA[81];
        if (temp == -2) {
            c.drawText("LOW", 70.0f, 72.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 70.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp / 10), Integer.valueOf(temp % 10)), 70.0f, 72.0f, this.mPaint);
        }
        int temp2 = this.DATA[82];
        if (temp2 == -2) {
            c.drawText("LOW", 935.0f, 72.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 935.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(String.format("%d.%d", Integer.valueOf(temp2 / 10), Integer.valueOf(temp2 % 10)), 935.0f, 72.0f, this.mPaint);
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
