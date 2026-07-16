package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: classes.dex */
public class Air_0338_JYKJ_XP1_RongWwi360 extends AirBase {
    public Air_0338_JYKJ_XP1_RongWwi360(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0338_jykj_xp1_rongwei360/air_jykj_xp1_rongwei360_n.webp";
        this.mPathHighlight = "0338_jykj_xp1_rongwei360/air_jykj_xp1_rongwei360_p.webp";
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
            this.srPath.addRect(881.0f, 25.0f, 1017.0f, 72.0f, Path.Direction.CW);
        }
        if (this.DATA[4] != 0) {
            this.srPath.addRect(23.0f, 22.0f, 120.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[2] != 0) {
            this.srPath.addRect(307.0f, 38.0f, 437.0f, 141.0f, Path.Direction.CW);
        }
        if (this.DATA[3] != 0) {
            this.srPath.addRect(455.0f, 38.0f, 569.0f, 135.0f, Path.Direction.CW);
        }
        if (this.DATA[8] != 0) {
            this.srPath.addRect(752.0f, 52.0f, 803.0f, 82.0f, Path.Direction.CW);
        }
        if (this.DATA[6] != 0) {
            this.srPath.addRect(771.0f, 81.0f, 823.0f, 103.0f, Path.Direction.CW);
        }
        if (this.DATA[7] != 0) {
            this.srPath.addRect(750.0f, 100.0f, 793.0f, 141.0f, Path.Direction.CW);
        }
        if (this.DATA[1] != 1) {
            this.srPath.addRect(154.0f, 53.0f, 288.0f, 130.0f, Path.Direction.CW);
        }
        int value = this.DATA[9];
        this.srPath.addRect(624.0f, 72.0f, (value * 21) + 624, 123.0f, Path.Direction.CW);
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
        int left_temp = this.DATA[5];
        if (left_temp == -2) {
            c.drawText("LOW", 46.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 46.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp).toString(), 46.0f, 152.0f, this.mPaint);
        }
        int right_temp = this.DATA[10];
        if (right_temp == -2) {
            c.drawText("LOW", 930.0f, 152.0f, this.mPaint);
        } else if (right_temp == -3) {
            c.drawText("HI", 930.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(right_temp).toString(), 930.0f, 152.0f, this.mPaint);
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
