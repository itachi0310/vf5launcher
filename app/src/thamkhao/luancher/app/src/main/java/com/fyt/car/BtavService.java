package com.fyt.car;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class BtavService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f480a;
    public String b;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras.getString("btav") != null && !extras.getString("btav").equals("")) {
                this.f480a = extras.getString("btav");
            }
            if (extras.getString("btav_art") != null && !extras.getString("btav_art").equals("")) {
                this.b = extras.getString("btav_art");
            }
            a aVar = c.f;
            String[] strArr = new String[4];
            strArr[0] = this.f480a;
            strArr[1] = this.b;
            aVar.a(null, null, null, strArr, null);
        }
        return super.onStartCommand(intent, i, i2);
    }
}
