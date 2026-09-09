package com.vf5regenlauncher.util.launcher;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;

import com.vf5regenlauncher.AppEmbedManager;
import com.vf5regenlauncher.util.FytPackage;
import com.vf5regenlauncher.util.android.os.SystemProperties;
import com.vf5regenlauncher.util.litepal.LitePalApplication;
import com.vf5regenlauncher.util.CrashHandler;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class LauncherApplication extends LitePalApplication {

    public static LauncherApplication sApp;
    public static String sSubplatform;
    private final String apkName = "firenze.apk";
    private String apkPath;
    private WindowManager.LayoutParams params;
    private Typeface typeface;
    private WindowManager wm;

    public static Handler handler = new Handler(Looper.getMainLooper());
    public static boolean sForeign = false;
    public static int appWidget_Host_Id = 0;
    public static float shadow_Large_Radius = 0.0f;
    public static float shadow_Small_Radius = 0.0f;

    private AppEmbedManager appEmbedManager;

    public String getApkPath() {
        return this.apkPath;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        initHostId();
        initData();
        initProperties();
    }

    private void initHostId() {
        try {
            Resources res = getResources();
            int id = res.getIdentifier("appwidget_host_id", "integer", getPackageName());
            if (id > 0) {
                appWidget_Host_Id = res.getInteger(id) + 1024;
            } else {
                appWidget_Host_Id = 1041;
            }
        } catch (Exception e) {
            appWidget_Host_Id = 1041;
        }
    }

    private void initProperties() {
        sSubplatform = SystemProperties.get("sys.fyt.subplatform", "0");
        sForeign = true;
//        frontview_endble = Boolean.valueOf(SystemProperties.getBoolean("persist.fyt.zh_frontview_enable", true));
//        justfrontView = Boolean.valueOf(SystemProperties.getBoolean("persist.fyt.justfrontView", false));
//        boolean textShadow = Utils.getNameToBool("apps_textview_shadow");
//        if (textShadow) {
//            shadow_Large_Radius = 4.0f;
//            shadow_Small_Radius = 1.75f;
//        }
//        appEnable(FytPackage.auxAction, justfrontView.booleanValue() ? 0 : 1);
//        appEnable(FytPackage.frontvideoAction, frontview_endble.booleanValue() ? 1 : 0);
    }

    private void initData() {
        sApp = this;
        CrashHandler.getInstance(getApplicationContext());
        LauncherAppState.setApplicationContext(this);
        LauncherAppState.getInstance();

        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        this.apkPath = String.valueOf(sApp.getFilesDir().getAbsolutePath()) + File.separator + "firenze.apk";
        new File(this.apkPath);
//        FileUtil.copyFileFromAssets(this, "firenze.apk", this.apkPath);
//        appEmbedManager = new AppEmbedManager(sApp);
//        initGaoDeCoverView();
    }

//    public void addGaoDeCoverView() {
//        this.wm.addView(this.btn_floatView, this.params);
//    }

    public void removeGaoDeCoverView() {
//        this.wm.removeView(this.btn_floatView);
    }

//    private void initGaoDeCoverView() {
//        if (appEmbedManager != null) {
//            appEmbedManager.updatePipRect();
//        }
//        this.btn_floatView = new TextView(sApp);
//        this.btn_floatView.setBackgroundColor(Color.WHITE);
//        this.wm = (WindowManager) sApp.getSystemService("window");
//        this.params = new WindowManager.LayoutParams();
//        if (Build.VERSION.SDK_INT >= 26) {
//            this.params.type = 2038;
//        } else {
//            this.params.type = 2003;
//        }
//        this.params.format = 1;
//        this.params.flags = 40;
//        this.params.width = 45;
//        this.params.height = 45;
//        this.params.x = InstallShortcutReceiver.NEW_SHORTCUT_BOUNCE_DURATION;
//        this.params.y = -230;
//    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }

    public static void appEnable(String packageName, int enable) {
        int state = enable == 0 ? 2 : 1;
        try {
            if (state != sApp.getPackageManager().getApplicationEnabledSetting(packageName)) {
                sApp.getPackageManager().setApplicationEnabledSetting(packageName, state, 1);
            }
        } catch (Exception e) {
        }
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        LauncherAppState.getInstance().onTerminate();
    }
}
