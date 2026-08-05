package com.android.launcher6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class nz extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Paint f427a;
    Paint b;
    Paint c;
    final /* synthetic */ ny d;

    public nz(ny nyVar, Context context) {
        this(nyVar, context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nz(ny nyVar, Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = nyVar;
        this.f427a = new Paint();
        this.f427a.setColor(-6697984);
        this.b = new Paint();
        this.b.setColor(-6750208);
        this.c = new Paint();
        this.c.setColor(-1);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.d.e == null) {
            return;
        }
        int length = this.d.e.f.length;
        float f = width / length;
        float fMax = Math.max(1.0f, f);
        float f2 = height / this.d.e.h;
        for (int i = 0; i < length; i++) {
            float f3 = i * f;
            canvas.drawRect(f3, height - (this.d.e.f[i] * f2), f3 + fMax, height, this.f427a);
            canvas.drawRect(f3, height - (this.d.e.g[i] * f2), f3 + fMax, height, this.b);
        }
        float f4 = this.d.e.i * f;
        canvas.drawRect(f4, 0.0f, f4 + fMax, height, this.c);
    }
}
