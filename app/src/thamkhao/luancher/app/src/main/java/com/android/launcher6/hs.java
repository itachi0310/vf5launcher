package com.android.launcher6;

import android.content.Intent;
import android.os.SystemProperties;

/* JADX INFO: loaded from: classes.dex */
class hs extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ hr f291a;
    private final /* synthetic */ Intent b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    hs(hr hrVar, String str, Intent intent) {
        super(str);
        this.f291a = hrVar;
        this.b = intent;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.b.getComponent().getPackageName().equals("com.syu.music")) {
            SystemProperties.set("persist.sys.clingmusic", new StringBuilder(String.valueOf(SystemProperties.getInt("persist.sys.clingmusic", 0) + 1)).toString());
            return;
        }
        if (this.b.getComponent().getPackageName().equals("com.syu.video")) {
            SystemProperties.set("persist.sys.clingvideo", new StringBuilder(String.valueOf(SystemProperties.getInt("persist.sys.clingvideo", 0) + 1)).toString());
            return;
        }
        if (this.b.getComponent().getPackageName().equals("com.autonavi.amapauto")) {
            SystemProperties.set("persist.sys.clinggaode", new StringBuilder(String.valueOf(SystemProperties.getInt("persist.sys.clinggaode", 0) + 1)).toString());
            return;
        }
        if (this.b.getComponent().getPackageName().equals("com.syu.radio")) {
            SystemProperties.set("persist.sys.clingradio", new StringBuilder(String.valueOf(SystemProperties.getInt("persist.sys.clingradio", 0) + 1)).toString());
            return;
        }
        if (this.b.getComponent().getPackageName().equals("com.syu.bt")) {
            SystemProperties.set("persist.sys.clingbt", new StringBuilder(String.valueOf(SystemProperties.getInt("persist.sys.clingbt", 0) + 1)).toString());
        } else if (this.b.getComponent().getPackageName().equals("cn.kuwo.kwmusiccar")) {
            SystemProperties.set("persist.sys.clingkuwo", new StringBuilder(String.valueOf(SystemProperties.getInt("persist.sys.clingkuwo", 0) + 1)).toString());
        } else if (this.b.getComponent().getPackageName().equals("com.edog.car")) {
            SystemProperties.set("persist.sys.clingkaola", new StringBuilder(String.valueOf(SystemProperties.getInt("persist.sys.clingkaola", 0) + 1)).toString());
        }
    }
}
