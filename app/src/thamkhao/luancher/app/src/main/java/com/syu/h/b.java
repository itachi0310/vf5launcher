package com.syu.h;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import com.syu.f.e;
import com.syu.f.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b implements e {
    static List b;
    g e;
    Context f;
    Dialog g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static b f542a = null;
    static boolean c = false;
    static int d = 0;
    static boolean h = false;

    static {
        b = null;
        b = new ArrayList();
        a("com.syu.car");
        a("com.syu.radio");
        a("cn.com.tiros.android.navidog");
        a("cn.com.tiros.android.navidog4x");
        a("com.autonavi.xmgd.navigator");
        a("com.baidu.navi");
        a("cld.navi.mobile.mainframe");
        a("com.mapbar.android.mapbarmap");
        a("com.mapbar.android.carnavi");
        a("title.navi");
        a("com.mxnavi.mxnavi");
        a("com.autonavi.amapauto");
        a("cn.kuwo.player");
        a("cn.kuwo.kwmusichd");
        a("cn.kuwo.kwmusiccar");
        a("com.kuwo.kwmusiccar");
        a("com.kugou.android");
        a("com.duomi.android");
        a("cmccwm.mobilemusic");
        a("fm.xiami.main");
        a("com.tencent.qqmusic");
        a("com.tencent.qqmusicpad");
        a("com.tencent.karaoke");
        a("com.ximalaya.ting.android");
        a("com.ting.mp3.android");
        a("com.qiyi.video");
        a("com.tencent.qqlivehd");
        a("com.youku.pad");
        a("com.youku.phone");
        a("com.tudou.xoom.android");
        a("com.sds.android.ttpod");
        a("tv.pps.mobile");
        a("com.baidu.video");
        a("com.letv.android.client");
        a("com.sohu.sohuvideo");
    }

    b(@NonNull Context context) {
        this.e = null;
        this.f = null;
        this.f = context.getApplicationContext();
        if (h) {
            this.e = new g(this.f, "com.syu.unicar.ToolkitService", "com.syu.unicar");
            this.e.b(0, 2);
            this.e.a(0, this, 2);
            this.e.a();
        }
    }

    public static b a(Context context) {
        String str;
        try {
            str = (String) a.a((Object) null, a.a("android.os.SystemProperties", "get", String.class, String.class), "ro.client.foreign", "false");
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        h = !"true".equals(str) && Build.VERSION.SDK_INT >= 22;
        if (f542a == null) {
            f542a = new b(context);
        }
        return f542a;
    }

    public static void a(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (b == null) {
            b = new ArrayList();
        }
        if (b.contains(str)) {
            return;
        }
        b.add(str);
    }

    void a() {
        this.f.getSharedPreferences(this.f.getPackageName(), 0).edit().clear().commit();
    }

    @Override // com.syu.f.e
    public void a(int i, int[] iArr, float[] fArr, String[] strArr) {
        if (i != 2 || iArr == null || iArr.length <= 0) {
            return;
        }
        boolean z = iArr[0] == 1;
        if (z != c) {
            c = z;
        }
        if (iArr.length > 1) {
            d = iArr[1];
        }
        a();
    }
}
