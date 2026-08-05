package com.syu.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f536a;

    static {
        f536a = null;
        f536a = new ArrayList();
        f536a.add("com.syu.music");
        f536a.add("com.syu.dvd");
        f536a.add("com.syu.av");
        f536a.add("com.syu.bt");
        f536a.add("com.syu.settings");
        f536a.add("com.syu.tv");
        f536a.add("com.syu.video");
        f536a.add("com.syu.steer");
    }

    public static Intent a(Context context, String str) {
        Intent intent;
        Intent intent2;
        if (str.equals("com.android.settings")) {
            intent2 = new Intent("android.settings.SETTINGS");
            intent = new Intent("android.settings.SETTINGS", (Uri) null);
        } else {
            intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent2 = new Intent("android.intent.action.MAIN");
        }
        intent.setPackage(str);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.packageName.equals(str)) {
                intent2 = new Intent("android.intent.action.MAIN");
                intent2.setFlags(270532608);
                intent2.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
            }
        }
        return intent2;
    }
}
