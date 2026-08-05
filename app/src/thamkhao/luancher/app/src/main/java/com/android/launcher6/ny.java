package com.android.launcher6;

import android.content.Context;
import android.os.Process;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ny extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    nz f426a;
    TextView b;
    int c;
    final /* synthetic */ nv d;
    private ld e;

    public ny(nv nvVar, Context context) {
        this(nvVar, context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ny(nv nvVar, Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = nvVar;
        float f = getResources().getDisplayMetrics().density;
        this.b = new TextView(getContext());
        this.b.setTextColor(-1);
        this.b.setTextSize(0, 10.0f * f);
        this.b.setGravity(19);
        int i = (int) (2.0f * f);
        setPadding(i, 0, i, 0);
        this.f426a = new nz(this, getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, (int) (14.0f * f), 1.0f);
        addView(this.b, layoutParams);
        layoutParams.leftMargin = (int) (4.0f * f);
        layoutParams.weight = 0.0f;
        layoutParams.width = (int) (f * 200.0f);
        addView(this.f426a, layoutParams);
    }

    public void a() {
        this.b.setText("(" + this.c + (this.c == Process.myPid() ? "/A" : "/S") + ") up " + getUptimeString() + " P=" + this.e.d + " U=" + this.e.e);
        this.f426a.invalidate();
    }

    public int getPid() {
        return this.c;
    }

    public String getUptimeString() {
        long jA = this.e.a() / 1000;
        StringBuilder sb = new StringBuilder();
        long j = jA / 86400;
        if (j > 0) {
            jA -= 86400 * j;
            sb.append(j);
            sb.append("d");
        }
        long j2 = jA / 3600;
        if (j2 > 0) {
            jA -= j2 * 3600;
            sb.append(j2);
            sb.append("h");
        }
        long j3 = jA / 60;
        if (j3 > 0) {
            jA -= j3 * 60;
            sb.append(j3);
            sb.append("m");
        }
        sb.append(jA);
        sb.append("s");
        return sb.toString();
    }

    public void setPid(int i) {
        this.c = i;
        this.e = this.d.b.a(this.c);
        if (this.e == null) {
            Log.v("WeightWatcher", "Missing info for pid " + this.c + ", removing view: " + this);
            this.d.a();
        }
    }
}
