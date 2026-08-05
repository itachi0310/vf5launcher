package com.fyt.widget;

import android.text.format.DateFormat;

/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DigitClock f496a;

    e(DigitClock digitClock) {
        this.f496a = digitClock;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f496a.postInvalidate();
        DateFormat.is24HourFormat(this.f496a.f488a);
        char[] charArray = com.syu.widget.a.a.a.a(this.f496a.f488a).toCharArray();
        int length = charArray.length;
        if (length == 3) {
            this.f496a.c.setVisibility(8);
            this.f496a.c.setBackgroundResource(0);
        } else if (length > 3) {
            this.f496a.c.setVisibility(0);
        }
        this.f496a.c.setBackgroundResource(this.f496a.b[Math.max(0, Math.min(Integer.parseInt(new String(new char[]{charArray[0]})), this.f496a.b.length))]);
        this.f496a.d.setBackgroundResource(this.f496a.b[Math.max(0, Math.min(Integer.parseInt(new String(new char[]{charArray[1]})), this.f496a.b.length))]);
        this.f496a.f.setBackgroundResource(this.f496a.b[Math.max(0, Math.min(Integer.parseInt(new String(new char[]{charArray[2]})), this.f496a.b.length))]);
        this.f496a.g.setBackgroundResource(this.f496a.b[Math.max(0, Math.min(Integer.parseInt(new String(new char[]{charArray[3]})), this.f496a.b.length))]);
        this.f496a.h.postDelayed(this.f496a.k, 1000L);
    }
}
