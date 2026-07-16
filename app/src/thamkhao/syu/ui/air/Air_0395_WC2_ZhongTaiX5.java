package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: classes.dex */
public class Air_0395_WC2_ZhongTaiX5 extends AirBase {
    public Air_0395_WC2_ZhongTaiX5(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0395_wc2_guochan/air_guochan_zhongtai_x5.webp";
        this.mPathHighlight = "0395_wc2_guochan/air_guochan_zhongtai_x5_p.webp";
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
            this.srPath.addRect(12.0f, 21.0f, 158.0f, 75.0f, Path.Direction.CW);
        }
        if (this.DATA[37] != 0) {
            this.srPath.addRect(332.0f, 15.0f, 426.0f, 74.0f, Path.Direction.CW);
        }
        if (this.DATA[27] != 0) {
            this.srPath.addRect(213.0f, 48.0f, 280.0f, 112.0f, Path.Direction.CW);
        }
        if (this.DATA[30] != 0) {
            this.srPath.addRect(888.0f, 13.0f, 987.0f, 77.0f, Path.Direction.CW);
        }
        if (this.DATA[29] != 0) {
            this.srPath.addRect(890.0f, 92.0f, 991.0f, 160.0f, Path.Direction.CW);
        }
        if (this.DATA[36] != 0) {
            this.srPath.addRect(342.0f, 82.0f, 410.0f, 113.0f, Path.Direction.CW);
        }
        if (this.DATA[35] != 0) {
            this.srPath.addRect(336.0f, 113.0f, 393.0f, 156.0f, Path.Direction.CW);
        }
        if (this.DATA[28] == 0) {
            this.srPath.addRect(691.0f, 37.0f, 832.0f, 134.0f, Path.Direction.CW);
        }
        int value = this.DATA[39];
        this.srPath.addRect(508.0f, 44.0f, (value * 19) + 508, 140.0f, Path.Direction.CW);
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
            c.drawText("LOW", 76.0f, 152.0f, this.mPaint);
        } else if (left_temp == -3) {
            c.drawText("HI", 76.0f, 152.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder().append(left_temp / 10.0f).toString(), 76.0f, 152.0f, this.mPaint);
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
