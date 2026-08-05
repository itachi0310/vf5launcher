package com.syu.e;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes.dex */
class b extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f521a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b(a aVar, long j, long j2) {
        super(j, j2);
        this.f521a = aVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f521a.dismiss();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}
