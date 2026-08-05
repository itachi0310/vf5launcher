package com.android.launcher6;

import android.appwidget.AppWidgetProviderInfo;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Advanceable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class em extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f204a;

    em(Launcher launcher) {
        this.f204a = launcher;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        int i = 0;
        Iterator it = this.f204a.cd.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                this.f204a.c(20000L);
                return;
            }
            View view = (View) it.next();
            View viewFindViewById = view.findViewById(((AppWidgetProviderInfo) this.f204a.cd.get(view)).autoAdvanceViewId);
            int i3 = i2 * 250;
            if (viewFindViewById instanceof Advanceable) {
                postDelayed(new en(this, viewFindViewById), i3);
            }
            i = i2 + 1;
        }
    }
}
