package com.syu.ui.air;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Region;
import com.syu.canbus.TheApp;

/* JADX INFO: loaded from: classes.dex */
public class Air_0207_SBD_WC1_ChangChengC30 extends AirBase {
    public Air_0207_SBD_WC1_ChangChengC30(Context context) {
        super(context);
    }

    @Override // com.syu.ui.air.AirBase
    protected void initSize() {
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
    }

    @Override // com.syu.ui.air.AirBase
    protected void initDrawable() {
        this.mPathNormal = "0209_sbd_wc1_changchengc30/air_sbd_wc1_changchengc30.webp";
        this.mPathHighlight = "0209_sbd_wc1_changchengc30/air_sbd_wc1_changchengc30_p.webp";
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
        if (this.DATA[65] != 0) {
            this.srPath.addRect(225.0f, 90.0f, 343.0f, 158.0f, Path.Direction.CW);
        }
        if (this.DATA[16] != 0) {
            this.srPath.addRect(689.0f, 88.0f, 802.0f, 162.0f, Path.Direction.CW);
        }
        if (this.DATA[11] != 0) {
            this.srPath.addRect(384.0f, 18.0f, 481.0f, 70.0f, Path.Direction.CW);
        }
        if (this.DATA[10] != 0) {
            this.srPath.addRect(512.0f, 19.0f, 650.0f, 70.0f, Path.Direction.CW);
        }
        switch (this.DATA[12]) {
            case 1:
                this.srPath.addRect(425.0f, 92.0f, 567.0f, 161.0f, Path.Direction.CW);
                break;
            case 3:
                this.srPath.addRect(427.0f, 90.0f, 614.0f, 157.0f, Path.Direction.CW);
                break;
        }
        if (this.DATA[18] != 0) {
            this.srPath.addRect(250.0f, 6.0f, 298.0f, 33.0f, Path.Direction.CW);
        }
        if (this.DATA[19] != 0) {
            this.srPath.addRect(265.0f, 32.0f, 310.0f, 54.0f, Path.Direction.CW);
        }
        if (this.DATA[20] != 0) {
            this.srPath.addRect(236.0f, 50.0f, 281.0f, 79.0f, Path.Direction.CW);
        }
        if (this.DATA[22] != 0) {
            this.srPath.addRect(742.0f, 8.0f, 795.0f, 32.0f, Path.Direction.CW);
        }
        if (this.DATA[23] != 0) {
            this.srPath.addRect(733.0f, 30.0f, 777.0f, 55.0f, Path.Direction.CW);
        }
        if (this.DATA[24] != 0) {
            this.srPath.addRect(764.0f, 49.0f, 800.0f, 79.0f, Path.Direction.CW);
        }
        int WindLevel = this.DATA[21];
        if (WindLevel < 0) {
            WindLevel = 0;
        } else if (WindLevel > 8) {
            WindLevel = 8;
        }
        this.srPath.addRect(39.0f, 14.0f, (WindLevel * 17) + 39, 78.0f, Path.Direction.CW);
        int WindLevel2 = this.DATA[25];
        if (WindLevel2 < 0) {
            WindLevel2 = 0;
        } else if (WindLevel2 > 8) {
            WindLevel2 = 8;
        }
        this.srPath.addRect(864.0f, 14.0f, (WindLevel2 * 17) + 864, 82.0f, Path.Direction.CW);
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
        if (temp == -1) {
            c.drawText("No", 90.0f, 149.0f, this.mPaint);
        } else if (temp == -2) {
            c.drawText("Low", 90.0f, 149.0f, this.mPaint);
        } else if (temp == -3) {
            c.drawText("HI", 90.0f, 149.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp)).toString(), 90.0f, 149.0f, this.mPaint);
        }
        int temp2 = this.DATA[28];
        if (temp2 == -1) {
            c.drawText("No", 915.0f, 149.0f, this.mPaint);
        } else if (temp2 == -2) {
            c.drawText("Low", 915.0f, 149.0f, this.mPaint);
        } else if (temp2 == -3) {
            c.drawText("HI", 915.0f, 149.0f, this.mPaint);
        } else {
            c.drawText(new StringBuilder(String.valueOf(temp2)).toString(), 915.0f, 149.0f, this.mPaint);
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
