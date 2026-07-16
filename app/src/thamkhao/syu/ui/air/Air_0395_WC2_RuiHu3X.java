package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: classes.dex */
public class Air_0395_WC2_RuiHu3X extends AirBase {
    public Air_0395_WC2_RuiHu3X(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_ruihu_3x.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_ruihu_3x_p.webp";
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
        if (this.DATA[23] != 0) {
            this.srPath.addRect(186.0f, 15.0f, 329.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[24] != 0) {
            this.srPath.addRect(705.0f, 22.0f, 836.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(547.0f, 9.0f, 624.0f, 61.0f, Path.Direction.CW);
        }
        if (this.DATA[33] != 0) {
            this.srPath.addRect(560.0f, 138.0f, 631.0f, 164.0f, Path.Direction.CW);
        }
        if (this.DATA[27] != 0) {
            this.srPath.addRect(41.0f, 97.0f, 131.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[25] != 0) {
            this.srPath.addRect(205.0f, 106.0f, 314.0f, 155.0f, Path.Direction.CW);
        }
        if (this.DATA[30] != 0) {
            this.srPath.addRect(897.0f, 92.0f, 987.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[29] != 0) {
            this.srPath.addRect(897.0f, 11.0f, 985.0f, 78.0f, Path.Direction.CW);
        }
        if (this.DATA[36] != 0) {
            this.srPath.addRect(568.0f, 75.0f, 621.0f, 98.0f, Path.Direction.CW);
        }
        if (this.DATA[35] != 0) {
            this.srPath.addRect(545.0f, 96.0f, 592.0f, 132.0f, Path.Direction.CW);
        }
        if (this.DATA[28] != 0) {
            this.srPath.addRect(699.0f, 92.0f, 841.0f, 159.0f, Path.Direction.CW);
        }
        int value = this.DATA[39];
        this.srPath.addRect(364.0f, 71.0f, (value * 19) + 364, 137.0f, Path.Direction.CW);
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
        int left_temp = this.DATA[40];
        if (left_temp == -2) {
            c.drawText("LOW", 76.0f, 72.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 72.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp / 10.0f).toString(), 76.0f, 72.0f, this.mPaint);
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
