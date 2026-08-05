package com.syu.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends BroadcastReceiver {
    boolean b;
    Context c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f543a = false;
    List d = new ArrayList();

    public b(Context context) {
        this.c = context.getApplicationContext();
    }

    public void a(Context context) {
        context.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f543a = true;
    }

    public void a(c cVar) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.b = b(this.c);
        if (cVar == null || this.d.contains(cVar)) {
            return;
        }
        this.d.add(cVar);
        cVar.a(this.b);
    }

    public boolean b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean zB = b(context);
        if (zB != this.b) {
            this.b = zB;
            if (this.d == null || this.d.size() <= 0) {
                return;
            }
            Iterator it = new ArrayList(this.d).iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(this.b);
            }
        }
    }
}
