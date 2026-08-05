package com.android.launcher6;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
class ds implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Hotseat f187a;
    private final /* synthetic */ String b;
    private final /* synthetic */ TextView c;

    ds(Hotseat hotseat, String str, TextView textView) {
        this.f187a = hotseat;
        this.b = str;
        this.c = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f187a.b != null) {
            Intent intent = (Intent) view.getTag();
            if (this.b == null || this.b.equals("")) {
                return;
            }
            if ("navi".equals(this.b)) {
                com.syu.a.a.a(this.f187a.b).k.a(0, 24, 0);
            } else {
                com.syu.g.a.a(this.f187a.b, this.c, intent, this.b);
            }
        }
    }
}
