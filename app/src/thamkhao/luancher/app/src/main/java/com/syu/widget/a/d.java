package com.syu.widget.a;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class d extends n {
    @Override // com.syu.widget.a.n
    public void a(Context context, int i) {
        l lVarA = l.a(i);
        if (lVarA == null) {
            Log.i("mm", "DateNaviProvider update");
            lVarA = new e(context, i);
        }
        lVarA.d();
    }
}
