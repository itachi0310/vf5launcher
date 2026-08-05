package com.android.launcher6;

import android.content.DialogInterface;
import android.os.Bundle;
import com.syu.jni.SyuJniNative;

/* JADX INFO: loaded from: classes.dex */
class et implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f211a;

    et(Launcher launcher) {
        this.f211a = launcher;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (Launcher.f == -1) {
            return;
        }
        this.f211a.F = "";
        Bundle bundle = new Bundle();
        int iSyu_jni_command = SyuJniNative.getInstance().syu_jni_command(SyuJniNative.JNI_EXE_CMD_114_GET_ACTIVEKEY, null, bundle);
        if (bundle != null && iSyu_jni_command == 0) {
            Launcher.e = bundle.getInt("activekey");
        }
        com.syu.d.a.b(" --*--*-- BSP recv   activekey = " + Launcher.e + "  key_recv = " + iSyu_jni_command + "  activestep = " + this.f211a.g);
        new Thread(new ij(this.f211a)).start();
    }
}
