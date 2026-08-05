package com.android.launcher6;

import android.content.ContentValues;

/* JADX INFO: loaded from: classes.dex */
class kl implements kj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ kk f356a;

    kl(kk kkVar) {
        this.f356a = kkVar;
    }

    @Override // com.android.launcher6.kj
    public void a(ContentValues contentValues) {
        if (contentValues.getAsInteger("container").intValue() == -100) {
            contentValues.put("screen", Integer.valueOf((int) this.f356a.c(contentValues.getAsInteger("screen").intValue())));
        }
    }
}
