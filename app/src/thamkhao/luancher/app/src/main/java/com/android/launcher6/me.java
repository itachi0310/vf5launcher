package com.android.launcher6;

import android.content.pm.ActivityInfo;

/* JADX INFO: loaded from: classes.dex */
class me extends md {
    ActivityInfo b;

    public me(ActivityInfo activityInfo) {
        this.b = activityInfo;
    }

    @Override // com.android.launcher6.ec
    public String toString() {
        return "Shortcut: " + this.b.packageName;
    }
}
