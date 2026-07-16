package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: classes.dex */
public class Air_0313_SBD_WC1_24vW3 extends AirBase {
    public Air_0313_SBD_WC1_24vW3(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0313_sbd_wc1_electric/sibaide_313_24vw3.webp";
        this.mPathHighlight = "0313_sbd_wc1_electric/sibaide_313_24vw3_p.webp";
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
        if (this.DATA[118] != 0) {
            this.srPath.addRect(874.0f, 22.0f, 1012.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[110] != 0) {
            this.srPath.addRect(366.0f, 97.0f, 503.0f, 170.0f, Path.Direction.CW);
        }
        if (this.DATA[112] != 0) {
            this.srPath.addRect(50.0f, 25.0f, 144.0f, 76.0f, Path.Direction.CW);
        }
        if (this.DATA[119] != 0) {
            this.srPath.addRect(194.0f, 32.0f, 321.0f, 146.0f, Path.Direction.CW);
        }
        if (this.DATA[116] != 0) {
            this.srPath.addRect(551.0f, 36.0f, 611.0f, 73.0f, Path.Direction.CW);
        }
        if (this.DATA[114] != 0) {
            this.srPath.addRect(555.0f, 77.0f, 613.0f, 97.0f, Path.Direction.CW);
        }
        if (this.DATA[115] != 0) {
            this.srPath.addRect(547.0f, 97.0f, 590.0f, 131.0f, Path.Direction.CW);
        }
        if (this.DATA[111] == 0) {
            this.srPath.addRect(353.0f, 12.0f, 512.0f, 76.0f, Path.Direction.CW);
        }
        int value = this.DATA[117];
        if (value < 0) {
            value = 0;
        } else if (value > 7) {
            value = 7;
        }
        this.srPath.addRect(714.0f, 64.0f, (value * 28) + 714, 139.0f, Path.Direction.CW);
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
        int temp = this.DATA[113];
        if (temp == 170) {
            c.drawText("LOW", 53.0f, 136.0f, this.mPaint);
        } else if (temp == 270) {
            c.drawText("HI", 53.0f, 136.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(temp / 10.0f).toString(), 53.0f, 136.0f, this.mPaint);
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
