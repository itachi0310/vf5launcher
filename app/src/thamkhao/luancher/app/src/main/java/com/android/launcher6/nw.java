package com.android.launcher6;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
class nw extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ nv f424a;

    nw(nv nvVar) {
        this.f424a = nvVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f424a.f423a.sendEmptyMessage(3);
                break;
            case 2:
                this.f424a.f423a.removeMessages(3);
                break;
            case 3:
                int[] iArrA = this.f424a.b.a();
                int childCount = this.f424a.getChildCount();
                if (iArrA.length != childCount) {
                    this.f424a.a();
                } else {
                    for (int i = 0; i < childCount; i++) {
                        ny nyVar = (ny) this.f424a.getChildAt(i);
                        if (nv.a(iArrA, nyVar.getPid()) < 0) {
                            this.f424a.a();
                        } else {
                            nyVar.a();
                        }
                    }
                }
                this.f424a.f423a.sendEmptyMessageDelayed(3, 5000L);
                break;
        }
    }
}
