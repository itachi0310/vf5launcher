package com.fyt.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.launcher6.LauncherApplication;
import com.android.launcher6.R;

/* JADX INFO: loaded from: classes.dex */
public class DigitClock extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f488a;
    private int[] b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private Handler h;
    private int i;
    private int j;
    private Runnable k;

    public DigitClock(Context context) {
        super(context);
        this.b = new int[]{a.b.a().fz, a.b.a().fA, a.b.a().fB, a.b.a().fC, a.b.a().fD, a.b.a().fE, a.b.a().fF, a.b.a().fG, a.b.a().fH, a.b.a().fI};
        this.k = new e(this);
        this.f488a = context;
        a(context);
        a();
    }

    public DigitClock(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new int[]{a.b.a().fz, a.b.a().fA, a.b.a().fB, a.b.a().fC, a.b.a().fD, a.b.a().fE, a.b.a().fF, a.b.a().fG, a.b.a().fH, a.b.a().fI};
        this.k = new e(this);
        this.f488a = context;
        a(context);
        a();
    }

    public DigitClock(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new int[]{a.b.a().fz, a.b.a().fA, a.b.a().fB, a.b.a().fC, a.b.a().fD, a.b.a().fE, a.b.a().fF, a.b.a().fG, a.b.a().fH, a.b.a().fI};
        this.k = new e(this);
        this.f488a = context;
        a(context);
        a();
    }

    private void a() {
        this.c = new TextView(this.f488a);
        this.d = new TextView(this.f488a);
        this.e = new TextView(this.f488a);
        this.f = new TextView(this.f488a);
        this.g = new TextView(this.f488a);
        this.c.setId(1);
        this.d.setId(2);
        this.e.setId(3);
        this.f.setId(4);
        this.g.setId(5);
        this.i = LauncherApplication.f88a.getResources().getInteger(R.integer.digit_clock_width);
        this.j = LauncherApplication.f88a.getResources().getInteger(R.integer.digit_clock_height);
        this.e.setBackgroundResource(R.drawable.timedot);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.i, this.j);
        layoutParams.addRule(20);
        addView(this.c, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.i, this.j);
        layoutParams2.addRule(17, this.c.getId());
        addView(this.d, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.i, this.j);
        layoutParams3.addRule(17, this.d.getId());
        addView(this.e, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.i, this.j);
        layoutParams4.addRule(17, this.e.getId());
        addView(this.f, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(this.i, this.j);
        layoutParams5.addRule(17, this.f.getId());
        addView(this.g, layoutParams5);
        this.e.setBackgroundResource(a.b.a().fJ);
        b();
    }

    private void a(Context context) {
    }

    private void b() {
        this.h = new Handler();
        this.h.post(this.k);
    }
}
