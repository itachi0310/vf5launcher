package com.android.launcher17;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class AppAct extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Launcher.mLauncher.showAllApps(false, AppsCustomizePagedView.ContentType.Applications, true);
        finish();
    }
}
