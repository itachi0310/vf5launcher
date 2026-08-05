package com.android.launcher6;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class AppAct extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Launcher.o.a(false, q.Applications, true);
        finish();
    }
}
