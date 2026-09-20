package com.vf5regenlauncher.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FytPackage {
    public static final String AddAction = "com.syu.add";
    public static final String AppAction = "com.android.launcher17";
    public static final String AppClassName = "com.android.launcher29.AppAct";
    public static final String BTAVNEXTSERVICE = "com.syu.bt.byav.widgetNext";
    public static final String BTAVPLAYSERVICE = "com.syu.bt.byav.widgetPlayPause";
    public static final String BTAVPRESERVICE = "com.syu.bt.byav.widgetPrev";
    public static final String CARLIFEACTION = "com.baidu.carlifevehicle";
    public static final String CARRADIOACTION = "com.syu.carradio";
    public static final String DVRSERVICE = "com.syu.dvr.server.CollisionVideoService";
    public static final String GaodeACTION = "com.autonavi.amapauto";
    public static final String INNER360 = "com.syu.panoramic";
    public static final String INNER_DVR = "com.syu.dvr";
    public static final String KLFMACTION = "com.edog.car";
    public static final String KWACTION = "cn.kuwo.kwmusiccar";
    public static final String LAUNCHERMUSIC = "com.fyt.launcher.music";
    public static List<String> LOADED_LIST = null;
    public static final String LOCKACTION = "android.com.syu.dvr.action.LOCKE";
    public static final String NEXTSERVICE = "com.syu.music.next";
    public static final String OUT360 = "com.syu.camera360";
    public static final String OUTER_DVR = "com.syu.exdvr";
    public static final String PHOTOACTION = "android.com.syu.dvr.action.PHOTO";
    public static final String PLAYSERVICE = "com.syu.music.playpause";
    public static final String PRESERVICE = "com.syu.music.prev";
    public static final String RECACTION = "android.com.syu.dvr.action.RECORD";
    public static final String RechargeACTION = "com.syu.unicar";
    public static final String UNICARACTION = "com.syu.unicar";
    public static final String YKACTION = "com.youku.phone";
    public static final String abenchACTION = "com.antutu.ABenchMark";
    public static final String allappAction = "com.syu.allapps";
    public static final String auxAction = "com.syu.av";
    public static final String av2Action = "com.syu.av2";
    public static final String browserAction = "com.android.browser";
    public static final String btAction = "com.syu.bt";
    public static final String btavAction = "com.syu.btav";
    public static final String calculatorAction = "com.android.calculator2";
    public static final String calibrationAction = "com.syu.calibration";
    public static final String camera360 = "com.syu.camera360";
    public static final String carAction = "com.syu.car";
    public static final String carBus = "com.syu.canbus";
    public static final String carlifeACTION = "com.baidu.carlifevehicle";
    public static final String cdcAction = "com.syu.cdc";
    public static final String chromeAction = "com.android.chrome";
    public static final String dvdAction = "com.syu.dvd";
    public static final String easyAction = "net.easyconn";
    public static final String easyconnACTION = "net.easyconn";
    public static final String ecarAction = "com.coagent.ecar";
    public static final String ecarOnlineClassName = "com.coagent.ecarnet.car.activity.WelcomeActivity";
    public static final String eqACTION = "com.syu.eq";
    public static final String extireAction = "com.cz.usbserial.tpms";
    public static final String filemanagerAction = "com.syu.filemanager";
    public static final String fourcamera2Action = "com.syu.fourcamera2";
    public static final String frontvideoAction = "com.syu.frontvideo";
    public static final String galleryAction = "com.syu.gallery";
    public static final String gpsAction = "com.syu.gps";
    public static final String guideAction = "com.syu.guide";
    public static final String hongfansAction = "com.hongfans.rearview";
    public static final String ipodAction = "com.syu.ipod";
    public static final String ludashiACTION = "com.ludashi.benchmark";
    public static final String mapsAction = "com.google.android.apps.maps";
    public static final String miudriveAction = "com.didi365.miudrive.navi";
    public static final String mp3Action = "com.syu.music";
    public static final String naviAction = "com.syu.onekeynavi";
    public static final String radarAction = "com.syu.radar";
    public static final String radioAction = "com.syu.radio";
    public static final String settingAction = "com.syu.settings";
    public static final String sosAction = "com.ecar.assistantnew";
    public static final String spotifyAction = "com.spotify.music";
    public static final String steerACTION = "com.syu.steer";
    public static final String sysSetAction = "com.android.settings";
    public static final String tireAction = "com.syu.tire";
    public static final String tvAction = "com.syu.tv";
    public static final String videoAction = "com.syu.video";
    public static final String voiceAction = "com.syu.voice";
    public static final String youtubeAction = "com.google.android.youtube";

    public static final String googlemapAction = "com.google.android.maps";



    static {
        LOADED_LIST = null;
        LOADED_LIST = new ArrayList();
        LOADED_LIST.add("com.syu.music");
        LOADED_LIST.add(dvdAction);
        LOADED_LIST.add(auxAction);
        LOADED_LIST.add("com.syu.bt");
        LOADED_LIST.add("com.syu.settings");
        LOADED_LIST.add(tvAction);
        LOADED_LIST.add("com.syu.video");
        LOADED_LIST.add(steerACTION);
    }


    public static Intent getIntent(Context context, String pkg) {
        if (pkg == null || pkg.isEmpty()) return null;

        PackageManager packageManager = context.getPackageManager();

        // Trường hợp đặc biệt cho Settings hệ thống
        if (pkg.equals(sysSetAction)) {
            Intent intent = new Intent("android.settings.SETTINGS");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            return intent;
        }

        // Ưu tiên dùng getLaunchIntentForPackage để lấy Activity chính thức (được Exported)
        Intent intent = packageManager.getLaunchIntentForPackage(pkg);

        if (intent == null) {
            // Fallback: Tìm thủ công qua ACTION_MAIN nếu getLaunchIntent thất bại
            Intent mainIntent = new Intent("android.intent.action.MAIN", (Uri) null);
            mainIntent.setPackage(pkg);
            List<ResolveInfo> apps = packageManager.queryIntentActivities(mainIntent, 0);
            for (ResolveInfo res : apps) {
                // Chỉ lấy Activity nếu nó được Exported để tránh lỗi Permission Denial
                if (res.activityInfo.packageName.equals(pkg) && res.activityInfo.exported) {
                    intent = new Intent("android.intent.action.MAIN");
                    intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
                    break;
                }
            }
        }

        if (intent != null) {
            // Flag đặc trưng của hệ thống FYT/SYU để hỗ trợ chạy PIP/cửa sổ nổi
            intent.setFlags(270532608); 
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        return intent;
    }

//    public static Intent getIntent(Context context, String pkg) {
//        if (pkg == null || pkg.isEmpty()) return null;
//
//        PackageManager packageManager = context.getPackageManager();
//
//        // Trường hợp đặc biệt cho Settings hệ thống
//        if (pkg.equals(sysSetAction)) {
//            Intent intent = new Intent("android.settings.SETTINGS");
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            return intent;
//        }
//
//        // Tìm Intent để khởi chạy ứng dụng (Launcher Intent)
//        Intent intent = packageManager.getLaunchIntentForPackage(pkg);
//
//        if (intent == null) {
//            // Nếu getLaunchIntentForPackage thất bại, thử tìm thủ công qua ACTION_MAIN
//            Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
//            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//            mainIntent.setPackage(pkg);
//
//            List<ResolveInfo> apps = packageManager.queryIntentActivities(mainIntent, 0);
//            if (apps != null && !apps.isEmpty()) {
//                ResolveInfo res = apps.get(0);
//                intent = new Intent(Intent.ACTION_MAIN);
//                intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
//            }
//        }
//
//        if (intent != null) {
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            // Flag đặc trưng của hệ thống FYT để hỗ trợ PIP
//            intent.addFlags(0x10200000); // 270532608 trong mã cũ của bạn
//        }
//
//        return intent;
//    }
}
