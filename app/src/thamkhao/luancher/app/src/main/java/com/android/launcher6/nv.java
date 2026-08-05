package com.android.launcher6;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class nv extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f423a;
    private MemoryTracker b;

    public nv(Context context) {
        this(context, null);
    }

    public nv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f423a = new nw(this);
        context.bindService(new Intent(context, (Class<?>) MemoryTracker.class), new nx(this), 1);
        setOrientation(1);
        setBackgroundColor(-1073741824);
    }

    static int a(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void a() {
        removeAllViews();
        for (int i : this.b.a()) {
            ny nyVar = new ny(this, getContext());
            nyVar.setPid(i);
            addView(nyVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f423a.sendEmptyMessage(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f423a.sendEmptyMessage(2);
    }
}
