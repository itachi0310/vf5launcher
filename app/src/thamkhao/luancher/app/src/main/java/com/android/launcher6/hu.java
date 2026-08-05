package com.android.launcher6;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
class hu extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ht f293a;
    private final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    hu(ht htVar, String str, String str2) {
        super(str);
        this.f293a = htVar;
        this.b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        SharedPreferences.Editor editorEdit = this.f293a.f292a.ck.edit();
        editorEdit.putBoolean(this.b, true);
        editorEdit.commit();
    }
}
