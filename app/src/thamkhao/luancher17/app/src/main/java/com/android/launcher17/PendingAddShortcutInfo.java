package com.android.launcher17;

import android.content.pm.ActivityInfo;

/* JADX INFO: compiled from: PendingAddItemInfo.java */
/* JADX INFO: loaded from: classes.dex */
class PendingAddShortcutInfo extends PendingAddItemInfo {
    ActivityInfo shortcutActivityInfo;

    public PendingAddShortcutInfo(ActivityInfo activityInfo) {
        this.shortcutActivityInfo = activityInfo;
    }

    @Override // com.android.launcher17.ItemInfo
    public String toString() {
        return "Shortcut: " + this.shortcutActivityInfo.packageName;
    }
}
