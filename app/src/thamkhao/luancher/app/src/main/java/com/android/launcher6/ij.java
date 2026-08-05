package com.android.launcher6;

import android.os.Bundle;
import android.util.Log;
import com.syu.jni.SyuJniNative;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ij implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Launcher f306a;

    public ij(Launcher launcher) {
        this.f306a = launcher;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            String string = "";
            try {
                if ("".equals("")) {
                    this.f306a.F = "激活失败!请检测网络是否已连接！";
                    this.f306a.ee.post(this.f306a.G);
                    return;
                }
                JSONObject jSONObject = new JSONObject("");
                string = jSONObject.getString("status");
                if (string.equals("-1")) {
                    this.f306a.F = "设备不允许激活!";
                } else if (string.equals("-2")) {
                    this.f306a.F = "设备钥匙已失效!";
                } else if (string.equals("-3")) {
                    this.f306a.F = "Launcher区间无效!";
                } else if (string.equals("-4")) {
                    this.f306a.F = "获取激活码失败!";
                } else if (string.equals("-5")) {
                    this.f306a.F = "设备钥匙无法正常使用!";
                } else if (string.equals("1")) {
                    if (jSONObject != null) {
                        Launcher.b = jSONObject.getString("activecode");
                    }
                    Launcher.e = Integer.parseInt(jSONObject.getString("key"));
                    this.f306a.F = new String(jSONObject.getString("content").toString().getBytes(HTTP.UTF_8));
                }
                if (string.equals("1")) {
                    Bundle bundle = new Bundle();
                    Bundle bundle2 = new Bundle();
                    bundle.putInt("areaindex", Launcher.d);
                    bundle.putInt("activekey", Launcher.e);
                    bundle.putByteArray("serialno", this.f306a.a(Launcher.f86a));
                    bundle.putByteArray("activecode", this.f306a.a(Launcher.b));
                    int iSyu_jni_command = SyuJniNative.getInstance().syu_jni_command(SyuJniNative.JNI_EXE_CMD_113_ACTIVE_AREA, bundle, bundle2);
                    if (bundle != null && iSyu_jni_command == 0) {
                        Launcher.c = bundle2.getInt("isactived", 0);
                    }
                    Log.d("wl", " 113 BSP recv  isactive = " + Launcher.c + " recv = " + iSyu_jni_command);
                    if (Launcher.c == 1) {
                        Launcher launcher = this.f306a;
                        launcher.F = String.valueOf(launcher.F) + "软件激活成功!";
                    } else {
                        this.f306a.F = "软件激活失败!";
                    }
                }
                this.f306a.ee.post(this.f306a.G);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
