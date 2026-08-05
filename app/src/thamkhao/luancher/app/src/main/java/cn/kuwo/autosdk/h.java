package cn.kuwo.autosdk;

import android.os.Handler;
import android.os.Looper;
import cn.kuwo.autosdk.api.OnSearchListener;
import cn.kuwo.autosdk.api.SearchMode;

/* JADX INFO: loaded from: classes.dex */
public class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile k f29a = null;
    private String b = "";
    private int c = 0;
    private Handler d = new i(Looper.getMainLooper());

    @Override // cn.kuwo.autosdk.g
    public void a(String str, SearchMode searchMode, OnSearchListener onSearchListener) {
        this.b = str;
        this.c = 0;
        if (this.f29a != null) {
            this.f29a.f31a = true;
            this.f29a = null;
        }
        this.f29a = new k(this.b, this.c, searchMode);
        this.f29a.a(this.d, onSearchListener);
        r.a(s.NET, this.f29a);
    }
}
